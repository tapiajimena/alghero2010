package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class ArmaduraDeClave {

	//Atributos:

	private int numerador;
    private Figura denominador;

    //Métodos:

	/*Recupera la armadura de clave a partir de un elemento de xml.
	 *
	 */


    public static ArmaduraDeClave recuperar(Element elemDeArmadura) {

        Element elementoDeFigura=elemDeArmadura.element("Figura");
        Figura unaFigura = Figura.recuperar(elementoDeFigura);
        String numeradorEnString = elemDeArmadura.attributeValue("Numerador");
        double numerador=Double.valueOf(numeradorEnString).doubleValue();


        ArmaduraDeClave armadura=new ArmaduraDeClave((int)numerador,unaFigura);
        return armadura;
    }

	  /*Guarda la armadura de clave en un elemento de xml
	   *
	   *
	   */

    public Element guardar() {
        Element elemArmadura = DocumentHelper.createElement("ArmaduraDeClave");
        elemArmadura.addAttribute("Numerador", String.valueOf(this.getNumerador()));
        elemArmadura.add(this.getDenominador().guardar());


        return elemArmadura;
    }

	public ArmaduraDeClave(int elNumerador, Figura elDenominador){
		this.numerador=elNumerador;
		this.denominador=elDenominador;

	}

	public int getNumerador(){
		return(numerador);
	}

	public Figura getDenominador(){
		return (denominador);
	}

}