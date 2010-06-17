package Pruebas;
import Excepciones.CompasLlenoException;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.ArmaduraDeClave;
import junit.framework.TestCase;
import java.util.ArrayList;

import Modelo.Acorde;
import Modelo.Nota;
import Modelo.Do;
import Modelo.Compas;
import Modelo.Redonda;
import Modelo.Negra;
import Modelo.Sonido;

public class CompasTest extends TestCase{

	//busco la duracion hasta el momento de un compas de una duracion de hasta 5 negras
	//que tiene un acorde de negra, un silencio de negra, y una nota de negra. Por
	//lo tanto debe devolver 3.

	public void testObtenerDuracionHastaElMomento() throws CompasLlenoException{
		int numerador=5;

		Negra negra = new Negra(false);
		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,negra);
		Compas unCompas= new Compas(armadura);
		Do unDo=new Do();
		Nota unaNota=new Nota(negra,unDo);
		unCompas.addElementoDePartitura(unaNota);

		Negra otraNegra = new Negra(true);
		Nota otraNota=new Nota(otraNegra,unDo);
		unCompas.addElementoDePartitura(otraNota);

		ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
        Do notaDo = new Do();
        Do otraNotaDo=new Do();
		Negra unaNegra = new Negra(false);
		sonidos.add(notaDo);
		sonidos.add(otraNotaDo);
		Acorde unAcorde= new Acorde(unaNegra,sonidos);
		unCompas.addElementoDePartitura(unAcorde);



		assertTrue(unCompas.obtenerDuracionHastaElMomento()==3);


	}

	//Veamos que siguiendo la prueba anterior, este metodo devuelve true si quiero
	//agregar un nota de duracion Negra, ya que todavia hay lugar en el compas.
	//Pero si quiero agregar una nota con una duracion de Redonda no.


	public void testSePuedeAgregarElementoDePartitura() throws CompasLlenoException{
		int numerador=5;

		Negra negra = new Negra(false);
		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,negra);
		Compas unCompas= new Compas(armadura);
		Do unDo=new Do();
		Nota unaNota=new Nota(negra,unDo);
		unCompas.addElementoDePartitura(unaNota);

		Negra otraNegra = new Negra(true);
		Nota otraNota=new Nota(otraNegra,unDo);
		unCompas.addElementoDePartitura(otraNota);

		ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
        Do notaDo = new Do();
        Do otraNotaDo=new Do();
		Negra unaNegra = new Negra(false);
		sonidos.add(notaDo);
		sonidos.add(otraNotaDo);
		Acorde unAcorde= new Acorde(unaNegra,sonidos);
		unCompas.addElementoDePartitura(unAcorde);

		//Veamos si devuelve true

		assertTrue(unCompas.sePuedeAgregarElementoDePartitura(otraNota));

		Redonda unaRedonda=new Redonda(false);
		Nota laNota=new Nota(unaRedonda,unDo);

		//Veamos si devuelve false

		assertFalse(unCompas.sePuedeAgregarElementoDePartitura(laNota));


	}

	/* Veo agregar una nota de duracion negra a un compas de 1 negra de duracion.
	 * Y despues veo que al querer agregar otra igual se lance la excepcion correspondiente
	 */

	public void testAddElementoDePartitura() throws CompasLlenoException{
		Negra negra = new Negra(false);
		ArmaduraDeClave armadura=new ArmaduraDeClave(1,negra);
		Compas unCompas= new Compas(armadura);
		Do unDo=new Do();
		Nota unaNota=new Nota(negra,unDo);
		unCompas.addElementoDePartitura(unaNota);

		assertTrue(unCompas.getElementosDePartitura().size()==1);

		try {
			unCompas.addElementoDePartitura(unaNota);

		  } catch (CompasLlenoException expected) {
		    assertTrue(true);
		  }
		


	}
}



