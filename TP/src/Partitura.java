import java.util.ArrayList;

public class Partitura {

	private ArrayList<Compas> compases;

	//una fraccion que representa cuantas figuras aparecen en el primer compas.
	private ArrayList<ArmaduraDeClave> duracionDeCompas;

	public void agregarCompas(Compas unCompas){

		int index = this.compases.size();
		this.compases.add(index, unCompas);

	}

ie

}
