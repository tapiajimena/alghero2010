
public class Cancion {

	private Partitura laPartitura;
	private double tiempoDeCompas;
	private String nombre;
	private String artista;


	 // supuestamente se sacan los datos desde el  xml, por el momento se usa como un costructor comun

	public Cancion(Partitura unaPartitura, double unTiempoDeCompas, String unNombre, String unArtista ){
		this.laPartitura=unaPartitura;
		this.tiempoDeCompas=unTiempoDeCompas;
		this.nombre=unNombre;
		this.artista=unArtista;


	}

	//leer las notas que vienen y pasarlo a negras.

	public double calcularCantidadNegras(){


	}

	// divido el tiempo de compas en la cantidad de notas que tengo.

	public double calcularTiempoDeNegra(){



	}

}
