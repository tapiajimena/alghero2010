package Modelo;

import java.util.ArrayList;

public class NivelMedio  extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 5.
	 */
	public NivelMedio(){
		this.letras = new ArrayList(cantidadTeclas);
		this.canciones = new ArrayList();
		this.cantidadTeclas = 5;
		this.porcentajeMinimo = 0.75;
		this.factorAumentoDificultad = 2;
	}

	@Override
	public double getPorcentajeMinimo() {
		return 0.75;
	}


}
