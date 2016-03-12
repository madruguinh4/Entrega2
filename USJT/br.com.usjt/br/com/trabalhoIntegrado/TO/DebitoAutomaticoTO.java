package br.com.trabalhoIntegrado.TO;

import java.text.ParseException;
import java.util.Date;
import java.util.Observable;

import br.com.trabalhoIntegrado.DAO.DebitoAutomaticoDAO;
import br.com.trabalhoIntegrado.model.Movimento;

public class DebitoAutomaticoTO extends Observable{

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
}