package Pruebas;

import Modelo.FaSostenido;
import junit.framework.TestCase;

public class FaSostenidoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		FaSostenido notaFaSostenido = new FaSostenido();
		frecuencia = notaFaSostenido.getFrecuenciaFundamental();
		assertEquals(frecuencia,369.994);

	}

}
