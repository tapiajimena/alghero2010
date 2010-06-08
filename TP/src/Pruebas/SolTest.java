package Pruebas;

import Modelo.Sol;
import junit.framework.TestCase;

public class SolTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Sol notaSol = new Sol();
		frecuencia = notaSol.getFrecuenciaFundamental();
		assertEquals(frecuencia,391.995);

	}

}
