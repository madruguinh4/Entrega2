package br.com.trabalhoIntegrado.TO;


import br.com.trabalhoIntegrado.model.Movimento;

public class SaqueTO extends Movimento {

	private DispenserTO dispenserTO;
	private int conta, agencia;

	public SaqueTO() {
		dispenserTO = new DispenserTO();
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
}
