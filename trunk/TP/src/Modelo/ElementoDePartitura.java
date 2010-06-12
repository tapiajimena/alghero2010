package Modelo;
public abstract class ElementoDePartitura {

	//Atributos:
	protected Figura duracion;
	protected double puntajeIdeal;

	//Métodos:
	public abstract int obtenerCantidadDeElementos();
	public abstract int obtenerCantidadDeSonidos();
	public Figura getFigura(){
		return(duracion);

	}

}



