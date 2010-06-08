package Pruebas;

import junit.framework.TestCase;
import Modelo.SemiCorchea;

public class SemiCorcheaTest extends TestCase {

	public void testGetIdentificador(){
		boolean silencio=true;
		double identificador;

		/* Se obtiene el identificador y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		SemiCorchea semiCorchea = new SemiCorchea(silencio);
		identificador = semiCorchea.getIdentificador();
		assertEquals(identificador,0.25);

	}

}
