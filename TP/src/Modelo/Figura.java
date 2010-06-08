package Modelo;

public abstract class Figura {

	//Atributos:

	protected boolean silencio;
	protected int identificador;

	//Métodos:
	public abstract double getIdentificador();

	public abstract double duracion(double tiempoDeNegra);

	public boolean esSilencio(){
		return(silencio);
	}



}