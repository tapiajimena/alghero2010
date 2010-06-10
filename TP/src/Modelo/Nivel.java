package Modelo;
import java.util.ArrayList;
import java.io.*;

public abstract class Nivel {

	//Atributos:

	protected ArrayList<Letra> letras;
	protected int cantidadTeclas;
	protected ArrayList<Cancion> canciones;

	/* Lleva la cuenta del puntaje acumulado */
	protected double puntajeActual;

	/* Puntaje minimo a ser alcanzado para superar el nivel */
	protected double puntajeMinimo;

	/* Porcentage minimo a ser alcanzado para superar el nivel */
	protected double porcentajeMinimo;

	/* Puntaje ideal del nivel. */
	protected double puntajeIdeal;

	/* Llevan el conteo de lo que sucede con la apreciacion de las notas */
	protected double contadorDeErrores;
	protected double contadorDeAciertos;
	protected double contadorDePerfectos;

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

	public abstract double getPorcentajeMinimo();

	public double getPuntajeActual(){
		return this.puntajeActual;
	}

	/*
	 * Se establece el puntaje ideal del nivel, que se remite a la suma de puntajes ideales de cada
	 * canción que compone al nivel.
	 */
	public void setPuntajeIdeal(){
		int j = this.canciones.size();
		for (int i=0; i<=j; i++){
			this.puntajeIdeal += this.elegirCancion(i).getPuntajeIdeal();
		}
	}

	/*
	 * Se establece el puntaje minimo del nivel, que se remite a la suma de puntajes minimos de cada
	 * canción que compone al nivel.
	 */
	public void setPuntajeMinimo(){
		int j = this.canciones.size();
		double valor = 0;
		for (int i=0; i<=j; i++){
			valor = valor + this.elegirCancion(i).getPuntajeIdeal()* this.getPorcentajeMinimo();
		}
		this.puntajeMinimo = valor;
	}

	/* Se usa para preguntar si se ha superado el nivel */
	public boolean esSuficiente(){
		if (this.puntajeActual >= this.puntajeMinimo) return true;
		else return false;
	}


}
