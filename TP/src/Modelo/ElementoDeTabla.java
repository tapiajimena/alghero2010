package Modelo;

public class ElementoDeTabla {

	//Atributos:
	private double tiempo;
	private ElementoDePartitura elemento;


	//M�todos:
	public ElementoDeTabla(double unTiempo, ElementoDePartitura unElemento){
		this.tiempo = unTiempo;
		this.elemento = unElemento;
	}

	public double getTiempo(){
		return this.tiempo;
	}

	public ElementoDePartitura getElemento(){
		return this.elemento;
	}

}
