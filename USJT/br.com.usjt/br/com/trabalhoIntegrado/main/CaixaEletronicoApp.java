package br.com.trabalhoIntegrado.main;

import java.awt.EventQueue;

import br.com.trabalhoIntegrado.controler.AcessarContaCTRL;
import br.com.trabalhoIntegrado.model.Acesso;
import br.com.trabalhoIntegrado.view.TelaDeAcesso;

public class CaixaEletronicoApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAcesso frame = new AcessarContaCTRL(new Acesso());
					new AcessarContaCTRL(new Acesso());	
					frame.setSize(300, 300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}