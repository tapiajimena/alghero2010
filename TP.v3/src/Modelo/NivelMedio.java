package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NivelMedio  extends Nivel{

	//M�todos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 4.
	 */
	public NivelMedio(){
		this.cantidadTeclas=4;
		this.tablaDeTeclas = new HashMap<Integer,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
		this.tablasDeMapeo = new ArrayList<TablaDeMapeo>();
		this.contenedores = new ArrayList<ArrayList<ElementoDeContenedor>>();
		this.porcentajeMinimo = 0.75;
		this.factorAumentoDificultad = 2;
		this.nombre = "Medio";
   	}

	public void cargarCancion(Cancion unaCancion){

		// Al momento de cargar una canci�n, cargamos su tabla de mapeo
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
		return 0.75;
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

		double tiempo = unaCancion.getTiempoDeNegra() * 0.75;
		unaCancion.setTiempoDeNegra(tiempo);
		return unaCancion;

	}

	public void distribuirTeclas(){


		this.getTablaDeTeclas().put(60, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(61, (this.getLetras().get(2)));//re
		this.getTablaDeTeclas().put(62, (this.getLetras().get(0)));//mi
		this.getTablaDeTeclas().put(63, (this.getLetras().get(1)));//fa
		this.getTablaDeTeclas().put(64, (this.getLetras().get(3)));//sol
		this.getTablaDeTeclas().put(65, (this.getLetras().get(1)));//la
		this.getTablaDeTeclas().put(66, (this.getLetras().get(3)));//si
		this.getTablaDeTeclas().put(67, (this.getLetras().get(1)));//dosostenido
		this.getTablaDeTeclas().put(68, (this.getLetras().get(3)));//resostenido
		this.getTablaDeTeclas().put(69, (this.getLetras().get(2)));//fasostenido
		this.getTablaDeTeclas().put(70, (this.getLetras().get(0)));//solsostenido
		this.getTablaDeTeclas().put(71, (this.getLetras().get(2)));//lasostenido



	}


}
