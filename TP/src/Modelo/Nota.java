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

	public Sonido getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}
}
