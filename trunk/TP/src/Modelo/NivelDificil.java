package Modelo;

import java.util.ArrayList;

public class NivelDificil extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 6.
	 */
	public NivelDificil(){
		this.letras = new ArrayList(cantidadTeclas);
		this.canciones = new ArrayList();
		this.cantidadTeclas = 6;
		this.porcentajeMinimo =	0.95;
		this.factorAumentoDificultad = 3;
	}

	@Override
	public double getPorcentajeMinimo() {
		return 0.95;
	}


}
