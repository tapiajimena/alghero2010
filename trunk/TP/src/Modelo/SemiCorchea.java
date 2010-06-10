package Modelo;

public class SemiCorchea extends Figura{

	//Métodos:

	public SemiCorchea(boolean esSilencio){
		this.silencio = esSilencio;
	}

	public double getIdentificador(){
		return(0.25);
	}

	public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra/4);
   }

}
