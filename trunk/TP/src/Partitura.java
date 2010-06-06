import java.util.ArrayList;

public class Partitura {

	private ArrayList<Compas> compases;

	public Partitura(){
		this.compases= new ArrayList<Compas>();
	}




	//queda la armadura aca o en compas???
	private ArrayList<ArmaduraDeClave> duracionDeCompas;


	//los metodos para agregar notas, devolver notas y demas cosas del arraylist nose
	// si es necesario ponerlos porque no se usarian directamente los metodos
//		que ya vienen?

	public void agregarCompas(Compas unCompas){

		int index = this.compases.size();
		this.compases.add(index, unCompas);

	}



}
