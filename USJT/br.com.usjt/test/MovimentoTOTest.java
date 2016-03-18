package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.trabalhoIntegrado.TO.MovimentoTO;


public class MovimentoTOTest {
	private int codigoMovimento;
	private double valorDaOperacao;
	
	
	MovimentoTO to;	
	public void setUp() throws Exception {
		to = new MovimentoTO();
		to.setCodigoMovimento(123);
		to.setValorDaOperacao(001);
}

	@SuppressWarnings("deprecation")
	@Test
	public void testGets() {
		assertEquals("getCodigoMovimento", to.getCodigoMovimento(), 123);
		assertEquals("getValorDaOperação", to.getValorDaOperacao(), 001);
	}

	@Test
	public void testEquals(){
		MovimentoTO copia = new MovimentoTO();
		copia.setCodigoMovimento(to.getCodigoMovimento());
		copia.setValorDaOperacao(to.getValorDaOperacao());		
		assertEquals("teste to igual a copia", to, copia);
	}

}