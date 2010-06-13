package Modelo;

public class Nota extends ElementoDePartitura{

	//Atributos:
	private Sonido tipo;

	//Métodos:
	public Nota(Figura laDuracion, Sonido elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
		/* Se establece que el puntaje ideal será de 5 por cada nota */
		this.puntajeIdeal = 5;
	}


	/* Si la figura de la nota no es un silencio entonces la cantidad
	 * de sonidos es 1
	 */

	public int obtenerCantidadDeSonidos(){
		int cantidad=0;


		if(!this.duracion.esSilencio()){
			cantidad=1;
		}
		return cantidad;


	}
	/* Devuelve la cantidad de elementos sin importar si su figura asociada es
	 * un silencio o no
	 */

	public int obtenerCantidadDeElementos(){
		return 1;

	}

	public Sonido getSonido(){
		return (tipo);
	}


}
