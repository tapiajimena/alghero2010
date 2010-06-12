package Modelo;
import java.util.ArrayList;

public class Acorde extends ElementoDePartitura {

	//Atributos:
	private ArrayList<Sonido> sonidos;

	//Métodos:
	public Acorde(Figura laDuracion, ArrayList<Sonido> losSonidos){
		this.duracion = laDuracion;
		this.sonidos = losSonidos;
		this.puntajeIdeal = (this.obtenerCantidadDeSonidos()*5);
	}

	//Si la figura del acorde no es un silencio entonces suma todos los
	// sonidos para hallar la cantidad de sonidos

	public int obtenerCantidadDeSonidos(){
		int cantidad=0;
		if (!this.duracion.esSilencio()){
			cantidad=sonidos.size();


		}
		return cantidad;
	}

	//Devuelve la cantidad de elementos sin importar si su figura asociada es un silencio

	public int obtenerCantidadDeElementos(){
		return sonidos.size();
	}

	public ArrayList<Sonido> getSonidos(){
		return (sonidos);
	}

	public double getPuntajeIdeal(){
		return (puntajeIdeal);
	}





}



