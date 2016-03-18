package test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.trabalhoIntegrado.DAO.DebitoAutomaticoDAO;
import br.com.trabalhoIntegrado.TO.DebitoAutomaticoTO;
import br.com.trabalhoIntegrado.model.Movimento;

public class DebitoAutomaticoToTest {
		DebitoAutomaticoTO to;
		@Before
		public void setUp() throws Exception {
			to = new DebitoAutomaticoTO();
			to.setCodigoConsumidor(123);
			to.setCodDebito(321);
			to.setOperadora("Master");
			to.setTipoDebito("");
			to.setNumConta(000);
		}

		@Test
		public void testGets() {
			assertEquals("getCodigoConsumidor", to.getCodigoConsumidor(), 123);
			assertEquals("getCodDebito", to.getCodDebito(), 321);
			assertEquals("getOperadora",to.getOperadora(), "Master");
			assertEquals("getTipoDebito", to.getTipoDebito(), "");
			assertEquals("getNumConta", to.getNumConta(), 000);
	}
		
		@Test
		public void testEquals(){
			DebitoAutomaticoTO copia = new DebitoAutomaticoTO();
			copia.setCodigoConsumidor(to.getCodigoConsumidor());
			copia.setCodDebito(to.getCodDebito());
			copia.setOperadora(to.getOperadora());
			copia.setTipoDebito(to.getTipoDebito());
			assertEquals("teste to igual a copia", to, copia);
		}

	}
