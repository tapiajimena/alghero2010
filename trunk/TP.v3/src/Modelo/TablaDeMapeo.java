package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * La funcion de esta clase es armar un map a partir de una cancion.
 * Este map es de la forma: Segundo-Elemento de partitura
 */
public class TablaDeMapeo {

	//Atributos:

	private Map<Double,ElementoDePartitura> tabla;
	private Cancion cancion;
	private double cantidadDeSegundosDeLaCancion;
	//El array de segundos guarda los segundos en los que hay
	//elementos de paritura.
	private ArrayList<Double> arrayDeSegundos;

	// Métodos:

	public TablaDeMapeo(Cancion unaCancion){
		this.cancion = unaCancion;
		this.tabla =new HashMap<Double,ElementoDePartitura>();
		this.arrayDeSegundos =new ArrayList<Double>();
		this.cantidadDeSegundosDeLaCancion=0;


	}

	public ArrayList<Double> getArrayDeSegundos(){
		return (this.arrayDeSegundos);
	}

	public  Map<Double,ElementoDePartitura> getTabla(){
		return (this.tabla);
	}

	public Cancion getCancion(){
		return (this.cancion);
	}

	public double getCantidadDeSegundosDeLaCancion(){
		return (this.cantidadDeSegundosDeLaCancion);
	}

	/*
	 * Arma la tabla de mapeo a partir de la cancion.
	 */

	public void armarTabla(){

		double tiempoDeNegra = this.cancion.getTiempoDeNegra();



		double tiempo=0;

		Partitura laPartitura=this.getCancion().getPartitura();

		int cantidadDeCompases=laPartitura.getCompases().size();

		for (int i = 0; i < cantidadDeCompases ; i++){

			Compas compasActual=laPartitura.getCompases().get(i);

			for (int j = 0; j < compasActual.getElementosDePartitura().size(); j++){

				ElementoDePartitura elementoActual=compasActual.getElementosDePartitura().get(j);


                this.arrayDeSegundos.add(tiempo);
				this.tabla.put(tiempo, elementoActual);
				tiempo=tiempo+ elementoActual.getFigura().duracion(tiempoDeNegra);




			}



			}
		this.cantidadDeSegundosDeLaCancion=tiempo;



	}
}