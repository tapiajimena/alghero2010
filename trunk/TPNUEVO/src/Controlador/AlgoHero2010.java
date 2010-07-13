package Controlador;

import java.util.ArrayList;

import Audio.Elemento;
import Modelo.ZonaDeJuego;
import Modelo.Pelota;
import Vista.VistaMesa;
import Vista.VistaPelota;

public class AlgoHero2010 implements ObjetoVivo{

	private ControladorJuego controlador = null;
	private Pelota Pelota1;
	private Pelota Pelota2;


	public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

		ZonaDeJuego unaMesa = new ZonaDeJuego(600, 600);

		this.Pelota1 = new Pelota(0,unaMesa);

		this.Pelota2 = new Pelota(1,unaMesa);

		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */
		controlador = new ControladorJuego(true);
		controlador.setSuperficieDeDibujo(superficieDeDibujo);


		/*
		 * Instancio un cuadrado para que actue como vista de la mesa
		 */
		VistaMesa vistaMesa = new VistaMesa();
		vistaMesa.setPosicionable(unaMesa);

		/*
		 * Instancio una imagen para que actue como vista de la pelota
		 */
		VistaPelota vistaPelota1 = new VistaPelota(Pelota1.getColumna());
		vistaPelota1.setPosicionable(this.Pelota1);

		VistaPelota vistaPelota2 = new VistaPelota(Pelota2.getColumna());
		vistaPelota2.setPosicionable(this.Pelota2);

		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		controlador.agregarObjetoVivo(Pelota1);
		controlador.agregarObjetoVivo(Pelota2);
		controlador.agregarObjetoVivo(this);

		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */

		controlador.agregarDibujable(vistaMesa);
		controlador.agregarDibujable(vistaPelota1);
		controlador.agregarDibujable(vistaPelota2);

		controlador.agregarMouseClickObservador(vistaMesa);

		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(20);
	}

	public void comenzar(){
		controlador.comenzarJuegoAsyn();
	}

	public void detener() {
		controlador.detenerJuego();
	}


	//@Override
	public void vivir() {

		//Que debe hacer este método?

	}
}
