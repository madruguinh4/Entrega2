package br.com.trabalhoIntegrado.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;

import javax.swing.JOptionPane;

import br.com.trabalhoIntegrado.DAO.Conexao;
import br.com.trabalhoIntegrado.DAO.ContaDAO;

public class Conta extends Observable{
	private int agencia, saldo, numConta;
	private String nome;

	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAgencia() {		
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
		setChanged();
		notifyObservers();
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
		setChanged();
		notifyObservers();

	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
		setChanged();
		notifyObservers();
	}

	public String consultarSaldo(){

		String saldo = "";
		Connection conn;
		try {
			conn = new Conexao().connection();
			ContaDAO contaDAO = new ContaDAO();
			try{

				ResultSet rs = contaDAO.selec(getNumConta()).executeQuery();

				while(rs.next()){  
					setSaldo(Integer.parseInt(saldo = rs.getString(5)));				 
				}  

				conn.close();

			}catch(Exception e){
				e.printStackTrace();
				try{
					conn.rollback();
				}catch (SQLException e1){
					System.out.print(e1.getStackTrace());
				}
			}finally{
				try {
					if (contaDAO.selec(getNumConta()) != null){
						try{
							contaDAO.selec(getNumConta()).close();
						}catch (SQLException e1){
							System.out.print(e1.getStackTrace());
						}
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return saldo;
	}

	public void imprimir() throws IOException{
		SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy" + " HH.mm.ss");//cria um tipo date para colocar a data de que foi criado o arquivo no nome do arquivo 
		Calendar data = Calendar.getInstance();

		File arquivo;
		
		String nomeArq = "Saldo da conta " + getNumConta() + " do dia e hora " + formatoData.format(data.getTime()) + ".txt";
		//criando arquivo para preencher com o extrato 
		try
		{
			arquivo = new File(nomeArq);
			arquivo.createNewFile();
			JOptionPane.showMessageDialog(null,"Arquivo '"+ nomeArq + "' criado!","Arquivo",1);
		}
		//mostrando erro em caso se nao for possivel gerar arquivo
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
		}

		FileWriter output = new FileWriter(new File(nomeArq),true);
		PrintWriter gravarArq = new PrintWriter(output, true);//coloca o arquivo na variavel para preenchelo (o true permite que escreve em um arquivo de texto ja preenchido)
	
		String newLine = System.getProperty("line.separator");
	
		String saldoDoDia  = "\t" + "Saldo do dia e hora " + formatoData.format(data.getTime())
		+ newLine + newLine + "Nome: " + getNome()
		+ newLine +"Conta: " + getNumConta()
		+ newLine + "Agencia: " + getAgencia()
		+ newLine + "saldo: " + getSaldo();

		gravarArq.format("\n" + saldoDoDia);
	}
}