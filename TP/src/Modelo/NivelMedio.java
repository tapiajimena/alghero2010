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

	@Override
	public void modificarVelocidad() {
		for (int i = 0; i < this.canciones.size(); i++){
			double tiempo = (this.canciones.get(i).getTiempoDeNegra() * 0.6);
			this.canciones.get(i).setTiempoDeNegra(tiempo);
		}
	}


}
