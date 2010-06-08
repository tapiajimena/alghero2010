package Modelo;
import java.util.ArrayList;
import java.io.*;

public abstract class Nivel {

	protected ArrayList<Letra> letras;
	protected int cantidadTeclas;
	protected ArrayList<Cancion> canciones;

	public Nivel(){
		this.letras = new ArrayList(6);
		this.canciones = new ArrayList();
	}

	/* Método que se encarga de leer el imput desde teclado y transformarlo en un
	 * char.
	 */
	public char ingresarLetras(){
		char letraIngresada;

		InputStreamReader reader = new InputStreamReader (System.in);
		BufferedReader f = new BufferedReader (reader);
		try {
			letraIngresada = f.readLine().charAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		letraIngresada = 'Y';
		return letraIngresada;

	}

	/* Se pide al usuario que ingrese las 6 letras con las que va a jugar */
	public void definirLetras(){
		char letraIngresada;
		for (int i=0;i<=6;i++){
			letraIngresada = this.ingresarLetras();
			this.letras.add(new Letra(letraIngresada));
		}

	}

	/* Devuelve las letras que se utilizaran en cada nivel dependiendo de la cantidad
	 * de teclas disponibles según la dificultad del mismo.
	 */
	public ArrayList<Letra> obtenerLetras(int cantidadesTeclasNivel){
		ArrayList<Letra> letrasDisponibles = new ArrayList<Letra>(cantidadesTeclasNivel);
		for (int i=0;i<=cantidadesTeclasNivel;i++){
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
