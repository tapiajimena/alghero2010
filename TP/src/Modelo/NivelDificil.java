package Modelo;

import java.util.ArrayList;

public class NivelDificil  extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 6.
	 */
	public NivelDificil(){
		this.letras = new ArrayList(cantidadTeclas);
		this.canciones = new ArrayList();
		this.cantidadTeclas = 6;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}


}
