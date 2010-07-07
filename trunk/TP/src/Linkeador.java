import java.util.ArrayList;

import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.TablaDeMapeo;


public class Linkeador {

	private TablaDeMapeo tabla;
	private ArrayList<Struct> contenedor;


	public Linkeador(Partitura unaPartitura){

		  Cancion unaCancion=new Cancion(unaPartitura,"titulo","artista",2);

		    this.tabla=new TablaDeMapeo(unaCancion);

		    this.tabla.armarTabla();

	}

	public ArrayList<Struct> getContenedor(){

		int i = 0;
		int segundosTranscurridos = 0;

		while ( segundosTranscurridos <= this.tabla.getCantidadDeSegundosDeLaCancion()){

			//usariamos este tiempo para ver cuando viene la proxima nota... no?
			this.tabla.getCancion().getTiempoDeNegra();

			//cargo el struct con el tiempo y la columna
			Struct dato = new Struct(0,0);

			//lo meto en el contenedor
			this.contenedor.add(i,dato);
			i++;

			//lleva la cuenta de los segundos transcurridos de la cancion
			segundosTranscurridos += 0;
		}

		return contenedor;

	}





}