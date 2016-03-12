package br.com.trabalhoIntegrado.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import br.com.trabalhoIntegrado.DAO.LogDAO;

public class Log extends Observable{
	private int codigoItemLog, agencia, conta, codigoCliente, codigoMovimento, agenciaDestino, contaDestino;
	private Date dataOperacao;
	private double valor;
	private String operacao;
	private LogDAO logDAO;

	public int getCodigoItemLog() {
		return codigoItemLog;
	}
	public void setCodigoItemLog(int codigoItemLog) {
		this.codigoItemLog = codigoItemLog;
		setChanged();
		notifyObservers();
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
		setChanged();
		notifyObservers();
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
		setChanged();
		notifyObservers();
	}
	public Date getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
		setChanged();
		notifyObservers();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
		setChanged();
		notifyObservers();
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
		setChanged();
		notifyObservers();
	}
	
	public int getCodigoMovimento() {
		return codigoMovimento;
	}
	
	public void setCodigoMovimento(int codMovimento) {
		this.codigoMovimento = codMovimento;
		setChanged();
		notifyObservers();
	}
	
	
	public String getOperacao() {
		return operacao;
	}
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
		setChanged();
		notifyObservers();
	}
	
	public int getContaDestino() {
		return contaDestino;
	}
	
	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
		setChanged();
		notifyObservers();
	}
	
	public int getAgenciaDestino() {
		return agenciaDestino;
	}
	
	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
		setChanged();
		notifyObservers();
	}

	public void incluir() throws ClassNotFoundException, SQLException{
		logDAO = new LogDAO();

		logDAO.insert(getOperacao(), getValor(), getConta(), getAgencia(), getDataOperacao(), getCodigoMovimento(), getCodigoCliente()).execute();
	}

	public ArrayList<Log> consultarestatisticas() throws ClassNotFoundException, SQLException{

		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<Log> resultadoPesquisa = new ArrayList<Log>();
		LogDAO logDao = new LogDAO();
	
		ResultSet rs = null;
		rs = logDao.selec().executeQuery();
		
		//insere os valores do banco nos metodos para serem inseridos no arryList
		while(rs.next()){
			//insere os valores do banco nos metodos para serem inseridos no arryList
			Log log = new Log();

			log.setCodigoItemLog(rs.getInt(1));
			log.setCodigoMovimento(rs.getInt(2));
			log.setOperacao(rs.getString(3));
			log.setValor((rs.getInt(4)));
			log.setConta((rs.getInt(5)));
			log.setAgencia((rs.getInt(6)));
			log.setCodigoCliente(rs.getInt(7));
			log.setDataOperacao(rs.getDate(8));
			
			resultadoPesquisa.add(log);
		}
	return resultadoPesquisa;
	}
}