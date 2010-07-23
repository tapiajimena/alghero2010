package Modelo;

import org.dom4j.Element;

public abstract class ElementoDePartitura {

	//Atributos:
	protected Figura duracion;
	protected double puntajeIdeal;

	//Métodos:
	public abstract int obtenerCantidadDeElementos();
	public abstract int obtenerCantidadDeSonidos();
	public abstract Element guardar();
	public abstract ElementoDePartitura recuperar(Element elemDeParitura);
	public Figura getFigura(){
		return(duracion);

	}


	public double getPuntajeIdeal(){
		return (puntajeIdeal);
	}

}



