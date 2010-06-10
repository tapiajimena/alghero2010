package Modelo;
import java.util.ArrayList;
import java.io.*;

public abstract class Nivel {

	//Atributos:

	protected ArrayList<Letra> letras;
	protected int cantidadTeclas;
	protected ArrayList<Cancion> canciones;


	//Métodos:

	/* Se definen las letras a utilizar en el nivel */
	public void definirLetras(int cantidadTeclasNivel, char letraIngresada){
		for (int i=0;i<=cantidadTeclasNivel;i++){
			this.letras.add(new Letra(letraIngresada));
		}

	}

	/* Devuelve las letras que se utilizaran en cada nivel dependiendo de la cantidad
	 * de teclas disponibles según la dificultad del mismo.
	 */
	public ArrayList<Letra> obtenerLetras(int cantidadTeclasNivel){
		ArrayList<Letra> letrasDisponibles = new ArrayList<Letra>(cantidadTeclasNivel);
		for (int i=0;i<=cantidadTeclasNivel;i++){
			letrasDisponibles.add(this.letras.get(i));
		}
		return letrasDisponibles;
	}

	public void cargarCancion(Cancion unaCancion){
		this.canciones.add(unaCancion);
	}

	public Cancion elegirCancion(int index){
		return this.canciones.get(index);
	}

	public abstract double modificarTiempoDeNegra();


}
