
public class Corchea extends Figura{


	//M�todos:
	public Corchea(boolean esSilencio){
		this.silencio = esSilencio;


	}

	public double getIdentificador(){
		return(0.5);
	}


   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra/2);
   }
}
