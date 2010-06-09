package Modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TablaDeMapeo {

	private ArrayList<ElementoDeTabla> tabla;
	private Cancion cancion;

	TablaDeMapeo(Cancion unaCancion){

		this.cancion = unaCancion;

	}

	public ArrayList<ElementoDeTabla> getTabla(){

		return (this.tabla);

	}

	public Cancion getCancion(){

		return (this.cancion);

	}

	public void armarTabla(){

		//Creacion de variables auxiliares

		Partitura partituraAux;
		Compas compasAux;
		ElementoDePartitura elementoDePartituraAux;
		ElementoDeTabla elementoDeTablaAux;
		double tiempoAux = 0;
		double tiempoDeNegraAux = this.cancion.getTiempoDeNegra();


		// Creamos un iterador de compas
		Iterator iterCompases = cancion.getPartitura().getCompases().iterator();

		// Nos paramos en el primer compas de todos porque el iterador no ME DEJA !!!!
		compasAux = cancion.getPartitura().getCompases().get(0);

		// Para todos los compases....
		while(iterCompases.hasNext()){


			// Pido un iterador de ElementosDePartitura
			Iterator iterElementosDePartitura =  compasAux.getElementoDePartitura().iterator();

			// Nos paramos en el primer ElementoDePartitura del compas actual.
			elementoDePartituraAux = compasAux.getElementoDePartitura().get(0);

			// Para todos los elementos de partitura
			while(iterElementosDePartitura.hasNext()){

				//Cargo un elemento de tabla en la tabla de mapeo.
				elementoDeTablaAux = new ElementoDeTabla (elementoDePartituraAux.getFigura().duracion(tiempoDeNegraAux),elementoDePartituraAux);
				tabla.add(elementoDeTablaAux);
				tiempoAux = tiempoAux + elementoDePartituraAux.getFigura().duracion(tiempoDeNegraAux);

			}

			compasAux = (Compas) iterCompases.next();

		}


	}

}