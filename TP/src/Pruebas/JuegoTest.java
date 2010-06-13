package Pruebas;

import java.util.ArrayList;

import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Negra;
import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sonido;
import Modelo.Juego;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	public void testGanoJuego(){

		/* Armo el primer compas */

		Negra unaNegra=new Negra(false);
		Negra otraNegra=new Negra(true);
		Re unRe=new Re();
		Nota primerNota= new Nota(unaNegra,unRe);
		Nota segundaNota= new Nota(otraNegra,unRe);
		int numerador=5;
        Negra negra = new Negra(false);
		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,negra);
		Compas primerCompas= new Compas(armadura);
		primerCompas.addElementoDePartitura(primerNota);
		primerCompas.addElementoDePartitura(segundaNota);

		/* Armo el segundo compas */

		Compas segundoCompas= new Compas(armadura);
		Do unDo=new Do();
		Nota unaNota=new Nota(negra,unDo);
		segundoCompas.addElementoDePartitura(unaNota);
		Negra negraAux = new Negra(true);
		Nota otraNota=new Nota(negraAux,unDo);
		segundoCompas.addElementoDePartitura(otraNota);
		ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
        Do notaDo = new Do();
        Do otraNotaDo=new Do();
		Negra negraAuxDos = new Negra(false);
		sonidos.add(notaDo);
		sonidos.add(otraNotaDo);
		Acorde unAcorde= new Acorde(negraAuxDos,sonidos);
		segundoCompas.addElementoDePartitura(unAcorde);

		Partitura laPartitura= new Partitura();
		laPartitura.addCompas(primerCompas);
		laPartitura.addCompas(segundoCompas);

		/* La canción queda creada con 4 notas.*/

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		/* Armo el nivel y asigno la canción armada previamente. */
		NivelDificil nivel = new NivelDificil();

		nivel.cargarCancion(unaCancion);
		nivel.setPuntajeIdeal();
		nivel.setPuntajeMinimo();
		nivel.setPuntajeActual(20);

		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();
		listaNiveles.add(0, nivel);

		Juego juego = new Juego(listaNiveles);

		/* Comprueba que se gane el juego ya que se superaron los niveles,
		 * en este caso, un unico nivel.
		 */
		assertTrue(juego.ganoJuego()== true);
	}

}
