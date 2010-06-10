package Modelo;

public class Puntaje {

	//Atributos:

	/* Lleva la cuenta del puntaje acumulado */
	private double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	private double minimo;

	/* */


	//Métodos:

	public Puntaje(double minimoPorNivel){
		this.puntajeActual = 0;
		this.minimo = minimoPorNivel;
	}

	public void acumularPuntos(double puntos){
		this.puntajeActual += puntos;
	}

	public double getPuntaje(){
		return this.puntajeActual;
	}

	public boolean esSuficiente(){
		if ((this.puntajeActual - this.minimo)<= diferencia minima aceptable para dar aprobado el nivel) return true;
		else return false;
	}



}
