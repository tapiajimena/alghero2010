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
		/*ElementoDePartitura aux;
		int puntos = 0;
		for (int i = 0; i <= this.getPartitura().getCompases().size(); i++){
			for (int j = 0; j <= this.getPartitura().getCompases().get(i).getElementosDePartitura().size(); j++){

				aux=this.getPartitura().getCompases().get(i).getElementosDePartitura().get(j);
				if ((aux instanceof Nota)&&(!(aux.getFigura().esSilencio()))) {
					puntos = puntos + 1;
				}
				if (aux instanceof Acorde){
					for (int k = 0; k <= (aux.getNotas().size()); i++){


						if (aux.getFigura().esSilencio()) {
							puntos = puntos + 1;
				}


			}
				}

		}*/
		return 0;
	}
}



