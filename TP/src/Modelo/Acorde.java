package Modelo;
import java.util.ArrayList;

public class Acorde extends ElementoDePartitura {

	//Atributos:
	private ArrayList<Sonido> tipo;

	//M�todos:
	public Acorde(Figura laDuracion, ArrayList<Sonido> elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
		this.puntajeIdeal = (this.tipo.size()*5);
	}

	public ArrayList<Sonido> getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}

}



