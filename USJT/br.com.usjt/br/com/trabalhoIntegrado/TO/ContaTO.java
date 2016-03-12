package br.com.trabalhoIntegrado.TO;

import java.util.Observable;
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

public class ContaTO extends Observable{

	private int agencia, saldo, numConta;
	private String nome;



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

}
