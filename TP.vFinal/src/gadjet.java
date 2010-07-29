import java.io.IOException;
import java.util.ArrayList;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Corchea;
import Modelo.Do;
import Modelo.Fa;
import Modelo.La;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.ReSostenido;
import Modelo.Redonda;
import Modelo.Sol;
import Modelo.SolSostenido;
import Modelo.Sonido;


public class gadjet {

	public static void main(String[] args) {


		Negra negra=new Negra(false);
		Corchea corchea=new Corchea(false);
		Blanca blanca=new Blanca(false);

		Do unDo=new Do();
		Mi unMi=new Mi();
		Sol unSol=new Sol();
		Re unRe=new Re();
		Fa unFa=new Fa();
		La unLa=new La();
		SolSostenido unSolSostenido=new SolSostenido();
		ReSostenido unReSostenido=new ReSostenido();

		ArmaduraDeClave armadura=new ArmaduraDeClave(4,negra);
		Nota notaRe=new Nota(corchea,unRe);
		Nota notaMi=new Nota(corchea,unMi);
		Nota notaFa=new Nota(corchea,unFa);
		Nota notaSol=new Nota(corchea,unSol);
		Nota notaLa=new Nota(corchea,unLa);
		Nota notaSolSostenido=new Nota(corchea,unSolSostenido);
		Nota notaReSostenido=new Nota(corchea,unReSostenido);
		Nota notaReBlanca=new Nota(blanca,unRe);
		Nota notaSolBlanca=new Nota(blanca,unSol);
		Nota notaLaNegra=new Nota(negra,unLa);
		Nota notaSolSostenidoNegra=new Nota(negra,unSolSostenido);
		Nota notaSolNegra=new Nota(negra,unSol);


		Compas compasUno=new Compas(armadura);
		Compas compasDos=new Compas(armadura);
		Compas compasCuatro=new Compas(armadura);
		Compas compasOcho=new Compas(armadura);

		try {
			compasUno.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaLa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasUno.addElementoDePartitura(notaLaNegra);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			compasDos.addElementoDePartitura(notaSolSostenido);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasDos.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			compasDos.addElementoDePartitura(notaSolSostenidoNegra);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasDos.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasDos.addElementoDePartitura(notaReSostenido);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			compasDos.addElementoDePartitura(notaSolNegra);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			compasCuatro.addElementoDePartitura(notaSolSostenido);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasCuatro.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		try {
			compasCuatro.addElementoDePartitura(notaSolSostenidoNegra);
		} catch (CompasLlenoException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		try {
			compasCuatro.addElementoDePartitura(notaSolBlanca);
		} catch (CompasLlenoException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			compasOcho.addElementoDePartitura(notaSolSostenido);
		} catch (CompasLlenoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			compasOcho.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			compasOcho.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			compasOcho.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			compasOcho.addElementoDePartitura(notaReBlanca);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(compasUno);
	    unaPartitura.getCompases().add(compasDos);
	    unaPartitura.getCompases().add(compasUno);
	    unaPartitura.getCompases().add(compasCuatro);
	    unaPartitura.getCompases().add(compasUno);
	    unaPartitura.getCompases().add(compasDos);
	    unaPartitura.getCompases().add(compasUno);
	    unaPartitura.getCompases().add(compasOcho);



	    @SuppressWarnings("unused")
		Cancion cancion=new Cancion(unaPartitura,"Inspector Gadjet","desconocido",1);

	    try{
	        cancion.guardar("InspectorGadjet.xml");

	        }catch(IOException ex){
	           System.out.println("Problemas" + ex);
	        }


	}

}
