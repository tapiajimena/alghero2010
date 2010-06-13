package Modelo;
public class Cancion {

	//Atributos:
	private Partitura partitura;
	private String nombre;
	private String artista;
	private double tiempoDeNegra;
	private double puntajeIdeal;

	//Métodos:

	/* Obtencion de datos desde el  xml, por el momento se usa como un costructor comun */
	public Cancion(Partitura unaPartitura, String unNombre, String unArtista, double unTiempoDeNegra){
		this.partitura = unaPartitura;
		this.tiempoDeNegra = unTiempoDeNegra;
		this.nombre = unNombre;
		this.artista = unArtista;
		this.puntajeIdeal = (this.obtenerCantidadDeNotas()*5);
	}

	public Partitura getPartitura(){
		return(this.partitura);
	}

	public String getNombre(){
		return(this.nombre);
	}

	public String getArtista(){
		return(this.artista);
	}

	public double getTiempoDeNegra(){
		return (this.tiempoDeNegra);
	}

	public double getPuntajeIdeal(){
		return this.puntajeIdeal;
	}

	public void setTiempoDeNegra(double tiempo){
		this.tiempoDeNegra = tiempo;
	}

	public int obtenerCantidadDeNotas(){
		int cantidadTotal=0;
		int cantidadDeCompases=this.getPartitura().getCompases().size();

		for (int i = 0; i < cantidadDeCompases ; i++){

			Compas compasActual=this.getPartitura().getCompases().get(i);

			for (int j = 0; j < compasActual.getElementosDePartitura().size(); j++){
				ElementoDePartitura elementoActual=compasActual.getElementosDePartitura().get(j);
				cantidadTotal= cantidadTotal + elementoActual.obtenerCantidadDeSonidos();

			}


		}
		return cantidadTotal;

	}
}




