package Modelo;

import java.util.Iterator;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Nota extends ElementoDePartitura{

	//Atributos:
	private Sonido tipo;

	//Métodos:

	/*
	 * Recupera la nota a partir de un elemento de xml.
	 */

    public static Nota recuperar(Element elemDeNota) {

    	Element elementoDeSonido=elemDeNota.element("Sonido");
    	Element elementoDeFigura=elemDeNota.element("Figura");

    	    Sonido sonido=Sonido.recuperar(elementoDeSonido);
    	    Figura figura=Figura.recuperar(elementoDeFigura);
    	    Nota nota=new Nota(figura,sonido);



        return nota;
    }

	/*
	 * Guarda la nota en un elemento de xml.
	 */

	public Element guardar() {
	       Element elemNota = DocumentHelper.createElement("Nota");
	       elemNota.add(this.getSonido().guardar());
	       elemNota.add(this.getFigura().guardar());

	       return elemNota;
	   }



	public Nota(Figura laDuracion, Sonido elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
		/* Se establece que el puntaje ideal será de 5 por cada nota */
		this.puntajeIdeal = this.obtenerCantidadDeSonidos()*5;;
	}


	/* Si la figura de la nota no es un silencio entonces la cantidad
	 * de sonidos es 1
	 */

	public int obtenerCantidadDeSonidos(){
		int cantidad=0;


		if(!this.duracion.esSilencio()){
			cantidad=1;
		}
		return cantidad;


	}
	/* Devuelve la cantidad de elementos sin importar si su figura asociada es
	 * un silencio o no
	 */

	public int obtenerCantidadDeElementos(){
		return 1;

	}

	public Sonido getSonido(){
		return (tipo);
	}


}

