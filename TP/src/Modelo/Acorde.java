package Modelo;
import java.util.ArrayList;

public class Acorde extends ElementoDePartitura {

	//Atributos:
	private ArrayList<Nota> notas;

	//Métodos:
	public Acorde(Figura laDuracion, ArrayList<Nota> lasNotas){
		this.duracion = laDuracion;
		this.notas = lasNotas;
		this.puntajeIdeal = (this.notas.size()*5);
	}

	public ArrayList<Nota> getNotas(){
		return (notas);
	}

	public double getPuntajeIdeal(){
		return (puntajeIdeal);
	}

	public Figura getFigura(){
		return(duracion);

	}



}



