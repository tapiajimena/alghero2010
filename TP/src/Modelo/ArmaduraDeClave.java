package Modelo;
public class ArmaduraDeClave {

	//Atributos:

	private int numerador;
    private Figura denominador;

  //Métodos:

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
