
public class NivelDificil  extends Nivel{

	/* Inicializo el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 6.
	 */
	public NivelDificil(){
		super();
		this.cantidadTeclas = 6;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}


}
