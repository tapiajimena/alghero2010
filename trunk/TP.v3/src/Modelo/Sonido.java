package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class Sonido {

	//M�todos:

	public Element guardar() {
	       Element elemSonido = DocumentHelper.createElement("Sonido");
	       elemSonido.addAttribute("Identificador", String.valueOf(this.getIdentificador()));


	       return elemSonido;
	   }


	public abstract int getIdentificador();

	public abstract double getFrecuenciaFundamental();

}
