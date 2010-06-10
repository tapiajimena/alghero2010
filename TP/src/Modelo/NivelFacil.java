package Modelo;

import java.util.ArrayList;

public class NivelFacil extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 3.
	 */
	public NivelFacil(){
		this.letras = new ArrayList(cantidadTeclas);
		this.canciones = new ArrayList();
		this.cantidadTeclas = 3;
		this.porcentajeMinimo = 0.55;
	}

	@Override
	public double modificarTiempoDeNegra() {
		return 0;
	}

	@Override
	public double getPorcentajeMinimo() {
		return 0.55;
	}

}
