package Pruebas;

import java.util.ArrayList;

import junit.framework.TestCase;
import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.Cancion;
import Modelo.Do;
import Modelo.Compas;
import Modelo.ArmaduraDeClave;
import Modelo.Letra;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sonido;
import Modelo.NivelDificil;

public class NivelDificilTest extends TestCase {

	public void testCargarCancion() throws CompasLlenoException{

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

		/* Comprueba que la lista no este vacia */
		assertTrue(nivel.getListaCanciones().isEmpty()== false);

	}

	public void testSetPuntajeIdeal() throws CompasLlenoException{

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

		/* Comprueba que la lista tengo un puntaje ideal de 4*5 = 20 */
		assertTrue(nivel.getPuntajeIdeal()== 20.0);

	}

	public void testSetPuntajeMinimo() throws CompasLlenoException{

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

		/* Comprueba que la lista tengo un puntaje minimo de 20*0.95 = 19 */
		assertTrue(nivel.getPuntajeMinimo()== 19);

	}

	public void testEsSuficiente() throws CompasLlenoException{

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

		/* Supongo acertadas las 4 notas */
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();

		/* Comprueba que se pase el nivel. */
		assertTrue(nivel.esSuficiente()== true);

	}

	/* Veamos que la distribucion de teclas se haga en forma correcta
	 *
	 */

	public void testDistribuirTeclas(){

		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');
		Letra f=new Letra('f');
		Letra g=new Letra('g');
		Letra h=new Letra('h');

		NivelDificil unNivelDificil= new NivelDificil();
		unNivelDificil.getLetras().add(a);
		unNivelDificil.getLetras().add(s);
		unNivelDificil.getLetras().add(d);
		unNivelDificil.getLetras().add(f);
		unNivelDificil.getLetras().add(g);
		unNivelDificil.getLetras().add(h);

		unNivelDificil.distribuirTeclas();



		assertTrue(unNivelDificil.getTablaDeTeclas().get(1)==a);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(2)==d);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(3)==g);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(4)==h);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(5)==s);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(6)==f);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(7)==h);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(8)==s);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(9)==f);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(10)==a);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(11)==d);
		assertTrue(unNivelDificil.getTablaDeTeclas().get(12)==g);




	}

}
