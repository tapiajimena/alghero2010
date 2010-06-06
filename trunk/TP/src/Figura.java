
public abstract class Figura {

	protected boolean silencio;
	protected int identificador;

	public abstract double duracion(double tiempoDeNegra);

	public boolean esSilencio(){
		return(silencio);
	}
	public int getIdentificador(){
		return(identificador);
	}


}