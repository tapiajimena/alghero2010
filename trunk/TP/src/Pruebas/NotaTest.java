package Pruebas;
import junit.framework.TestCase;
import Modelo.Blanca;
import Modelo.Do;
import Modelo.Nota;

public class NotaTest extends TestCase{

	//Veamos que si la figura asociada a la nota es un silencio la cantidad de sonidos
	//es cero, mientras que si no es un silencio la cantidad de sonidos es uno.

	public void testObtenerCantidadDeSonidos(){

		Blanca unaBlanca=new Blanca(false);
		Blanca otraBlanca=new Blanca(true);
		Do unDo=new Do();
		Nota unaNota=new Nota(unaBlanca,unDo);
		Nota otraNota=new Nota(otraBlanca,unDo);

		assertTrue(unaNota.obtenerCantidadDeSonidos()==1);
		assertTrue(otraNota.obtenerCantidadDeSonidos()==0);

	}

	//Veamos que la cantidad de elementos de una nota es uno, independientemente de si
	//su figura asociada es un silencio o no.

	public void testObtenerCantidadDeElementos(){

		Blanca unaBlanca=new Blanca(false);
		Blanca otraBlanca=new Blanca(true);
		Do unDo=new Do();
		Nota unaNota=new Nota(unaBlanca,unDo);
		Nota otraNota=new Nota(otraBlanca,unDo);

		assertTrue(unaNota.obtenerCantidadDeElementos()==1);
		assertTrue(otraNota.obtenerCantidadDeElementos()==1);

	}

}
