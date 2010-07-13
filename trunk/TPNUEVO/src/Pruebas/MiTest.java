package Pruebas;

import Modelo.Mi;
import junit.framework.TestCase;

public class MiTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Mi notaMi = new Mi();
		frecuencia = notaMi.getFrecuenciaFundamental();
		assertEquals(frecuencia,329.628);

	}


}
