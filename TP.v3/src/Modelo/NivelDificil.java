package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NivelDificil extends Nivel{

	//M�todos:

	/*
	 * Se inicializa el nivel con la cantidad de teclas disponibles para jugar
	 * indicadas, en este caso son 6.
	 */
	public NivelDificil(){
		this.cantidadTeclas=6;
		this.tablaDeTeclas = new HashMap<Integer,Letra>();
		this.letras = new ArrayList<Letra>();
		this.canciones = new ArrayList<Cancion>();
		this.tablasDeMapeo = new ArrayList<TablaDeMapeo>();
		this.contenedores = new ArrayList<ArrayList<ElementoDeContenedor>>();
		this.porcentajeMinimo =	0.95;
		this.factorAumentoDificultad = 3;
		this.nombre = "Dif�cil";
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


	public double getPorcentajeMinimo() {
		return 0.95;
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


	private Cancion modificarVelocidad(Cancion unaCancion) {

		double tiempo = unaCancion.getTiempoDeNegra() * 0.5;
		unaCancion.setTiempoDeNegra(tiempo);
		return unaCancion;

	}

	public void distribuirTeclas(){



		this.getTablaDeTeclas().put(60, (this.getLetras().get(0)));//do
		this.getTablaDeTeclas().put(61, (this.getLetras().get(2)));//re
		this.getTablaDeTeclas().put(62, (this.getLetras().get(4)));//mi
		this.getTablaDeTeclas().put(63, (this.getLetras().get(5)));//fa
		this.getTablaDeTeclas().put(64, (this.getLetras().get(1)));//sol
		this.getTablaDeTeclas().put(65, (this.getLetras().get(3)));//la
		this.getTablaDeTeclas().put(66, (this.getLetras().get(5)));//si
		this.getTablaDeTeclas().put(67, (this.getLetras().get(1)));//dosostenido
		this.getTablaDeTeclas().put(68, (this.getLetras().get(3)));//resostenido
		this.getTablaDeTeclas().put(69, (this.getLetras().get(0)));//fasostenido
		this.getTablaDeTeclas().put(70, (this.getLetras().get(2)));//solsostenido
		this.getTablaDeTeclas().put(71, (this.getLetras().get(4)));//lasostenido



	}


}
