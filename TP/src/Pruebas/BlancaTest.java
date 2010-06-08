package Pruebas;

import Modelo.Blanca;
import junit.framework.TestCase;

public class BlancaTest extends TestCase {

	public void testGetIdentificador(){
		boolean silencio=true;
		double identificador;

		/* Se obtiene el identificador y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Blanca blanca = new Blanca(silencio);
		identificador = blanca.getIdentificador();
		assertEquals(identificador,2.0);

	}
}
