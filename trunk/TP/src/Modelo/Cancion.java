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
		this.puntajeIdeal = (this.contarNotas()*5);
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

	public int contarNotas(){
		int puntos = 0;
		for (int i = 0; i <= this.getPartitura().getCompases().size(); i++){
			for (int j = 0; j <= this.getPartitura().getCompases().get(j).getElementoDePartitura().size(); j++){
				int k = 0;
				puntos += this.getPartitura().getCompases().get(j).getElementoDePartitura().get(k).getFigura();


			}

		}
	}

}
