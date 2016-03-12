package br.com.trabalhoIntegrado.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import javax.swing.JOptionPane;

import br.com.trabalhoIntegrado.DAO.Conexao;
import br.com.trabalhoIntegrado.DAO.DebitoAutomaticoDAO;

public class DebitoAutomatico extends Observable{

	private int codigoConsumidor, codDebito;
	private String operadora, tipoDebito;
	private Date dataDebito;
	private double valorDebito;
	private DebitoAutomaticoDAO debDao;
	private Movimento movimento;
	private int numConta, numAgencia;
	

	public int getCodDebito() {
		return codDebito;
	}

	public void setCodDebito(int codDebito) {
		this.codDebito = codDebito;
	}

	public String getTipoDebito() {
		return tipoDebito;
	}
	public void setTipoDebito(String tipoDebito) {
		this.tipoDebito = tipoDebito;
		setChanged();
		notifyObservers();
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
		setChanged();
		notifyObservers();
	}
	public int getCodigoConsumidor() {
		return codigoConsumidor;
	}
	public void setCodigoConsumidor(int codigoConsumidor) {
		this.codigoConsumidor = codigoConsumidor;
		setChanged();
		notifyObservers();
	}
	public Date getDataDebito() {
		return dataDebito;
	}
	public void setDataDebito(Date dataDebito) throws ParseException {    
		this.dataDebito = dataDebito;
	}
	public double getValorDebito() {
		return valorDebito;
	}
	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}

	public int getNumConta() {
		return numConta;
	}
	
	private int getAgencia() {
		return numAgencia;
	}
	
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public ArrayList<DebitoAutomatico> consultar() throws SQLException, ClassNotFoundException{

		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<DebitoAutomatico> resultadoPesquisa = new ArrayList<DebitoAutomatico>();
		Connection conn = new Conexao().connection();

		DebitoAutomaticoDAO debDAO = new DebitoAutomaticoDAO();

		ResultSet rs = null;

		try{
			rs = debDAO.selec(getNumConta()).executeQuery();
			while (rs.next()){
				DebitoAutomatico rsp = new DebitoAutomatico();
				rsp.setCodDebito(rs.getInt(1));
				rsp.setTipoDebito(rs.getString(2));
				rsp.setOperadora(rs.getString(3));
				rsp.setCodigoConsumidor(rs.getInt(4));
				rsp.setDataDebito(rs.getDate(5));  
				rsp.setValorDebito(rs.getDouble(6));
				rsp.setNumConta(rs.getInt(7));
				resultadoPesquisa.add(rsp);
			}

			conn.close();
		}catch (Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1){
				System.out.print(e1.getStackTrace());
			}
		}
		return resultadoPesquisa;
	}

	public void gerarDebito() throws SQLException, ClassNotFoundException{
		debDao = new DebitoAutomaticoDAO();

		debDao.insert(getTipoDebito(), getOperadora(), getCodigoConsumidor(), getDataDebito(), getValorDebito(), getNumConta()).execute();

		JOptionPane.showMessageDialog(null, "Debito automatico inserido com sucesso !!");
		
		movimento = new Movimento();
		
		movimento.setValorDaOperacao(getValorDebito());
		movimento.setDataDoMovimento(getDataDebito());
		movimento.geraMovimento(getAgencia(), getNumConta(), 0, 0, "Debito Automatico");			
	}
}
