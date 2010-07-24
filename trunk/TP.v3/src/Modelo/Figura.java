package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class Figura {

	//Atributos:

	protected boolean silencio;
	protected int identificador;

	//Métodos:

	public static Figura recuperar(Element elemDeFigura) {

        Object figura=null;
		String identificadorEnString = elemDeFigura.attributeValue("Identificador");
		String esSilencioEnString = elemDeFigura.attributeValue("EsSilencio");
	    double identificador=Double.valueOf(identificadorEnString).doubleValue();
	    boolean esSilencio=Boolean.valueOf(identificadorEnString).booleanValue();

	    if(identificador==1){
        	figura=new Negra(esSilencio);

        }
        if(identificador==2){
        	figura=new Blanca(esSilencio);

        }
        if(identificador==4){
        	figura=new Redonda(esSilencio);

        }


        if(identificador==0.5){
        	figura=new Corchea(esSilencio);

        }
        if(identificador==0.25){
        	figura=new SemiCorchea(esSilencio);

        }
        return (Figura)figura;
	}

	public Element guardar() {
	       Element elemFigura = DocumentHelper.createElement("Figura");
	       elemFigura.addAttribute("EsSilencio", String.valueOf(this.esSilencio()));
	       elemFigura.addAttribute("Identificador", String.valueOf(this.getIdentificador()));


	       return elemFigura;
	   }

	public abstract double getIdentificador();

	public abstract double duracion(double tiempoDeNegra);

	public boolean esSilencio(){
		return(silencio);
	}



}
