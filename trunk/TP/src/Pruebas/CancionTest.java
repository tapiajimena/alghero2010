package Pruebas;
import java.util.ArrayList;

import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Negra;
import Modelo.Re;
import Modelo.Sonido;
import junit.framework.TestCase;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Cancion;

public class CancionTest extends TestCase{

	/* Para probar este metodo armo una partitura con dos compases.
       El primer compas tiene dos notas de negra, de las cuales una es silencio y
	   la otra no.
	   El segundo compas tiene un acorde denegra de dos sonidos, una nota de negra
	   que es silencio y una nota de negra.
	   Por lo tanto el metodo debe devolver que tiene 4 notas.

	*/

	public void testobtenerCantidadDeNotas(){

		//armo el primer Compas

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

		//Armo el segundo compas

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

		Cancion unaCancion=new Cancion(laPartitura,"titulo","artista",5);

		assertTrue(unaCancion.obtenerCantidadDeNotas()==4);





	}




}
