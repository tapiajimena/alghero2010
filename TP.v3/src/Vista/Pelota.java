package Vista;


import java.util.Iterator;

import Controlador.ObjetoVivo;
import Controlador.Posicionable;


public class Pelota implements ObjetoVivo, Posicionable {

	private int x;
	private int y;
	private int columna;
	private ZonaDeJuego mesa;
	private int sentidoY;

	public Pelota(int laColumna, ZonaDeJuego laMesa){
		this.mesa = laMesa;
		this.sentidoY = 2;
		this.y = 0;
		this.columna = laColumna;
		this.x = (mesa.getAncho()/6) * columna;
	}

	public int getX() {

		return x;

	}

	public int getY() {

		return y;

	}

	public int getColumna(){

		return columna;

	}

	public ZonaDeJuego getMesa() {

		return mesa;

	}

	public int getSentidoY(){

		return sentidoY;

	}

	public void setX(int elX) {

		this.x = elX;
	}

	public void setY(int elY) {

		this.y = elY;

	}

	public void setColumna(int laColumna) {

		this.columna = laColumna;
		this.x = (mesa.getAncho()/6) * columna;

	}

	public void setMesa(ZonaDeJuego mesa) {

		this.mesa = mesa;

	}

	public void setSentidoY(int elSentidoY){

		this.sentidoY = elSentidoY;

	}

	public void vivir() {

		y += this.sentidoY;

	}



}
