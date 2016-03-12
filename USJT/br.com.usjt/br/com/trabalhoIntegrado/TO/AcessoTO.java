package br.com.trabalhoIntegrado.TO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.trabalhoIntegrado.view.TelaEntrarComCodigo;
import br.com.trabalhoIntegrado.view.TelaGerarCodigo;

public class AcessoTO extends Observable{
	
	
		private int agencia, conta, senha, codigoDeAcesso;
		private FileReader txtConta;
		private boolean validar;
		private ResourceBundle idioma;

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

		public int getSenha() {
			return senha;
		}

		public void setSenha(int senha) {
			this.senha = senha;
			setChanged();
			notifyObservers();
		}

		public int getCodigoDeAcesso() {
			return codigoDeAcesso;		
		}

		public void setCodigoDeAcesso(int codigoDeAcesso) {
			this.codigoDeAcesso = codigoDeAcesso;
			setChanged();
			notifyObservers();
		}

		public ResourceBundle getIdioma() {
			return idioma;
		}

		public void setIdioma(ResourceBundle idioma) {
			this.idioma = idioma;
		}

}
