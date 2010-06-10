package Pruebas;
import junit.framework.TestCase;
import Modelo.Acorde;
import Modelo.Blanca;
import Modelo.Do;
import Modelo.Sonido;

import java.util.ArrayList;
import Modelo.Nota;

public class AcordeTest extends TestCase{


	/*Veamos que el puntaje ideal asignado sea el correcto
	 *

	 */

	public void testAcorde(){


        ArrayList<Nota> notas=new ArrayList<Nota>();
        Do notaDo = new Do();
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);

		Sonido unSonido=notaDo;
		Nota notaUno=new Nota(blanca,notaDo);
		notas.add(notaUno);
		notas.add(notaUno);


		Acorde acorde=new Acorde(blanca,notas);

		assertEquals(acorde.getPuntajeIdeal(),10.0);
	}



}




