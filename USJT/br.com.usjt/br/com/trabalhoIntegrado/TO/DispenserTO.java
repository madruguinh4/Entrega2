package br.com.trabalhoIntegrado.TO;

import java.util.Observable;

public class DispenserTO extends Observable{

	private int nota, quantidade;

	public DispenserTO(int nota, int quantidade) {
		this.nota = nota;
		this.quantidade = quantidade;
	}

	public DispenserTO() {
	}

	public int getNota() {
		return nota;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNota(int nota) {
		this.nota = nota;
		setChanged();
		notifyObservers();

	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		setChanged();
		notifyObservers();
	}
}
