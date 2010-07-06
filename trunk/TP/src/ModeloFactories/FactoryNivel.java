package ModeloFactories;

import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.NivelFacil;
import Modelo.NivelMedio;

public class FactoryNivel {

	private Nivel nivel;

	public static Nivel crearNivel(int id){

		switch (id) {

	/* Este caso corresponde al nivel Fácil. */
	case 1:

		Nivel nivel = new NivelFacil();
		nivel.setNombre("Nivel:Facil");

		break;

	/* Este caso corresponde al nivel Medio. */
	case 2:
		Nivel nivel = new NivelMedio();
		nivel.setNombre("Nivel:Medio");

		break;

	/* Este caso corresponde al nivel Difícil. */
	case 3:

		Nivel nivel = new NivelDificil();
		nivel.setNombre("Nivel:Dificil");
		break;

	default:
		Nivel nivel = new Nivel();
		nivel.setNombre("Nivel");
		break;
	}
	return nivel;
}

}
