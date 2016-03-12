package br.com.trabalhoIntegrado.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.trabalhoIntegrado.DAO.Conexao;
import br.com.trabalhoIntegrado.DAO.ContaDAO;

public class Saque extends Movimento {

	private Dispenser dispenser;
	private int conta, agencia;

	public Saque(Movimento movimento) {
		dispenser = new Dispenser();
	} 

	public int getConta() {
		return conta;
	}

	public int getAgencia() {
		return agencia;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
		setChanged();
		notifyObservers();
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
		setChanged();
		notifyObservers();
	}

	public void fazerSaque(double valorSacar){
		ContaDAO contaDAO = new ContaDAO();

		double saldoAtual = 0;
		
		try {
			Connection conn = new Conexao().connection();

			ResultSet rs = contaDAO.selec(getConta()).executeQuery();

			while(rs.next()){  
				saldoAtual = Integer.parseInt(rs.getString(5));				 
			}  
			
			double novosaldo = 0;
			if(saldoAtual >= valorSacar){
				dispenser.contarNotas(valorSacar);

				novosaldo = saldoAtual - valorSacar;

				contaDAO.update(getConta(), novosaldo).executeUpdate();	
			  
				Date dataHoje = new Date(); 
				
				setDataDoMovimento(dataHoje);
				
				setValorDaOperacao(valorSacar);
				
				geraMovimento(getAgencia(), getConta(), 0, 0, "Debito em Conta corrente");
				
			}else{
				JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}