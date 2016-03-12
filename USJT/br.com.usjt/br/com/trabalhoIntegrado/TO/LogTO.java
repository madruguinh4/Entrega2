package br.com.trabalhoIntegrado.TO;

import java.util.Date;
import java.util.Observable;

import br.com.trabalhoIntegrado.DAO.LogDAO;

public class LogTO extends Observable{
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
}
