package Modelo;

public class Nota extends ElementoDePartitura{

	//Atributos:
	private Sonido tipo;

	//Métodos:
	public Nota(Figura laDuracion, Sonido elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
		this.puntajeIdeal = 5;
	}

	public Sonido getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}
}
