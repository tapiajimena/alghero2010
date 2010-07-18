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

		unaCancion = modificarVelocidad(unaCancion);
		this.canciones.add(unaCancion);
		TablaDeMapeo unaTablaDeMapeo = new TablaDeMapeo(unaCancion);
		unaTablaDeMapeo.armarTabla();
		tablasDeMapeo.add(unaTablaDeMapeo);
		this.contenedores.add(armarContenedor(unaTablaDeMapeo));

	}



	public double getPorcentajeMinimo() {
		return 0.55;
	}

	private ArrayList<ElementoDeContenedor> armarContenedor(TablaDeMapeo unaTablaDeMapeo){

		ArrayList<ElementoDeContenedor> elContenedor = new ArrayList<ElementoDeContenedor>();

		for(int i=0; i< unaTablaDeMapeo.getArrayDeSegundos().size();i++){

			double segundoActual=unaTablaDeMapeo.getArrayDeSegundos().get(i);

			ElementoDePartitura elementoActual=unaTablaDeMapeo.getTabla().get((segundoActual));

			if(!elementoActual.getFigura().esSilencio()){

				if (elementoActual instanceof Nota){
					int identificadorActual=((Nota)elementoActual).getSonido().getIdentificador();
					ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
					elContenedor.add(struct);
				}

				if (elementoActual instanceof Acorde){

					ArrayList<Sonido> sonidosActuales = ((Acorde)elementoActual).getSonidos();
					for(int j=0;j<sonidosActuales.size();j++){
						Sonido elSonidoActual = sonidosActuales.get(j);
						int identificadorActual= elSonidoActual.getIdentificador();
						ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
						elContenedor.add(struct);

					}
				}
			}
		}

		return elContenedor;

	}

	private int asignarColumna(int tipoDeSonido){

		Letra letra=tablaDeTeclas.get(tipoDeSonido);

		int columna=this.letras.indexOf(letra);

		return (columna);

	}


	public Cancion modificarVelocidad(Cancion unaCancion) {

		double tiempo = unaCancion.getTiempoDeNegra() * 1;
		unaCancion.setTiempoDeNegra(tiempo);
		return unaCancion;

	}



	public void distribuirTeclas(){



		this.getTablaDeTeclas().put(1, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(2, (this.getLetras().get(0)));//re
		this.getTablaDeTeclas().put(3, (this.getLetras().get(0)));//mi
		this.getTablaDeTeclas().put(4, (this.getLetras().get(0)));//fa
		this.getTablaDeTeclas().put(5, (this.getLetras().get(1)));//sol
		this.getTablaDeTeclas().put(6, (this.getLetras().get(1)));//la
		this.getTablaDeTeclas().put(7, (this.getLetras().get(1)));//si
		this.getTablaDeTeclas().put(8, (this.getLetras().get(1)));//dosostenido
		this.getTablaDeTeclas().put(9, (this.getLetras().get(2)));//resostenido
		this.getTablaDeTeclas().put(10, (this.getLetras().get(2)));//fasostenido
		this.getTablaDeTeclas().put(11, (this.getLetras().get(2)));//solsostenido
		this.getTablaDeTeclas().put(12, (this.getLetras().get(2)));//lasostenido



	}

}
