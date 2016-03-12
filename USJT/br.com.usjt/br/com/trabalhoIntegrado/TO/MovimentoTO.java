package br.com.trabalhoIntegrado.TO;

import java.util.Date;
import java.util.Observable;

import br.com.trabalhoIntegrado.model.Log;

public class MovimentoTO extends Observable{
	private int codigoMovimento;
	private Date dataDoMovimento;
	private double valorDaOperacao;
	private Log log;

	public int getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(int codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
		setChanged();
		notifyObservers();
	}


	public Date getDataDoMovimento() {
		return dataDoMovimento;
	}


	public void setDataDoMovimento(Date dataDoMovimento) {
		this.dataDoMovimento = dataDoMovimento;
		setChanged();
		notifyObservers();
	}


	public double getValorDaOperacao() {
		return valorDaOperacao;
	}


	public void setValorDaOperacao(double valorDaOperacao) {
		this.valorDaOperacao = valorDaOperacao;
		setChanged();
		notifyObservers();
	}
}
