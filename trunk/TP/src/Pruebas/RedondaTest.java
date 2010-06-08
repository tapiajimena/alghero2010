package Pruebas;

import Modelo.Redonda;
import junit.framework.TestCase;

public class RedondaTest extends TestCase {

	public void testGetIdentificador(){
		boolean silencio=true;
		double identificador;

		/* Se obtiene el identificador y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Redonda redonda = new Redonda(silencio);
		identificador = redonda.getIdentificador();
		assertEquals(identificador,4.0);

	}
}
