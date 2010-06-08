package Pruebas;
import junit.framework.TestCase;

import Modelo.Negra;



public class NegraTest extends TestCase{




	public void testGetIdentificador(){
		boolean silencio=true;

		Negra negra=new Negra(silencio);
		assertTrue((negra.getIdentificador())=(1.0));
	}


   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra);
   }



}
