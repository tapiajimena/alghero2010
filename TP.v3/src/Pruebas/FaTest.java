package Pruebas;

import Modelo.Fa;
import junit.framework.TestCase;

public class FaTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Fa notaFa = new Fa();
		frecuencia = notaFa.getFrecuenciaFundamental();
		assertEquals(frecuencia,349.228);

	}


}
