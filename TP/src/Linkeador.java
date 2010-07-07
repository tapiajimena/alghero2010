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
		
		
		
	}





}
