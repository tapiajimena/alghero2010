package Pruebas;
import junit.framework.TestCase;
import Modelo.Negra;



public class NegraTest extends TestCase{

	public void testGetIdentificador(){
		boolean silencio=true;
		double identificador;



			/* Se obtiene el identificador y se compara con su valor esperado
			 * correspondiente a la nota que representa.
			 */
			Negra negra = new Negra(silencio);
			identificador = negra.getIdentificador();
			assertEquals(identificador,1.0);



}
}
