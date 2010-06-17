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
		Map<Double,Letra> tablaDeTeclas = new HashMap<Double,Letra>();
		this.letras = new ArrayList(6);
		this.canciones = new ArrayList();
		this.porcentajeMinimo =	0.95;
		this.factorAumentoDificultad = 3;
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



		this.getTablaDeTeclas().put(261.626, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(293.665, (this.getLetras().get(0)));//re
		this.getTablaDeTeclas().put(329.628, (this.getLetras().get(1)));//mi
		this.getTablaDeTeclas().put(349.228, (this.getLetras().get(1)));//fa
		this.getTablaDeTeclas().put(391.995, (this.getLetras().get(2)));//sol
		this.getTablaDeTeclas().put(440.0, (this.getLetras().get(2)));//la
		this.getTablaDeTeclas().put(493.883, (this.getLetras().get(3)));//si
		this.getTablaDeTeclas().put(277.183, (this.getLetras().get(3)));//dosostenido
		this.getTablaDeTeclas().put(311.127, (this.getLetras().get(4)));//resostenido
		this.getTablaDeTeclas().put(369.994, (this.getLetras().get(4)));//fasostenido
		this.getTablaDeTeclas().put(415.305, (this.getLetras().get(5)));//solsostenido
		this.getTablaDeTeclas().put(466.164, (this.getLetras().get(5)));//lasostenido



	}


}
