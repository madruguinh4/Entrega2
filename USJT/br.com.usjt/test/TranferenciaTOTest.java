package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.trabalhoIntegrado.TO.TransferenciaTO;

public class TranferenciaTOTest {
	private int agenciaDestino, contaDestino, conta;
	
	TransferenciaTO to;	
	public void setUp() throws Exception {
		to.setAgenciaDestino(123);
		to.setContaDestino(001);
		to.setConta(002);
}

	@SuppressWarnings("deprecation")
	@Test
	public void testGets() {
		assertEquals("getAgenciaDestino", to.getAgenciaDestino(), 123);
		assertEquals("getContaDestino", to.getContaDestino(), 001);
		assertEquals("getConta",to.getConta(), 002);
	}

	@Test
	public void testEquals(){
		TransferenciaTO copia = new TransferenciaTO();
		copia.setAgenciaDestino(to.getAgenciaDestino());
		copia.setContaDestino(to.getContaDestino());	
		copia.setConta(to.getConta());
		assertEquals("teste to igual a copia", to, copia);
	}

}

