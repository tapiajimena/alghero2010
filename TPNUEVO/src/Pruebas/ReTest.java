package Pruebas;

import Modelo.Re;
import junit.framework.TestCase;

public class ReTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Re notaRe = new Re();
		frecuencia = notaRe.getFrecuenciaFundamental();
		assertEquals(frecuencia,293.665);

	}


}
