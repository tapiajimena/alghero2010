package Modelo;

import java.util.ArrayList;

public class Puntaje {

	//Atributos:

	/* Lleva la cuenta del puntaje acumulado */
	private double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	private double minimo;


	//M�todos:

	public Puntaje(){
		this.puntajeActual = 0;
		this.minimo = 0;
	}

	public void acumularPuntos(double puntos){
		this.puntajeActual += puntos;
	}

	public void setPuntajeMinimo(ArrayList<Cancion> canciones){
		int puntos = 0;
		for (int i = 0; i <= canciones.get(0).getPartitura().getCompases().size(); i++){
			for (int j = 0; j <= canciones.get(0).getPartitura().getCompases().get(j).getElementoDePartitura().size(); j++){
				int k = 0;
				puntos += canciones.get(0).getPartitura().getCompases().get(j).getElementoDePartitura().get(k).


			}

		}
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
