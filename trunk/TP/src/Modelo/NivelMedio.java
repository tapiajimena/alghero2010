package Modelo;

import java.util.ArrayList;

public class NivelMedio  extends Nivel{

	//M�todos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 5.
	 */
	public NivelMedio(){
		this.letras = new ArrayList(cantidadTeclas);
		this.canciones = new ArrayList();
		this.cantidadTeclas = 5;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}


}
