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
import Modelo.NivelMedio;

public class NivelMedioTest extends TestCase {

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

		/* La canci�n queda creada con 4 notas.*/

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		/* Armo el nivel y asigno la canci�n armada previamente. */
		NivelMedio nivel = new NivelMedio();

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

		/* La canci�n queda creada con 4 notas.*/

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		/* Armo el nivel y asigno la canci�n armada previamente. */
		NivelMedio nivel = new NivelMedio();

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

		/* La canci�n queda creada con 4 notas.*/

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		/* Armo el nivel y asigno la canci�n armada previamente. */
		NivelMedio nivel = new NivelMedio();

		nivel.cargarCancion(unaCancion);

		nivel.setPuntajeIdeal();
		nivel.setPuntajeMinimo(0);

		/* Comprueba que la lista tengo un puntaje minimo de 20*0.75 = 15 */
		assertTrue(nivel.getPuntajeMinimo()== 15);

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

		/* La canci�n queda creada con 4 notas.*/

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		/* Armo el nivel y asigno la canci�n armada previamente. */
		NivelMedio nivel = new NivelMedio();

		nivel.cargarCancion(unaCancion);

		nivel.setPuntajeIdeal();
		nivel.setPuntajeMinimo(0);

		/* Supongo acertadas las 4 notas */
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();


		/* Comprueba que se pase el nivel habiendo hecho 16 puntos. */
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


		NivelMedio unNivelMedio= new NivelMedio();
		unNivelMedio.getLetras().add(a);
		unNivelMedio.getLetras().add(s);
		unNivelMedio.getLetras().add(d);
		unNivelMedio.getLetras().add(f);


		unNivelMedio.distribuirTeclas();



		assertTrue(unNivelMedio.getTablaDeTeclas().get(60)==a);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(61)==d);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(62)==a);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(63)==s);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(64)==f);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(65)==s);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(66)==f);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(67)==s);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(68)==f);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(69)==d);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(70)==a);
		assertTrue(unNivelMedio.getTablaDeTeclas().get(71)==d);




	}


}