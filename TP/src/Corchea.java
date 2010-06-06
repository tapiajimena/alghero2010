
public class Corchea extends Figura{
	//claudio verifica que el identificador sea el correcto para esa figura
	public Corchea(boolean esSilencio){
		this.silencio = esSilencio;
		this.identificador=2;

	}
   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra/2);
   }
}
