 package Modelo;
import java.util.ArrayList;

public class Juego {

	//Atributos:

	private ArrayList<Nivel> niveles;
	private double puntaje;
	private double puntajeIdeal;
	private double contadorDeErrores;
	private double contadorDeAciertos;
	private double contadorDePerfectos;

	//Métodos:
	public Juego(){
	}

	public double obtenerPuntajeIdeal(){
		return(4.0);
	}

}
