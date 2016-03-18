package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.trabalhoIntegrado.TO.DispenserTO;

public class DispenserToTest {
	DispenserTO to;	
	public void setUp() throws Exception {
		to = new DispenserTO();
		to.setNota(123);
		to.setQuantidade(321);
}

	@Test
	public void testGets() {
		assertEquals("getCodigoConsumidor", to.getNota(), 123);
		assertEquals("getCodDebito", to.getQuantidade(), 321);
	
}
	
	@Test
	public void testEquals(){
		DispenserTO copia = new DispenserTO();
		copia.setNota(to.getNota());
		copia.setQuantidade(to.getQuantidade());	
		assertEquals("teste to igual a copia", to, copia);
	}

}