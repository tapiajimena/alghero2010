package Pruebas;
import Excepciones.CompasLlenoException;
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

	public void testArmarTabla() throws CompasLlenoException{

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

	    assertTrue(tabla.getTabla().get(0d)==unaNota);
	    assertTrue(tabla.getTabla().get(4d)==unaNota);
	    assertTrue(tabla.getTabla().get(8d)==otraNota);
	    assertTrue(tabla.getTabla().get(10d)==otraNota);
	    assertTrue(tabla.getTabla().get(12d)==otraNota);
	    assertTrue(tabla.getTabla().get(14d)==otraNota);
	    assertTrue(tabla.getTabla().size()==6);
	    assertTrue(tabla.getCantidadDeSegundosDeLaCancion()==16d);







	}

}

