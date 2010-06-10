package Modelo;

public class Puntaje {

	//Atributos:

	/* Lleva la cuenta del puntaje acumulado */
	private double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	private double minimo;


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

	/* Se usa para preguntar si se ha superado el nivel */
	public boolean esSuficiente(){
		if (this.puntajeActual >= this.minimo) return true;
		else return false;
	}



}
