 package Modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Modelo.Letra;
import Modelo.Nivel;

public class Juego {

	//Atributos:

	private ArrayList<Nivel> niveles;
	private ArrayList<Letra> letras;
	private TablaDeMapeo tabla;

	//Métodos:

	public Juego(ArrayList<Nivel> losNiveles){
		this.niveles = losNiveles;
	}

	/* Método por el cual se ingresan las 6 letras a utilizar durante todo
	 * el juego.
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

	/* Se definen las letras a utilizar en el nivel. */
    public void definirLetras(){
            char letraIngresada;
            for (int i=0 ; i<6 ; i++){
            	letraIngresada = this.ingresarLetras();
            	this.letras.add(new Letra(letraIngresada));
            }
    }


	/* Método por el cual asigno las letras a utilizar en cada uno de los
	 * niveles. Para el nivel fácil se usarán 3, para el nivel medio se usarán 5
	 * y para el nivel difícil se usarán 6.
	 */
    public void asignarLetrasNivel(){
        for (int j = 0; j < this.niveles.size(); j++){

        	int Imax = this.niveles.get(j).letras.size();

        	for (int i=0; i < Imax; i++){
           		Letra letraAgregada = this.letras.get(i);
                this.niveles.get(j).letras.add(i, letraAgregada);
           	}
        }
    }


	/*
	 * Indica si se gano el juego dependiendo de haber superado o no todos los niveles.
	 */
	public boolean ganoJuego(){
		boolean superado = false;
		for (int i=0; i< niveles.size(); i++){
			if (this.niveles.get(i).esSuficiente()){
				superado = true;
			}
		}
		return superado;
	}

	/* Método que lleva a cabo el conteo de puntos */
	public void calcularPuntaje(){
		//
	}




}
