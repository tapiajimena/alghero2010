
public class Blanca extends Figura{

	//claudio verifica que el identificador sea el correcto para esa figura
	public Blanca(boolean esSilencio){
		this.silencio = esSilencio;
		this.identificador=1;

	}
   public double duracion(double tiempoDeNegra){
	   return(2*tiempoDeNegra);
   }
}
