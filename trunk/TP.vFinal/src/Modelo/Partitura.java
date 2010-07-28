package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class Partitura {

	//Atributos:

	private ArrayList<Compas> compases;

	//Métodos:

	/*
	 * Recupera la partitura a partir de un elemento de xml.
	 */

	   @SuppressWarnings("unchecked")
	public static Partitura recuperar(Element elemPartitura) {
	       Partitura partitura = new Partitura();
	       Iterator it = elemPartitura.elementIterator();
	       while(it.hasNext()){
	           Element elemCompas = (Element)it.next();
	           partitura.addCompas(Compas.recuperar(elemCompas));
	       }
	       return partitura;
	   }

		/*
		 * Guarda la partitura en un elemento de xml.
		 */

	@SuppressWarnings("unchecked")
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

