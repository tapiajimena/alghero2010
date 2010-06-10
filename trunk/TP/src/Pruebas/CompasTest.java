package Pruebas;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.ArmaduraDeClave;
import junit.framework.TestCase;
import java.util.ArrayList;
import Modelo.Nota;
import Modelo.Do;
import Modelo.Compas;
import Modelo.Redonda;

public class CompasTest extends TestCase{

	public void testAddElementoDePartitura(){
		int numerador=3;
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);
		Do unDo=new Do();
		Nota nota=new Nota(blanca,unDo);

		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,blanca);
		ArrayList<Nota> notas=new ArrayList<Nota>();
		notas.add(nota);
		Compas compas=new Compas(armadura);

		assertTrue(compas.sePuedeAgregarElementoDePartitura(nota));
		Redonda redonda=new Redonda(silencio);
		//Redonda no se tiene que poder agregar
		Nota otraNota=new Nota(redonda,unDo);
		assertFalse(compas.sePuedeAgregarElementoDePartitura(otraNota));


	}


}
