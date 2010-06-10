package Pruebas;

import java.util.ArrayList;

import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Letra;
import Modelo.NivelDificil;
import Modelo.Nota;
import Modelo.Partitura;
import junit.framework.TestCase;

public class NivelMedioTest extends TestCase {

	public void testGeneral(){

		NivelDificil unNivelDificil = new NivelDificil();
		ArrayList<Letra> letras = new ArrayList<Letra>();
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();

		int numerador = 3;
		boolean silencio = false;

		Blanca blanca = new Blanca(silencio);
		Do unDo=new Do();
		Nota nota=new Nota(blanca,unDo);

		ArmaduraDeClave armadura = new ArmaduraDeClave(numerador,blanca);

		ArrayList<Nota> notas = new ArrayList<Nota>();
		notas.add(nota);

		Compas compas = new Compas(armadura);

		/* Armo una partitura de un solo compás */
		Partitura unaPartitura = new Partitura();
		unaPartitura.addCompas(compas);

		String unNombre = "Feliz Cumpleaños";
		String unAutor = "Anonimo";

		Cancion unaCancion = new Cancion(unaPartitura,unNombre,unAutor,2);

		unNivelDificil.cargarCancion(unaCancion);





	}


}
