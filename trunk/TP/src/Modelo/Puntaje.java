package Modelo;

import java.util.ArrayList;

public class Puntaje {

	//Atributos:

	/* Lleva la cuenta del puntaje acumulado */
	private double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	private double minimo;

	/* Porcentage minimo a ser alcanzado para superar el nivel */
	private double porcentageMinimo;



	//Métodos:

	public Puntaje(double porcentage){
		this.puntajeActual = 0;
		this.minimo = 0;
		this.porcentageMinimo = porcentage;
	}

	public void acumularPuntos(double puntos){
		this.puntajeActual += puntos;
	}

	public void setPuntajeMinimo(Nivel unNivel){
		int j = unNivel.canciones.size();
		for (int i=0; i<=j; i++){
			this.minimo += unNivel.elegirCancion(i).getPuntajeIdeal()* this.porcentageMinimo;
		}
	}

	public double getPuntaje(){
		return this.puntajeActual;
	}

	public double getMinimo(){
		return this.minimo;
	}

	/* Se usa para preguntar si se ha superado el nivel */
	public boolean esSuficiente(){
		if (this.puntajeActual >= this.minimo) return true;
		else return false;
	}



}
