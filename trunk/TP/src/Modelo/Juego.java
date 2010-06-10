 package Modelo;
import java.util.ArrayList;

public class Juego {

	//Atributos:

	private ArrayList<Nivel> niveles;

	//Métodos:

	/*
	 * Indica si se gano el juego dependiendo de haber superado o no todos los niveles.
	 */
	public boolean ganoJuego(){
		boolean superado = false;
		for (int i=0; i<= niveles.size(); i++){
			if (this.niveles.get(i).esSuficiente()){
				superado = true;
			}
		}
		return superado;
	}




}
