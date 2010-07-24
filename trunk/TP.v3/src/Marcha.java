import java.util.ArrayList;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Fa;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Redonda;
import Modelo.Sol;
import Modelo.Sonido;


public class Marcha {

	public static void main(String[] args) {

		Negra negraS=new Negra(true);
		Negra negra=new Negra(false);
		Redonda redondaS=new Redonda(true);
		Redonda redonda=new Redonda(false);
		Blanca blanca=new Blanca(false);
		Blanca blancaS=new Blanca(true);
		Do unDo=new Do();
		Mi unMi=new Mi();
		Sol unSol=new Sol();
		Re unRe=new Re();
		Fa unFa=new Fa();


		Nota notaFaSil=new Nota(blancaS,unFa);
		Nota notaReSil=new Nota(negraS,unRe);
		Nota notaDoSil=new Nota(redondaS,unDo);
		Nota notaDo=new Nota(negra,unDo);
		Nota notaMi=new Nota(negra,unMi);
		Nota notaFa=new Nota(negra,unFa);
		Nota notaSol=new Nota(negra,unSol);

		ArmaduraDeClave armaduraDos=new ArmaduraDeClave(4,negra);
		Compas primerCompas= new Compas(armaduraDos);
		try {
			primerCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
	    sonidos.add(unDo);
	    sonidos.add(unMi);
	    sonidos.add(unSol);


	    Acorde unAcorde=new Acorde(redonda,sonidos);


	    Compas segundoCompas= new Compas(armaduraDos);
	    try {
			segundoCompas.addElementoDePartitura(unAcorde);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota otraNotaSol=new Nota(blanca,unSol);
	    Nota otraNotaMi=new Nota(blanca,unMi);

	    Compas sextoCompas= new Compas(armaduraDos);
	    try {
			sextoCompas.addElementoDePartitura(otraNotaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			sextoCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota otraNotaDo=new Nota(blanca,unDo);

	    Compas septimoCompas= new Compas(armaduraDos);
	    try {
			septimoCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			septimoCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota notaRe=new Nota(negra,unRe);
	    Nota otraNotaRe=new Nota(redonda,unRe);
	    Compas octavoCompas= new Compas(armaduraDos);
	    try {
			octavoCompas.addElementoDePartitura(otraNotaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas novenoCompas= new Compas(armaduraDos);
	    try {
			novenoCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	    Compas decimoCompas= new Compas(armaduraDos);
	    try {
			decimoCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
			decimoCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			decimoCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    ArrayList<Sonido> sonidosDos=new ArrayList<Sonido>();
	    sonidosDos.add(unDo);
	    sonidosDos.add(unMi);
	    ArrayList<Sonido> sonidosTres=new ArrayList<Sonido>();
	    sonidosDos.add(unMi);
	    sonidosDos.add(unSol);
	    Acorde acordeDos=new Acorde(blanca,sonidosDos);
	    Acorde acordeTres=new Acorde(blanca,sonidosTres);
	    Compas onceCompas= new Compas(armaduraDos);
	    try {
			onceCompas.addElementoDePartitura(acordeDos);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			onceCompas.addElementoDePartitura(acordeTres);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    ArrayList<Sonido> sonidosCuatro=new ArrayList<Sonido>();
	    sonidosDos.add(unMi);
	    sonidosDos.add(unSol);
	    ArrayList<Sonido> sonidosCinco=new ArrayList<Sonido>();
	    sonidosDos.add(unRe);
	    sonidosDos.add(unFa);
	    Acorde acordeCuatro=new Acorde(negra,sonidosCuatro);
	    Acorde acordeCinco=new Acorde(blanca,sonidosCinco);
	    Compas doceCompas= new Compas(armaduraDos);
	    try {
			doceCompas.addElementoDePartitura(acordeCuatro);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doceCompas.addElementoDePartitura(acordeCinco);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doceCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas treceCompas= new Compas(armaduraDos);
	    try {
			treceCompas.addElementoDePartitura(notaFaSil);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			treceCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			treceCompas.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas catorceCompas= new Compas(armaduraDos);
	    try {
			catorceCompas.addElementoDePartitura(otraNotaSol);
		} catch (CompasLlenoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
			catorceCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    Compas quinceCompas= new Compas(armaduraDos);
	    try {
			quinceCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			quinceCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    Nota ultimaNotaDo=new Nota(redonda,unDo);
	    Compas dieciseisCompas= new Compas(armaduraDos);
	    try {
			dieciseisCompas.addElementoDePartitura(ultimaNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(sextoCompas);
	    unaPartitura.getCompases().add(septimoCompas);
	    unaPartitura.getCompases().add(octavoCompas);
	    unaPartitura.getCompases().add(novenoCompas);
	    unaPartitura.getCompases().add(decimoCompas);
	    unaPartitura.getCompases().add(onceCompas);
	    unaPartitura.getCompases().add(doceCompas);
	    unaPartitura.getCompases().add(treceCompas);
	    unaPartitura.getCompases().add(catorceCompas);
	    unaPartitura.getCompases().add(quinceCompas);
	    unaPartitura.getCompases().add(dieciseisCompas);



	    Cancion cancion=new Cancion(unaPartitura,"Marcha de los santos","nose",2);


	}

}
