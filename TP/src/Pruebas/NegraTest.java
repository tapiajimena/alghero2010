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

	/*Veamos que devuelva la duracion esperada (la misma)
	 *
	 */
	public void testDuracion(){
		double tiempoDeNegra=5;
		boolean silencio=true;
		Negra negra = new Negra(silencio);

		assertEquals(negra.duracion(tiempoDeNegra),5.0);

	}
}
