package Modelo;

public class Nota extends ElementoDePartitura{

	//Atributos:
	private Sonido tipo;

	//M�todos:
	public Nota(Figura laDuracion, Sonido elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
		/* Se establece que el puntaje ideal ser� de 5 por cada nota */
		this.puntajeIdeal = 5;
	}

	public Sonido getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}
}
