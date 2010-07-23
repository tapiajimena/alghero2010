package Modelo;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Acorde extends ElementoDePartitura {

	//Atributos:
	private ArrayList<Sonido> sonidos;

	//Métodos:

	  public  Acorde recuperar(Element elemAcorde) {

		  Element elementoDeFigura=elemAcorde.element("Figura");
	      Figura unaFigura = Figura.recuperar(elementoDeFigura);

		  ArrayList<Sonido> sonidos=new ArrayList<Sonido>();

	       Iterator it = elemAcorde.elementIterator();
	       while(it.hasNext()){
	           Element elemActual = (Element)it.next();
	           sonidos.add(Sonido.recuperar(elemActual));
	       }
	       Acorde acorde=new Acorde(unaFigura,sonidos);
	       return acorde;
	   }

	public Element guardar() {
	       Element elemAcorde = DocumentHelper.createElement("Acorde");
	       elemAcorde.add(this.getFigura().guardar());
	       Iterator it = sonidos.iterator();
	       while(it.hasNext()){
	           Sonido sonido = (Sonido)it.next();
	           elemAcorde.add(sonido.guardar());
	       }

	       return elemAcorde;
	   }

	public Acorde(Figura laDuracion, ArrayList<Sonido> losSonidos){
		this.duracion = laDuracion;
		this.sonidos = losSonidos;
		this.puntajeIdeal = (this.obtenerCantidadDeSonidos()*5);
	}

	//Si la figura del acorde no es un silencio entonces suma todos los
	// sonidos para hallar la cantidad de sonidos

	public int obtenerCantidadDeSonidos(){
		int cantidad=0;
		if (!this.duracion.esSilencio()){
			cantidad=sonidos.size();


		}
		return cantidad;
	}

	//Devuelve la cantidad de elementos sin importar si su figura asociada es un silencio

	public int obtenerCantidadDeElementos(){
		return sonidos.size();
	}

	public ArrayList<Sonido> getSonidos(){
		return (sonidos);
	}


}



