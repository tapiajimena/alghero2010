package Pruebas;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Compas;
import Modelo.Partitura;
import junit.framework.TestCase;
import Modelo.Cancion;
import Modelo.TablaDeMapeo;

public class TablaDeMapeoTest extends TestCase{

	public void armarTablaTest(){
	int numerador=3;
	boolean silencio=true;
	Blanca blanca = new Blanca(silencio);

	ArmaduraDeClave armadura=new ArmaduraDeClave(numerador,blanca);
	Compas compasUno=new Compas(armadura);
	Partitura partitura= new Partitura();
	partitura.addCompas(compasUno);
	partitura.addCompas(compasUno);
	String unNombre="elNombre";
	String unArtista="elArtista";
	double unTiempo=5;

	Cancion cancion=new Cancion(partitura,unNombre,unArtista,unTiempo);
	TablaDeMapeo tabla=new TablaDeMapeo(cancion);
	tabla.armarTabla();


	}


}
