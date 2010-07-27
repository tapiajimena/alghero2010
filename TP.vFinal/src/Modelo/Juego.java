package Modelo;

import java.util.ArrayList;
import java.util.Date;

import Audio.Reproductor;
import Modelo.Letra;
import Modelo.Nivel;
//
public class Juego {

    //Atributos:

    private ArrayList<Nivel> niveles;
    private ArrayList<Letra> letras;//LAS LETRAS QUE INGRESA EL USUARIO
    private Date fechaDeComienzo;
    private int indiceDeCancion;
    private int indiceDeNivel;
    Reproductor referenciaAlReproductor;



    //Métodos:

    public Juego(ArrayList<Nivel> losNiveles){
        this.letras= new ArrayList<Letra>();
        this.niveles = losNiveles;
        this.fechaDeComienzo = new Date();
        this.indiceDeNivel = 0;
		this.indiceDeCancion = 0;
		referenciaAlReproductor = null;

    }


    public ArrayList<Letra> getLetras(){
        return this.letras;
    }

    public void setLetras(ArrayList<Letra> letrasNivel){
    	this.letras = letrasNivel;
    }

    public ArrayList<Nivel> getNiveles(){
        return this.niveles;
    }



    /* Método por el cual asigno las letras a utilizar en cada uno de los
     * niveles. Para el nivel fácil se usarán 3, para el nivel medio se usarán 5
     * y para el nivel difícil se usarán 6.
     */
    public void asignarLetrasNivel(){
        for (int j = 0; j < this.niveles.size(); j++){

            int cantidadDeTeclas=this.niveles.get(j).getCantidadDeTeclas();

            for (int i=0; i < cantidadDeTeclas; i++){
                   Letra letraAgregada = this.letras.get(i);
                this.niveles.get(j).getLetras().add(i,letraAgregada);
               }
        }
    }






	public TablaDeMapeo getTablaDeMapeoIndexada(){

		return this.niveles.get(indiceDeNivel).getTablasDeMapeo().get(indiceDeCancion);

	}

	public ArrayList<ElementoDeContenedor> getContenedorIndexado(){

		return this.niveles.get(indiceDeNivel).getContenedores().get(indiceDeCancion);

	}

	public Cancion getCancionIndexada(){


		return this.niveles.get(indiceDeNivel).elegirCancion(indiceDeCancion);

	}

	public Date getFechaDeComienzo(){

		return this.fechaDeComienzo;

	}

	public int getIndiceDeCancion(){

		return this.indiceDeCancion;

	}

	public int getIndiceNivel(){

		return this.indiceDeNivel;

	}


	public Reproductor getReferenciaAlReproductor(){

		return this.referenciaAlReproductor;

	}

	public void setFechaDeComienzo(Date unaFechaDeComienzo){

		this.fechaDeComienzo = unaFechaDeComienzo;

	}


	public void setIndiceCancion(int unIndiceDeCancion){

		this.indiceDeCancion = unIndiceDeCancion;

	}

	public void setIndiceNivel(int unIndiceDeNivel){

		this.indiceDeNivel = unIndiceDeNivel;

	}

	public void setReferenciaAlReproductor(Reproductor elReproductor){

		this.referenciaAlReproductor = elReproductor;

	}




 // Indica si se gano el juego dependiendo de haber superado o no todos los niveles.

public boolean ganoJuego(){
    boolean superado = false;
    for (int i=0; i< niveles.size(); i++){
        if (this.niveles.get(i).esSuficiente()){
            superado = true;
        }
    }
    return superado;
}
}

