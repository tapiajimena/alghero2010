package Pruebas;

import Modelo.DoSostenido;
import junit.framework.TestCase;

public class DoSostenidoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		DoSostenido notaDoSostenido = new DoSostenido();
		frecuencia = notaDoSostenido.getFrecuenciaFundamental();
		assertEquals(frecuencia,277.183);

	}

}
