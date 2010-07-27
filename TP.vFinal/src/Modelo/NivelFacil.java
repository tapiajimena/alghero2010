package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class NivelFacil extends Nivel{

	//Métodos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 3.
	 */

	public NivelFacil(){
		this.cantidadTeclas=3;
		this.tablaDeTeclas = new HashMap<Integer,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
		this.tablasDeMapeo = new ArrayList<TablaDeMapeo>();
		this.contenedores = new ArrayList<ArrayList<ElementoDeContenedor>>();
		this.porcentajeMinimo = 0.55;
		this.factorAumentoDificultad = 1;
		this.nombre = "Fácil";

	}


	public void cargarCancion(Cancion unaCancion){

		// Al momento de cargar una canción, cargamos su tabla de mapeo
		// correspondiente, que tiene los tiempos adecuados al nivel en
		// que estamos y el contenedor apropiado..

		Cancion cancionAux = new Cancion(unaCancion);
		cancionAux = modificarVelocidad(cancionAux);
		this.canciones.add(cancionAux);
		TablaDeMapeo unaTablaDeMapeo = new TablaDeMapeo(cancionAux);
		unaTablaDeMapeo.armarTabla();
		this.tablasDeMapeo.add(unaTablaDeMapeo);
		this.contenedores.add(armarContenedor(unaTablaDeMapeo));

	}

	/*
	 * Devuelve el porcentaje minimo de aciertos que requiere el nivel
	 *
	 */

	public double getPorcentajeMinimo() {
		return 0.55;
	}

public int asignarColumna(int tipoDeSonido){

		Letra letra=tablaDeTeclas.get(tipoDeSonido);

		int columna=this.letras.indexOf(letra);

		return (columna);

	}

/*
 * Modifica la velocidad de la cancion
 */
	private Cancion modificarVelocidad(Cancion unaCancion) {

		double tiempo = unaCancion.getTiempoDeNegra() * 1;
		unaCancion.setTiempoDeNegra(tiempo);
		return unaCancion;

	}



	public void distribuirTeclas(){



		this.getTablaDeTeclas().put(60, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(61, (this.getLetras().get(2)));//re
		this.getTablaDeTeclas().put(62, (this.getLetras().get(1)));//mi
		this.getTablaDeTeclas().put(63, (this.getLetras().get(2)));//fa
		this.getTablaDeTeclas().put(64, (this.getLetras().get(1)));//sol
		this.getTablaDeTeclas().put(65, (this.getLetras().get(0)));//la
		this.getTablaDeTeclas().put(66, (this.getLetras().get(2)));//si
		this.getTablaDeTeclas().put(67, (this.getLetras().get(1)));//dosostenido
		this.getTablaDeTeclas().put(68, (this.getLetras().get(0)));//resostenido
		this.getTablaDeTeclas().put(69, (this.getLetras().get(0)));//fasostenido
		this.getTablaDeTeclas().put(70, (this.getLetras().get(2)));//solsostenido
		this.getTablaDeTeclas().put(71, (this.getLetras().get(1)));//lasostenido



	}

}

