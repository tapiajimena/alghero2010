package Pruebas;

import Modelo.ReSostenido;
import junit.framework.TestCase;

public class ReSostenidoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		ReSostenido notaReSostenido = new ReSostenido();
		frecuencia = notaReSostenido.getFrecuenciaFundamental();
		assertEquals(frecuencia,311.127);

	}



}
