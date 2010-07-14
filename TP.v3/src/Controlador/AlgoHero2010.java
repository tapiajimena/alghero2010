package Controlador;

import java.util.ArrayList;
import java.util.LinkedList;

import Audio.Elemento;
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

		// ===============================================================
		// Agrego en el constructor una pelota.

		this.Pelota1 = new Pelota(0,laZonaDeJuego);
		VistaPelota vistaPelota1 = new VistaPelota(Pelota1.getColumna());
		vistaPelota1.setPosicionable(this.Pelota1);
		controlador.agregarObjetoVivo(Pelota1);
		controlador.agregarDibujable(vistaPelota1);

		//================================================================

		controlador.setIntervaloSimulacion(10);

	}

	public void comenzar(){
		controlador.comenzarJuegoAsyn();
	}

	public void detener() {
		controlador.detenerJuego();
	}


	public void vivir() {



		if(contador == 0){

			contador++;;

			this.Pelota2 = new Pelota(1,laZonaDeJuego);


			VistaPelota vistaPelota2 = new VistaPelota(Pelota2.getColumna());
			vistaPelota2.setPosicionable(this.Pelota2);

			// Esta linea pincha, produce una pantalla amarilla no se
			// porque. Si se quita esta linea, se puede ver como si
			// cae una pelota y la otra queda quieta arriba de todo.
			// Alguna solucion?
			controlador.agregarObjetoVivo(Pelota2);


			controlador.agregarDibujable(vistaPelota2);

			System.out.println("Creamos una pelota");


		}


	}


}
