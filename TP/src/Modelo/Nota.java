package Modelo;

public class Nota extends ElementoDePartitura{

	//Atributos:
	private Sonido tipo;

	//M�todos:
	public Nota(Figura laDuracion, Sonido elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
	}

	public Sonido getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}
}