
public class NivelFacil extends Nivel{

	/* Inicializo el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 3.
	 */
	public NivelFacil(){
		super();
		this.cantidadTeclas = 3;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}

}
