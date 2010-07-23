package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import persistenciaNoOficial.Nota;

public class ArmaduraDeClave {

	//Atributos:

	private int numerador;
    private Figura denominador;

    //Métodos:

    public static ArmaduraDeClave recuperar(Element elemDeArmadura) {


    	String numeradorEnString = elemDeArmadura.attributeValue("Numerador");
        double numerador=Double.valueOf(numeradorEnString).doubleValue();
        Element elementoDeFigura=elemDeArmadura.element("Figura");
        Figura unaFigura = Figura.recuperar(elementoDeFigura);


        ArmaduraDeClave armadura=new ArmaduraDeClave((int)numerador,unaFigura);
        return armadura;
    }

    public Element guardar() {
        Element elemArmadura = DocumentHelper.createElement("Armadura De Clave");
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
