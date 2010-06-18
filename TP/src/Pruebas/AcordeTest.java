package Pruebas;
import junit.framework.TestCase;
import Modelo.Acorde;
import Modelo.Blanca;
import Modelo.Do;
import Modelo.Sonido;

import java.util.ArrayList;


public class AcordeTest extends TestCase{


	/*Veamos que si la figura asociada al acorde es un silencio, la cantidad de sonidos
	 * es cero, mientras que si no es un silencio la cantidad de sonidos es el tamaño
	 * de la lista de sonidos
	 *

	 */

	public void testObtenerCantidadDeSonidos(){


        ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
        Do notaDo = new Do();
        Do otraNotaDo=new Do();
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);
		Blanca otraBlanca = new Blanca(false);
		sonidos.add(notaDo);
		sonidos.add(otraNotaDo);

		Acorde unAcorde= new Acorde(blanca,sonidos);
		Acorde otroAcorde= new Acorde(otraBlanca,sonidos);


		assertTrue(unAcorde.obtenerCantidadDeSonidos()==0);
		assertTrue(otroAcorde.obtenerCantidadDeSonidos()==2);
	}

	/*Veamos que la cantidad de elementos de un acorde es independiente de si su
	 * figura asociada es un silencio o no
	 *

	 */


	public void testObtenerCantidadDeElementos(){

		ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
        Do notaDo = new Do();
        Do otraNotaDo=new Do();
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);
		Blanca otraBlanca = new Blanca(false);
		sonidos.add(notaDo);
		sonidos.add(otraNotaDo);

		Acorde unAcorde= new Acorde(blanca,sonidos);
		Acorde otroAcorde= new Acorde(otraBlanca,sonidos);


		assertTrue(unAcorde.obtenerCantidadDeElementos()==2);
		assertTrue(otroAcorde.obtenerCantidadDeElementos()==2);
	}



}




