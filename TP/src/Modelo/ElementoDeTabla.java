package Modelo;

public class ElementoDeTabla {

	//Atributos:
	private double tiempo;
	private ElementoDePartitura elemento;


	//Métodos:
	public ElementoDeTabla(double unTiempo, ElementoDePartitura unElemento){
		this.tiempo = unTiempo;
		this.elemento = unElemento;
	}

	double getTiempo(){
		return this.tiempo;
	}

	ElementoDePartitura getElemento(){
		return this.elemento;
	}

}
