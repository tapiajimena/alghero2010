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
import Modelo.NivelFacil;

public class NivelFacilTest extends TestCase {

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
		NivelFacil nivel = new NivelFacil();

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
		NivelFacil nivel = new NivelFacil();

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
		NivelFacil nivel = new NivelFacil();

		nivel.cargarCancion(unaCancion);

		nivel.setPuntajeIdeal();
		nivel.setPuntajeMinimo(0);

		/* Comprueba que la lista tengo un puntaje minimo de 20*0.55 = 19 */
		assertTrue(nivel.getPuntajeMinimo()== 11);

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
		NivelFacil nivel = new NivelFacil();

		nivel.cargarCancion(unaCancion);

		nivel.setPuntajeIdeal();
		nivel.setPuntajeMinimo(0);

		/* Supongo acertadas solamente dos notas */
		nivel.incrementarPuntajeActual();
		nivel.incrementarPuntajeActual();

		/* Comprueba que se pase el nivel habiendo hecho 10 puntos. */
		/* Dado que el minimo es 11, no deberia poder pasar de nivel. */
		assertTrue(nivel.esSuficiente()== false);

	}

	/* Veamos que la distribucion de teclas se haga en forma correcta
	 *
	 */

	public void testDistribuirTeclas(){

		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');


		NivelFacil unNivelFacil= new NivelFacil();

		unNivelFacil.getLetras().add(a);
		unNivelFacil.getLetras().add(s);
		unNivelFacil.getLetras().add(d);

		unNivelFacil.distribuirTeclas();



		assertTrue(unNivelFacil.getTablaDeTeclas().get(60)==a);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(61)==d);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(62)==s);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(63)==d);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(64)==s);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(65)==a);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(66)==d);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(67)==s);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(68)==a);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(69)==a);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(70)==d);
		assertTrue(unNivelFacil.getTablaDeTeclas().get(71)==s);




	}

}
