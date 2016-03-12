package br.com.trabalhoIntegrado.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.trabalhoIntegrado.DAO.ContaDAO;

public class Transferencia extends Movimento{

	private int agenciaDestino, contaDestino, conta;

	public Transferencia(Movimento movimento) {

	}

	public int getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
		setChanged();
		notifyObservers();
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}


	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
		setChanged();
		notifyObservers();
	}

	public void fazeTransferencia() throws SQLException, NumberFormatException, IOException, ClassNotFoundException{
		int saldoTitular = 0;
		int saldoContaTransferir = 0;

		FileReader txtConta = new FileReader (""+ getContaDestino());

		BufferedReader entrada = new BufferedReader(txtConta);

		ArrayList<Integer> linhasTxt = new ArrayList<Integer>();
		String texto;

		while((texto = entrada.readLine()) != null){

			linhasTxt.add(Integer.parseInt(texto, 16));//converte de hexadecimal para inteiro

		}

		int conta = linhasTxt.get(0);
		int agencia = linhasTxt.get(1);

		if(agencia == getAgenciaDestino() && conta == getContaDestino()){
			ResultSet rs = null;
			ContaDAO contaDAO = new ContaDAO();
			rs = contaDAO.selectSaldo(getConta()).executeQuery();

			while (rs.next()){
				saldoTitular = rs.getInt(1);
			}

			rs = contaDAO.selectSaldo(getContaDestino()).executeQuery();

			while (rs.next()){
				saldoContaTransferir = rs.getInt(1);
			}

			double novoSaldoContaDestino =  saldoContaTransferir + getValorDaOperacao();
			double novoSaldoContaDebitada = saldoTitular - getValorDaOperacao();

			contaDAO.update(getConta(), novoSaldoContaDebitada).executeUpdate();
			contaDAO.update(getContaDestino(), novoSaldoContaDestino).executeUpdate();

			geraMovimento(agencia, getConta(), getAgenciaDestino(), getContaDestino(), "Transferencia");

			JOptionPane.showMessageDialog(null, "Transferencia Realizada com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "favor verifique as informacoes da conta a ser creditada");
		}
	}
}