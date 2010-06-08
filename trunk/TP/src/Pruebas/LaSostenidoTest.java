package Pruebas;

import Modelo.LaSostenido;
import junit.framework.TestCase;

public class LaSostenidoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		LaSostenido notaLaSostenido = new LaSostenido();
		frecuencia = notaLaSostenido.getFrecuenciaFundamental();
		assertEquals(frecuencia,466.164);

	}

}
