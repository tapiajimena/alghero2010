package Modelo;

import org.dom4j.Element;

/*
 * Los elementos de partitura son aquellos que se almacenan en los
 * compases de la partitura. Pueden ser notas o acordes.
 */

public abstract class ElementoDePartitura {

	//Atributos:
	protected Figura duracion;
	protected double puntajeIdeal;

	//Métodos:
	public abstract int obtenerCantidadDeElementos();
	public abstract int obtenerCantidadDeSonidos();
	public abstract Element guardar();
	public Figura getFigura(){
		return(duracion);

	}


	public double getPuntajeIdeal(){
		return (puntajeIdeal);
	}

}



