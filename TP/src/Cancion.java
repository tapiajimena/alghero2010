public class Cancion {

	//Atributos:
	private Partitura partitura;
	private String nombre;
	private String artista;
	private double tiempoDeNegra;

	//M�todos:

	//Supuestamente se sacan los datos desde el  xml, por el momento se usa como un costructor comun
	public Cancion(Partitura unaPartitura, String unNombre, String unArtista, double unTiempoDeNegra){
		this.partitura=unaPartitura;
		this.tiempoDeNegra=unTiempoDeNegra;
		this.nombre=unNombre;
		this.artista=unArtista;
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





	//estos metodos ya no irian

	//public double calcularCantidadNegras(){


	//}


	//public double calcularTiempoDeNegra(){



	//}

}
