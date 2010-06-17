package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NivelFacil extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 3.
	 */
	public NivelFacil(){
		this.cantidadTeclas=3;
		Map<Double,Letra> tablaDeTeclas = new HashMap<Double,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
		this.porcentajeMinimo = 0.55;
		this.factorAumentoDificultad = 1;
	}





	@Override
	public double getPorcentajeMinimo() {
		return 0.55;
	}

	@Override
	public void modificarVelocidad() {
		for (int i = 0; i < this.canciones.size(); i++){
			double tiempo = (this.canciones.get(i).getTiempoDeNegra() * 1);
			this.canciones.get(i).setTiempoDeNegra(tiempo);
		}
	}

	public void distribuirTeclas(){



		this.getTablaDeTeclas().put(261.626, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(293.665, (this.getLetras().get(0)));//re
		this.getTablaDeTeclas().put(329.628, (this.getLetras().get(0)));//mi
		this.getTablaDeTeclas().put(349.228, (this.getLetras().get(0)));//fa
		this.getTablaDeTeclas().put(391.995, (this.getLetras().get(1)));//sol
		this.getTablaDeTeclas().put(440.0, (this.getLetras().get(1)));//la
		this.getTablaDeTeclas().put(493.883, (this.getLetras().get(1)));//si
		this.getTablaDeTeclas().put(277.183, (this.getLetras().get(1)));//dosostenido
		this.getTablaDeTeclas().put(311.127, (this.getLetras().get(2)));//resostenido
		this.getTablaDeTeclas().put(369.994, (this.getLetras().get(2)));//fasostenido
		this.getTablaDeTeclas().put(415.305, (this.getLetras().get(2)));//solsostenido
		this.getTablaDeTeclas().put(466.164, (this.getLetras().get(2)));//lasostenido



	}

}
