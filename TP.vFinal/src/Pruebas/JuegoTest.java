package Pruebas;

import java.util.ArrayList;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Letra;
import Modelo.Negra;
import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.NivelFacil;
import Modelo.NivelMedio;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sonido;
import Modelo.Juego;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	public void testGanoJuego() throws CompasLlenoException{

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
		nivel.setPuntajeMinimo(0);

		/* Supongo acertadas las 4 notas */
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();

		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();
		listaNiveles.add(0, nivel);

		Juego juego = new Juego(listaNiveles);

		/* Comprueba que se gane el juego ya que se superaron los niveles,
		 * en este caso, un unico nivel.
		 */
		assertTrue(juego.ganoJuego()== true);
	}

	/* Para probar el metodo asignarLetrasNivel armo una cancion como en la prueba
	 * anterior y la agrego en un nivel facil, uno medio y uno dificil.
	 * Luego, estos niveles seran incluidos en juego para probar como varian
	 * las letras asignadas en cada uno
	 *
	 */

	public void testAsignarLetrasNivel() throws CompasLlenoException{

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
		NivelFacil nivelFacil = new NivelFacil();
		NivelMedio nivelMedio = new NivelMedio();
		NivelDificil nivelDificil = new NivelDificil();

		nivelFacil.cargarCancion(unaCancion);
		nivelMedio.cargarCancion(unaCancion);
		nivelDificil.cargarCancion(unaCancion);

		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();
		listaNiveles.add(nivelFacil);
		listaNiveles.add(nivelMedio);
		listaNiveles.add(nivelDificil);

		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');
		Letra f=new Letra('f');
		Letra g=new Letra('g');
		Letra h=new Letra('h');

		Juego elJuego = new Juego(listaNiveles);
		elJuego.getLetras().add(a);
		elJuego.getLetras().add(s);
		elJuego.getLetras().add(d);
		elJuego.getLetras().add(f);
		elJuego.getLetras().add(g);
		elJuego.getLetras().add(h);


		elJuego.asignarLetrasNivel();

		//Verifico las letras que usa el nivel y su cantidad de letras
        assertTrue(elJuego.getNiveles().get(0).getLetras().get(0).getSimbolo()=='a');
		assertTrue(elJuego.getNiveles().get(0).getLetras().get(1).getSimbolo()=='s');
		assertTrue(elJuego.getNiveles().get(0).getLetras().get(2).getSimbolo()=='d');
		assertTrue(elJuego.getNiveles().get(0).getLetras().size()==3);

		assertTrue(elJuego.getNiveles().get(1).getLetras().get(0).getSimbolo()=='a');
		assertTrue(elJuego.getNiveles().get(1).getLetras().get(1).getSimbolo()=='s');
		assertTrue(elJuego.getNiveles().get(1).getLetras().get(2).getSimbolo()=='d');
		assertTrue(elJuego.getNiveles().get(1).getLetras().get(3).getSimbolo()=='f');
		assertTrue(elJuego.getNiveles().get(1).getLetras().size()==4);

		assertTrue(elJuego.getNiveles().get(2).getLetras().get(0).getSimbolo()=='a');
		assertTrue(elJuego.getNiveles().get(2).getLetras().get(1).getSimbolo()=='s');
		assertTrue(elJuego.getNiveles().get(2).getLetras().get(2).getSimbolo()=='d');
		assertTrue(elJuego.getNiveles().get(2).getLetras().get(3).getSimbolo()=='f');
		assertTrue(elJuego.getNiveles().get(2).getLetras().get(4).getSimbolo()=='g');
		assertTrue(elJuego.getNiveles().get(2).getLetras().get(5).getSimbolo()=='h');
		assertTrue(elJuego.getNiveles().get(2).getLetras().size()==6);





	}

}
