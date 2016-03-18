package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import br.com.trabalhoIntegrado.TO.ContaTO;


public class ContaToTest {

	ContaTO to;
	@Before
	public void setUp() throws Exception {
		to = new ContaTO();
		to.setNome("David Alan");
		to.setAgencia(123);
	}

	@Test
	
	public void testGets() {
		assertEquals("getNome", to.getNome(), "David Alan");
		assertEquals("getAgencia", to.getAgencia(), 123);
}
	
	@Test
	public void testEquals(){
		ContaTO copia = new ContaTO();
		copia.setNome(to.getNome());
		copia.setAgencia(to.getAgencia());
		assertEquals("teste to igual a copia", to, copia);
	}

}
