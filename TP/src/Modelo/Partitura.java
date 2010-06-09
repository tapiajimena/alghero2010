package Modelo;
import java.util.ArrayList;

public class Partitura {

	//Atributos:
	private ArrayList<Compas> compases;

	//Métodos:
	public Partitura(){
		this.compases= new ArrayList<Compas>();
	}

	public void addCompas(Compas unCompas){
		this.compases.add(unCompas);
	}

	public ArrayList<Compas> getCompases(){

		return(this.compases);
	}






}

