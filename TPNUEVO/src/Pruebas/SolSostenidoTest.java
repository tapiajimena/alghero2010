package Pruebas;

import Modelo.SolSostenido;
import junit.framework.TestCase;

public class SolSostenidoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		SolSostenido notaSolSostenido = new SolSostenido();
		frecuencia = notaSolSostenido.getFrecuenciaFundamental();
		assertEquals(frecuencia,415.305);

	}

}
