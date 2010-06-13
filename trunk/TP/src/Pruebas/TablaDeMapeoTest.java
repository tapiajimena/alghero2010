package Pruebas;
import Modelo.Blanca;
import Modelo.ArmaduraDeClave;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Nota;
import Modelo.Negra;
import Modelo.Partitura;
import Modelo.Cancion;
import Modelo.TablaDeMapeo;
import junit.framework.TestCase;

public class TablaDeMapeoTest extends TestCase {

	/* Armo dos compases de duracion: 2 blancas.
	 * El primer compas compuesto por 2 notas de duracion blanca.
	 * El segundo compas compuesto por 4 notas de duracion negra.
	 * De esta manera ambos compases se encuentran completos.
	 * Al armar la tabla esta quedaria asi:  0  unaNota
	 *                                       4  unaNota
	 *                                       8  otraNota
	 *                                       10  otraNota
	 *                                       12 otraNota
	 *                                       14 otraNota
	 *
	 */

	public void testArmarTabla(){

		Blanca blanca=new Blanca(false);
		ArmaduraDeClave unaArmadura=new ArmaduraDeClave(2,blanca);
		Do unDo=new Do();
		Compas primerCompas= new Compas(unaArmadura);
		Nota unaNota=new Nota(blanca,unDo);
		primerCompas.addElementoDePartitura(unaNota);
	    primerCompas.addElementoDePartitura(unaNota);

	    Compas segundoCompas=new Compas(unaArmadura);
	    Negra negra=new Negra(false);
	    Nota otraNota=new Nota(negra,unDo);
	    segundoCompas.addElementoDePartitura(otraNota);
	    segundoCompas.addElementoDePartitura(otraNota);
	    segundoCompas.addElementoDePartitura(otraNota);
	    segundoCompas.addElementoDePartitura(otraNota);

	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);

	    Cancion unaCancion=new Cancion(unaPartitura,"titulo","artista",2);

	    TablaDeMapeo tabla=new TablaDeMapeo(unaCancion);

	    tabla.armarTabla();

	    assertTrue(tabla.getTabla().get(0).getTiempo()==0);
	    assertTrue(tabla.getTabla().get(0).getElemento()==unaNota);
	    assertTrue(tabla.getTabla().get(1).getTiempo()==4);
	    assertTrue(tabla.getTabla().get(1).getElemento()==unaNota);
	    assertTrue(tabla.getTabla().get(2).getTiempo()==8);
	    assertTrue(tabla.getTabla().get(2).getElemento()==otraNota);
	    assertTrue(tabla.getTabla().get(3).getTiempo()==10);
	    assertTrue(tabla.getTabla().get(3).getElemento()==otraNota);
	    assertTrue(tabla.getTabla().get(4).getTiempo()==12);
	    assertTrue(tabla.getTabla().get(4).getElemento()==otraNota);
	    assertTrue(tabla.getTabla().get(5).getTiempo()==14);
	    assertTrue(tabla.getTabla().get(5).getElemento()==otraNota);













	}

}
