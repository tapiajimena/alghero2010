package Persistencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import Audio.Elemento;
import Audio.Reproductor;
import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Corchea;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.ElementoDeContenedor;
import Modelo.Fa;
import Modelo.Juego;
import Modelo.Letra;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.NivelFacil;
import Modelo.NivelMedio;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sol;
import Modelo.Sonido;
import Vista.VentanaAplicacion;
import Vista.VentanaPrincipal;
import Vista.ZonaDeJuego;
import Vista.Pelota;
import Vista.VistaZonaDeJuego;
import Vista.VistaPelota;

public class Principal {
	public static void main(String[] args) {

	Negra negra=new Negra(false);
	ArmaduraDeClave unaArmadura=new ArmaduraDeClave(4,negra);
	Compas primerCompas= new Compas(unaArmadura);

	Mi unMi=new Mi();
	Fa unFa=new Fa();
	Sol unSol=new Sol();
	Nota notaMi=new Nota(negra,unMi);
	Nota notaFa=new Nota(negra,unFa);
	Nota notaSol=new Nota(negra,unSol);

	try {
		primerCompas.addElementoDePartitura(notaMi);
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
	try {
		primerCompas.addElementoDePartitura(notaSol);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Re unRe=new Re();
	Nota notaRe=new Nota(negra,unRe);
	Compas segundoCompas= new Compas(unaArmadura);
	try {
		segundoCompas.addElementoDePartitura(notaSol);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		segundoCompas.addElementoDePartitura(notaFa);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		segundoCompas.addElementoDePartitura(notaMi);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		segundoCompas.addElementoDePartitura(notaRe);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	Do unDo=new Do();
	Nota notaDo=new Nota(negra,unDo);
	Compas tercerCompas= new Compas(unaArmadura);
	try {
		tercerCompas.addElementoDePartitura(notaDo);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		tercerCompas.addElementoDePartitura(notaDo);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		tercerCompas.addElementoDePartitura(notaRe);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		tercerCompas.addElementoDePartitura(notaMi);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Blanca blanca=new Blanca(false);
	Nota otraNotaRe=new Nota(blanca,unRe);
	Compas cuartoCompas= new Compas(unaArmadura);
	try {
		cuartoCompas.addElementoDePartitura(notaMi);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cuartoCompas.addElementoDePartitura(notaRe);
	} catch (CompasLlenoException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		cuartoCompas.addElementoDePartitura(otraNotaRe);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Nota otraNotaDo=new Nota(blanca,unDo);
	Compas octavoCompas= new Compas(unaArmadura);
	try {
		octavoCompas.addElementoDePartitura(notaRe);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		octavoCompas.addElementoDePartitura(notaDo);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		octavoCompas.addElementoDePartitura(otraNotaDo);
	} catch (CompasLlenoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Partitura unaPartitura=new Partitura();
    unaPartitura.getCompases().add(primerCompas);
    unaPartitura.getCompases().add(segundoCompas);
    unaPartitura.getCompases().add(tercerCompas);
    unaPartitura.getCompases().add(cuartoCompas);
    unaPartitura.getCompases().add(primerCompas);
    unaPartitura.getCompases().add(segundoCompas);
    unaPartitura.getCompases().add(tercerCompas);
    unaPartitura.getCompases().add(octavoCompas);

    Cancion unaCancion=new Cancion(unaPartitura,"Himno de la alegría","Beethoven",1);
    Cancion otraCancion=null;


   try{
        unaCancion.guardar("himnoDeLaAlegria.xml");
        }catch(IOException ex){
           System.out.println("Problemas" + ex);
        }


        try{
         otraCancion = Cancion.recuperar("superPrueba!.xml");

        }catch(IOException ex){
            System.out.println("no lo cargaaaaa");
        }

     /*   try{
            unaCancion.guardar("posta.xml");
            }catch(IOException ex){
               System.out.println("Problemas" + ex);
            }*/



        System.out.println(unaCancion.getNombre());
}}
