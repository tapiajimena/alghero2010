package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class Figura {

	//Atributos:

	protected boolean silencio;
	protected int identificador;

	//Métodos:

	public Element guardar() {
	       Element elemFigura = DocumentHelper.createElement("Figura");
	       elemFigura.addAttribute("Es Silencio", String.valueOf(this.esSilencio()));
	       elemFigura.addAttribute("Identificador", String.valueOf(this.getIdentificador()));


	       return elemFigura;
	   }

	public abstract double getIdentificador();

	public abstract double duracion(double tiempoDeNegra);

	public boolean esSilencio(){
		return(silencio);
	}



}