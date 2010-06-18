package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NivelMedio  extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 4.
	 */
	public NivelMedio(){
		this.cantidadTeclas=4;
		this.tablaDeTeclas = new HashMap<Integer,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
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

	public void distribuirTeclas(){


		this.getTablaDeTeclas().put(1, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(2, (this.getLetras().get(0)));//re
		this.getTablaDeTeclas().put(3, (this.getLetras().get(0)));//mi
		this.getTablaDeTeclas().put(4, (this.getLetras().get(1)));//fa
		this.getTablaDeTeclas().put(5, (this.getLetras().get(1)));//sol
		this.getTablaDeTeclas().put(6, (this.getLetras().get(1)));//la
		this.getTablaDeTeclas().put(7, (this.getLetras().get(2)));//si
		this.getTablaDeTeclas().put(8, (this.getLetras().get(2)));//dosostenido
		this.getTablaDeTeclas().put(9, (this.getLetras().get(2)));//resostenido
		this.getTablaDeTeclas().put(10, (this.getLetras().get(3)));//fasostenido
		this.getTablaDeTeclas().put(11, (this.getLetras().get(3)));//solsostenido
		this.getTablaDeTeclas().put(12, (this.getLetras().get(3)));//lasostenido



	}


}
