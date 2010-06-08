package Pruebas;

import Modelo.Corchea;
import junit.framework.TestCase;

public class CorcheaTest extends TestCase {

	public void testGetIdentificador(){
		boolean silencio = true;
		double identificador;


		/* Se obtiene el identificador y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Corchea corchea = new Corchea(silencio);
		identificador = corchea.getIdentificador();
		assertEquals(identificador,0.5);

	}

}
