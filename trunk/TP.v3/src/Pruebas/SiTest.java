package Pruebas;

import junit.framework.TestCase;
import Modelo.Si;

public class SiTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Si notaSi = new Si();
		frecuencia = notaSi.getFrecuenciaFundamental();
		assertEquals(frecuencia,493.883);

	}


}
