package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import br.com.trabalhoIntegrado.TO.LogTO;

public class LogTOTest {
	LogTO to;	
	public void setUp() throws Exception {
		to = new LogTO();
		to.setCodigoItemLog(123);
		to.setAgencia(001);
		to.setConta(0002);
		to.setCodigoCliente(003);
		to.setCodigoMovimento(004);
		to.setAgenciaDestino(005);
		to.setContaDestino(006);
		to.setValor(1.00);
		to.setOperacao("lava jato");		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGets() {
		assertEquals("getCodigoConsumidor", to.getCodigoItemLog(), 123);
		assertEquals("getAgencia", to.getAgencia(), 001);
		assertEquals("getConta", to.getConta(),002);
		assertEquals("getCodigoCliente", to.getCodigoCliente(), 003);
		assertEquals("getCodigoMovimento", to.getCodigoMovimento(), 004);
		assertEquals("getAgenciaDestino", to.getAgenciaDestino(), 005);
		assertEquals("getContaDestino", to.getContaDestino(), 006);
		assertEquals("getValor", to.getValor(), 1.00);
		assertEquals("getOperacao",to.getOperacao(), "lava Jato");
	}

	@Test
	public void testEquals(){
		LogTO copia = new LogTO();
		copia.setCodigoItemLog(to.getCodigoItemLog());
		copia.setAgencia(to.getAgencia());	
		copia.setConta(to.getConta());
		copia.setCodigoCliente(to.getCodigoCliente());	
		copia.setCodigoMovimento(to.getCodigoMovimento());
		copia.setAgenciaDestino(to.getAgenciaDestino());
		copia.setContaDestino(to.getContaDestino());
		copia.setValor(to.getValor());
		copia.setOperacao(to.getOperacao());	
		assertEquals("teste to igual a copia", to, copia);
	}

}