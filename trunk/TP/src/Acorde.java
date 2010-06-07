
import java.util.ArrayList;

public class Acorde extends ElementoDePartitura {

	//Atributos:
	private ArrayList<Sonido> tipo;

	//Métodos:
	public Acorde(Figura laDuracion, ArrayList<Sonido> elTipo){
		this.duracion = laDuracion;
		this.tipo = elTipo;
	}

	public ArrayList<Sonido> getSonido(){
		return (tipo);
	}

	public Figura getFigura(){
		return (duracion);
	}

}



