package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NivelDificil extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 6.
	 */
	public NivelDificil(){
		this.cantidadTeclas=6;
		this.tablaDeTeclas = new HashMap<Integer,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
		this.porcentajeMinimo =	0.95;
		this.factorAumentoDificultad = 3;
		this.nombre = "Difícil";
	}

	@Override
	public double getPorcentajeMinimo() {
		return 0.95;
	}

	@Override
	public void modificarVelocidad() {
		for (int i = 0; i < this.canciones.size(); i++){
			double tiempo = (this.canciones.get(i).getTiempoDeNegra() * 0.4);
			this.canciones.get(i).setTiempoDeNegra(tiempo);
		}
	}

	public void distribuirTeclas(){



		this.getTablaDeTeclas().put(1, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(2, (this.getLetras().get(0)));//re
		this.getTablaDeTeclas().put(3, (this.getLetras().get(1)));//mi
		this.getTablaDeTeclas().put(4, (this.getLetras().get(1)));//fa
		this.getTablaDeTeclas().put(5, (this.getLetras().get(2)));//sol
		this.getTablaDeTeclas().put(6, (this.getLetras().get(2)));//la
		this.getTablaDeTeclas().put(7, (this.getLetras().get(3)));//si
		this.getTablaDeTeclas().put(8, (this.getLetras().get(3)));//dosostenido
		this.getTablaDeTeclas().put(9, (this.getLetras().get(4)));//resostenido
		this.getTablaDeTeclas().put(10, (this.getLetras().get(4)));//fasostenido
		this.getTablaDeTeclas().put(11, (this.getLetras().get(5)));//solsostenido
		this.getTablaDeTeclas().put(12, (this.getLetras().get(5)));//lasostenido



	}


}
