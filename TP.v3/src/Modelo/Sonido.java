package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class Sonido {

	//Métodos:
	public static Sonido recuperar(Element elemDeSonido) {

        Object sonido=null;
		String identificadorEnString = elemDeSonido.attributeValue("Identificador");
		int identificador = Integer.parseInt(identificadorEnString);

	    if((int)identificador==60){
	    	sonido=new Do();

	    }
	    if((int)identificador==62){
	    	sonido=new Re();

	    }
	    if((int)identificador==64){
	    	sonido=new Mi();

	    }
	    if((int)identificador==65){
	    	sonido=new Fa();

	    }
	    if((int)identificador==67){
	    	sonido=new Sol();

	    }
	    if((int)identificador==69){
	    	sonido=new La();

	    }
	    if((int)identificador==71){
	    	sonido=new Si();

	    }
	    if((int)identificador==61){
	    	sonido=new DoSostenido();

	    }
	    if((int)identificador==66){
	    	sonido=new FaSostenido();

	    }
	    if((int)identificador==68){
	    	sonido=new SolSostenido();

	    }
	    if((int)identificador==69){
	    	sonido=new LaSostenido();

	    }
	    if((int)identificador==63){
	    	sonido=new ReSostenido();

	    }
	    return (Sonido)sonido;
	}


	public Element guardar() {
	       Element elemSonido = DocumentHelper.createElement("Sonido");
	       elemSonido.addAttribute("Identificador", String.valueOf(this.getIdentificador()));


	       return elemSonido;
	   }


	public abstract int getIdentificador();



}
