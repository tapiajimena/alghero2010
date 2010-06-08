package Modelo;

public abstract class Figura {

	//Atributos:

	protected boolean silencio;
	protected int identificador;

	//M�todos:
	public abstract double getIdentificador();

	public abstract double duracion(double tiempoDeNegra);

	public boolean esSilencio(){
		return(silencio);
	}



}