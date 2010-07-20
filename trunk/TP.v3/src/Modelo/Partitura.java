package Modelo;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import persistenciaNoOficial.Nota;

public class Partitura {

	//Atributos:

	private ArrayList<Compas> compases;

	//Métodos:

	public Element guardar() {
	       Element elemPartitura = DocumentHelper.createElement("Partitura");
	       Iterator it = compases.iterator();
	       while(it.hasNext()){
	           Compas compas = (Compas)it.next();
	           elemPartitura.add(compas.guardar());
	       }
	       return elemPartitura;
	   }

	public Partitura(){
		this.compases = new ArrayList<Compas>();
	}

	public void addCompas(Compas unCompas){
		this.compases.add(unCompas);
	}

	public ArrayList<Compas> getCompases(){
		return(this.compases);
	}






}

