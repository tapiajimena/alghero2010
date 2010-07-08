import java.util.ArrayList;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Compas;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.ElementoDePartitura;
import Modelo.Fa;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sol;
import Modelo.Sonido;

/* EN ESTE CASO:
 0  unaNota
 2  otraNota
 4   unAcorde


*/

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Negra negra=new Negra(true);
		Negra otraNegra=new Negra(false);

		ArmaduraDeClave unaArmadura=new ArmaduraDeClave(6,otraNegra);
		Compas primerCompas= new Compas(unaArmadura);
		Do unDo=new Do();
		Mi unMi=new Mi();
		Sol unSol=new Sol();
		Re unRe=new Re();
		Fa unFa=new Fa();
		DoSostenido unDoSostenido=new DoSostenido();

	    Nota unaNota=new Nota(negra,unDo);//
	    Nota otraNota=new Nota(otraNegra,unMi);
	    ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
	    sonidos.add(unSol);
	    sonidos.add(unRe);
	    sonidos.add(unFa);
	    sonidos.add(unDoSostenido);
	    Acorde unAcorde=new Acorde(otraNegra,sonidos);

	    try {
			primerCompas.addElementoDePartitura(unaNota);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			primerCompas.addElementoDePartitura(otraNota);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			primerCompas.addElementoDePartitura(unAcorde);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);


	    Linkeador link=new Linkeador(unaPartitura);
/*// PARA VERIFICAR QUE LOS SEGUNDOS DE TABLA DE MAPEO ESTAN BIEN
	    for(int i=0;i< link.getTabla().getArrayDeSegundos().size();i++){
	    	System.out.println(link.getTabla().getArrayDeSegundos().get(i));


	    }*/

	    /*EN ESTE CASO EL CONTENEDOR DEBERIA QUEDAR:
	     *  Segundo - Columna
	     *  2          2
	     *  4          3
	     *  4          1
	     *  4          2
	     *  4          4

	     * LA NOTA DEL SEGUNDO CERO NO APARECE PORQUE
	     * ES UN SILENCIO
	     */

	   ArrayList<Struct> resultado=link.getContenedor();

	    for(int i=0;i< resultado.size();i++){
	    	System.out.println(resultado.get(i).getSegundo());
	    	System.out.println(resultado.get(i).getColumna());


}





}
}


