package Modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TablaDeMapeo {

	//Atributos:

	private ArrayList<ElementoDeTabla> tabla;
	private Cancion cancion;

	// Métodos:

	public TablaDeMapeo(Cancion unaCancion){
		this.cancion = unaCancion;
	}

	public ArrayList<ElementoDeTabla> getTabla(){
		return (this.tabla);
	}

	public Cancion getCancion(){
		return (this.cancion);
	}

	public void armarTabla(){
		/* Creacion de variables auxiliares. */
		Partitura partituraAux;
		Compas compasAux;
		ElementoDePartitura elementoDePartituraAux;
		ElementoDeTabla elementoDeTablaAux;
		double tiempoAux = 0;
		double tiempoDeNegraAux = this.cancion.getTiempoDeNegra();

		/* Se crea un iterador de compases. */
		Iterator iterCompases = cancion.getPartitura().getCompases().iterator();

		/* Manejo del primer compás */
		compasAux = cancion.getPartitura().getCompases().get(0);

		/* Se prosigue con los demás compases */
		while(iterCompases.hasNext()){
			/* Pido un iterador de ElementosDePartitura */
			Iterator iterElementosDePartitura =  compasAux.getElementoDePartitura().iterator();

			/* Manejo del primer ElementoDePartitura del compas actual.*/
			elementoDePartituraAux = compasAux.getElementoDePartitura().get(0);

			/* Se prosigue con los siguientes elementos de partitura */
			while(iterElementosDePartitura.hasNext()){

				/* Se carga un elemento de tabla en la tabla de mapeo.*/
				elementoDeTablaAux = new ElementoDeTabla (elementoDePartituraAux.getFigura().duracion(tiempoDeNegraAux),elementoDePartituraAux);
				tabla.add(elementoDeTablaAux);
				tiempoAux = tiempoAux + elementoDePartituraAux.getFigura().duracion(tiempoDeNegraAux);
			}

			compasAux = (Compas) iterCompases.next();
		}
	}
}

