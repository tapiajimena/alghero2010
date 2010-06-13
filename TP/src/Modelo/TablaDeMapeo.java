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
		this.tabla = new ArrayList<ElementoDeTabla>();

	}

	public ArrayList<ElementoDeTabla> getTabla(){
		return (this.tabla);
	}

	public Cancion getCancion(){
		return (this.cancion);
	}

	public void armarTabla(){

		double tiempoDeNegra = this.cancion.getTiempoDeNegra();



		double tiempo=0;

		Partitura laPartitura=this.getCancion().getPartitura();

		int cantidadDeCompases=laPartitura.getCompases().size();

		for (int i = 0; i < cantidadDeCompases ; i++){

			Compas compasActual=laPartitura.getCompases().get(i);

			for (int j = 0; j < compasActual.getElementosDePartitura().size(); j++){

				ElementoDePartitura elementoActual=compasActual.getElementosDePartitura().get(j);


				ElementoDeTabla unElemento=new ElementoDeTabla(tiempo,elementoActual);
				this.tabla.add(unElemento);
				tiempo=tiempo+ elementoActual.getFigura().duracion(tiempoDeNegra);




			}



			}



	}
}