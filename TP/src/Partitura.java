import java.util.ArrayList;

public class Partitura {

	//Atributos:
	private ArrayList<Compas> compases;

	//M�todos:
	public Partitura(){
		this.compases= new ArrayList<Compas>();
	}

	public void addCompas(Compas unCompas){
		this.compases.add(unCompas);
	}

	public Compas getCompas(int index){
		//Aca no habr�a que tirar alguna excepcion? Que onda?
		return(compases.get(index));
	}






}
