package Modelo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ArmaduraDeClave {

	//Atributos:

	private int numerador;
    private Figura denominador;

    //Métodos:

    public Element guardar() {
        Element elemArmadura = DocumentHelper.createElement("Armadura De Clave");
        elemArmadura.addAttribute("Numerador", String.valueOf(this.getNumerador()));
        elemArmadura.addAttribute("Denominador", String.valueOf(this.getDenominador()));


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
