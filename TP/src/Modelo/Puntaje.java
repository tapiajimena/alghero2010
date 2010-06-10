package Modelo;

public class Puntaje {

	//Atributos:

	/* Lleva la cuenta del puntaje acumulado */
	private double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	private double minimo;


	//Métodos:

	Puntaje(double minimoPorNivel){
		this.puntajeActual = 0;
		this.minimo = minimoPorNivel;
	}

}
