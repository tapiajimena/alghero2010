package Modelo;

public class Blanca extends Figura{

	//M�todos:
	public Blanca(boolean esSilencio){
		this.silencio = esSilencio;
	}

	public double getIdentificador(){
		return(2);
	}

	public double duracion(double tiempoDeNegra){
	   return(2*tiempoDeNegra);
   }
}
