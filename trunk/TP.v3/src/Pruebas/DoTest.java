package Pruebas;

import Modelo.Do;
import junit.framework.TestCase;

public class DoTest extends TestCase {

	public void testGetFrecuenciaFundamental(){

		double frecuencia;

		/* Se obtiene la frecuencia y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Do notaDo = new Do();
		frecuencia = notaDo.getFrecuenciaFundamental();
		assertEquals(frecuencia,261.626);

	}


}
