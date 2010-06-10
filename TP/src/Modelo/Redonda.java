package Modelo;

public class Redonda extends Figura{

	//Métodos:
	public Redonda(boolean esSilencio){
		this.silencio = esSilencio;
	}

	public double getIdentificador(){
		return(4);
	}

	public double duracion(double tiempoDeNegra){
	   return(4*tiempoDeNegra);
   }

}
