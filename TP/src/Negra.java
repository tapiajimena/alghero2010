
public class Negra extends Figura{

	//supongo que el hecho de ser silencio viene dado como parametro.
	//claudio verifica que el identificador sea el correcto para esa figura
	public Negra(boolean esSilencio){
		this.silencio = esSilencio;
		this.identificador=3;

	}
   public double duracion(double tiempoDeNegra){
	   return(tiempoDeNegra);
   }
}
