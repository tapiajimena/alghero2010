package Pruebas;

import Modelo.Corchea;
import Modelo.Negra;
import junit.framework.TestCase;

public class CorcheaTest extends TestCase {

	public void testGetIdentificador(){
		boolean silencio = true;
		double identificador;


		/* Se obtiene el identificador y se compara con su valor esperado
		 * correspondiente a la nota que representa.
		 */
		Corchea corchea = new Corchea(silencio);
		identificador = corchea.getIdentificador();
		assertEquals(identificador,0.5);

	}

	/*Veamos que devuelva la duracion esperada (en este caso la mitad)
	 *
	 */
	public void testDuracion(){
		double tiempoDeNegra=5;
		boolean silencio=true;
		Corchea corchea = new Corchea(silencio);

		assertEquals(corchea.duracion(tiempoDeNegra),2.5);

	}

}
