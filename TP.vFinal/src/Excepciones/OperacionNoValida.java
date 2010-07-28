package Excepciones;

public class OperacionNoValida extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public OperacionNoValida(String mensaje){
		super(mensaje);
	}
}
