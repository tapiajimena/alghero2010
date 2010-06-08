package Modelo;

public class NivelMedio  extends Nivel{


	/* Inicializo el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 5.
	 */
	public NivelMedio(){
		super();
		this.cantidadTeclas = 5;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}


}
