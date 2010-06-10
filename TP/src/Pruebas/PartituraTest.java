package Pruebas;
import junit.framework.TestCase;
import Modelo.Blanca;
import Modelo.Partitura;
import Modelo.Compas;
import Modelo.ArmaduraDeClave;
import java.util.ArrayList;

public class PartituraTest extends TestCase{

	/*Veo que agregue los compases en forma correcta
	 *
	 */

	public void testAddCompas(){
		int numerador=3;
		boolean silencio=true;
		Blanca blanca = new Blanca(silencio);

		ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,blanca);
		Compas compasUno=new Compas(armadura);
		Partitura partitura= new Partitura();

		//La lista de compases debe estar vacia

		assertEquals(partitura.getCompases().size(),0);

		partitura.addCompas(compasUno);
		partitura.addCompas(compasUno);

		//La lista debe tener dos elementos

		assertEquals(partitura.getCompases().size(),2);





	}


}
