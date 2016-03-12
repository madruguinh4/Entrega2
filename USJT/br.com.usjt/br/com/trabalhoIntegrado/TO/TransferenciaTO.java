package br.com.trabalhoIntegrado.TO;



public class TransferenciaTO extends MovimentoTO{

	private int agenciaDestino, contaDestino, conta;

	public TransferenciaTO(MovimentoTO movimentoTO) {

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

}
