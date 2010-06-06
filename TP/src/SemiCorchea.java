
public class SemiCorchea extends Figura{

	//claudio verifica que el identificador sea el correcto para esa figura
	public SemiCorchea(boolean esSilencio){
		this.silencio = esSilencio;
		this.identificador=5;

	}
   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra/4);
   }

}
