package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.trabalhoIntegrado.TO.SaqueTO;


public class SaqueTOTest extends MovimentoTOTest {
	
	SaqueTO to;
	@Before
	public void setUp() throws Exception {
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
		SaqueTO copia = new SaqueTO();
		copia.setCodigoMovimento(to.getCodigoMovimento());
		copia.setValorDaOperacao(to.getValorDaOperacao());		
		assertEquals("teste to igual a copia", to, copia);
	}

}

