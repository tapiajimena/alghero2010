package Pruebas;
import Modelo.Letra;
import junit.framework.TestCase;

public class LetraTest extends TestCase {

	/*Veamos que el constructor asigne bien la letra ingresada
	 *
	 */
	public void testLetra(){

	char simbolo='a';

	Letra letra= new Letra(simbolo);
	assertEquals(simbolo,'a');


}
}