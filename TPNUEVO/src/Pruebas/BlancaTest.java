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

	/*Veamos que devuelva la duracion esperada (en este caso el doble)
	 *
	 */
	public void testDuracion(){
		double tiempoDeNegra=5;
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);

		assertEquals(blanca.duracion(tiempoDeNegra),10.0);

	}

}
