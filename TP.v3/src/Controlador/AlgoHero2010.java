package Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import Audio.Elemento;
import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Compas;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.Fa;
import Modelo.Mi;
import Modelo.Negra;
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

public class AlgoHero2010 implements ObjetoVivo{

	private ControladorJuego controlador = null;
	private ZonaDeJuego laZonaDeJuego;
	private VistaZonaDeJuego laVistaZonaDeJuego;
	private LinkedList<Pelota> pelotitas = new LinkedList<Pelota>();
	private Pelota Pelota1;
	private Pelota Pelota2;
	private int contador;


	public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

		// Uso este contador para debuggear vivir(). Hay que borrarlo dsp.
		contador = 0;

		laZonaDeJuego = new ZonaDeJuego(600, 600);

		controlador = new ControladorJuego(true);
		controlador.setSuperficieDeDibujo(superficieDeDibujo);

		laVistaZonaDeJuego = new VistaZonaDeJuego();
		laVistaZonaDeJuego.setPosicionable(laZonaDeJuego);

		controlador.agregarObjetoVivo(this);

		controlador.agregarDibujable(laVistaZonaDeJuego);


		controlador.setIntervaloSimulacion(10);

	}

	public LinkedList<Pelota> getPelotitas(){
		return pelotitas;
	}

	public void comenzar(){
		controlador.comenzarJuegoAsyn();
	}

	public void detener() {
		controlador.detenerJuego();
	}


	public void vivir() {

		/* ESTE ES EL DE ANTES: NOSE COMO CAMBIARLO PARA QUE ANDE
		 * AHORA CON EL TITIRITERO
		 *
		 *
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

		Compas segundoCompas= new Compas(unaArmadura);
		Nota notaUno=new Nota(otraNegra,unMi);
		Nota notaDos=new Nota(otraNegra,unDo);
		Nota notaTres=new Nota(otraNegra,unRe);
		Nota notaCuatro=new Nota(otraNegra,unFa);
		Nota notaCinco=new Nota(otraNegra,unDoSostenido);
		Nota notaSeis=new Nota(otraNegra,unSol);

		try {
			segundoCompas.addElementoDePartitura(notaUno);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaDos);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaTres);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaCuatro);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaCinco);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaSeis);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);


	    ArmadorDeContenedor unArmador=new ArmadorDeContenedor(unaPartitura);
	    ArrayList<ElementoDeContenedor> contenedor =new ArrayList<ElementoDeContenedor>();
	    contenedor = unArmador.getContenedor();


	    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();


        // Pedimos la fecha del comienzo del ciclo.
        long time = System.currentTimeMillis();
        Date fechaDeComienzo = new Date(time);
        int j = 0;

        while(true){

        	// Borramos las pelotitas que ya terminaron de dibujarse.
        	for(int i = 0 ; i < ventanaPrincipal.getPelotitas().size() ; i++){

        		if(((ventanaPrincipal.getPelotitas()).get(i)).getCentroY() > (ventanaPrincipal.getPanel()).getHeight())
        			(ventanaPrincipal.getPelotitas()).remove(i);

        	}

        	// Dibujamos todas las pelotitas que hay que dibujar
        	ventanaPrincipal.run();

        	// Nos fijamos si hay que agregar alguna pelotita mas.

        	time = System.currentTimeMillis();
            Date fechaActual = new Date(time);

            // Este if lo ponemos para no acceder a un elemento no existente de
            // contenedor.

            if(j < contenedor.size()){

            	if((fechaActual.getTime() - fechaDeComienzo.getTime()) > 1000 * (contenedor.get(j)).getSegundo()){

            		// Cambiar getColumna de double a int.
            		ventanaPrincipal.addPelotita((int)(contenedor.get(j)).getColumna());
            		j++;
            	}
            }
        }

    }
		 *
		 *
		 */




         //ESTE ES EL QUE HABIAS PUESTO VOS CLAUDIO
	    //LO ARREGLE CON LO QUE DIJO FEDERICO, AHORA ANDA


		if(contador == 0){

			contador++;;

			this.Pelota1 = new Pelota(0,laZonaDeJuego);
			VistaPelota vistaPelota1 = new VistaPelota(Pelota1.getColumna());
			vistaPelota1.setPosicionable(this.Pelota1);
			controlador.agregarObjetoVivo(Pelota1);
			controlador.agregarDibujable(vistaPelota1);

			this.Pelota2 = new Pelota(1,laZonaDeJuego);
			VistaPelota vistaPelota2 = new VistaPelota(Pelota2.getColumna());
			vistaPelota2.setPosicionable(this.Pelota2);
			controlador.agregarObjetoVivo(Pelota2);
			controlador.agregarDibujable(vistaPelota2);


			System.out.println("Creamos una pelota");






	}



	}


}
