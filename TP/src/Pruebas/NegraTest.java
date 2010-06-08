package Pruebas;
import junit.framework.TestCase;

import Modelo.Negra;



public class NegraTest extends TestCase{




	public void testGetIdentificador(){
		boolean silencio=true;
		double numero;

		Negra negra = new Negra(silencio);
		numero = negra.getIdentificador();
		assertTrue(numero = 1.0);
	}


   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra);
   }



}
