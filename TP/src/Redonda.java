
public class Redonda extends Figura{

	//claudio verifica que el identificador sea el correcto para esa figura
	public Redonda(boolean esSilencio){
		this.silencio = esSilencio;
		this.identificador=4;

	}
   public double duracion(double tiempoDeNegra){
	   return(4*tiempoDeNegra);
   }

}
