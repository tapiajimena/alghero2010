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

		unaCancion = modificarVelocidad(unaCancion);
		this.canciones.add(unaCancion);
		TablaDeMapeo unaTablaDeMapeo = new TablaDeMapeo(unaCancion);
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

		return (columna+1);

	}


	private Cancion modificarVelocidad(Cancion unaCancion) {

		double tiempo = unaCancion.getTiempoDeNegra() * 0.4;
		unaCancion.setTiempoDeNegra(tiempo);
		return unaCancion;

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