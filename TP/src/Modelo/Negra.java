package Modelo;

public class Negra extends Figura{

	//M�todos:

	public Negra(boolean esSilencio){
		this.silencio = esSilencio;


	}

	public double getIdentificador(){
		return(1);
	}


   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra);
   }
}
