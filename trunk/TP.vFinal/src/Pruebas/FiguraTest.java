package Pruebas;
import Modelo.Blanca;
import junit.framework.TestCase;

public class FiguraTest extends TestCase{

	/*Veo que devuelva en forma correcta si es silencio o no
	 *

	 */

	public void testEsSilencio(){
		boolean silencio=true;

		Blanca blanca = new Blanca(silencio);
		assertTrue(blanca.esSilencio());
		silencio=false;

		Blanca otraBlanca = new Blanca(silencio);
		assertFalse(otraBlanca.esSilencio());

	}



}
