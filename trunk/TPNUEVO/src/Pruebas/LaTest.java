package Pruebas;

import Modelo.La;
import junit.framework.TestCase;

public class LaTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		La notaLa = new La();
		frecuencia = notaLa.getFrecuenciaFundamental();
		assertEquals(frecuencia,440.0);

	}


}
