package Modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.Timer;

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
    boolean hacerSonarPelota;
    int indiceDePelotaASonar;




    //Métodos:

    public Juego(ArrayList<Nivel> losNiveles){
        this.letras= new ArrayList<Letra>();
        this.niveles = losNiveles;
        this.fechaDeComienzo = new Date();
        this.indiceDeNivel = 0;
		this.indiceDeCancion = 0;
		hacerSonarPelota = false;
		indiceDePelotaASonar = 0;

    }


    public ArrayList<Letra> getLetras(){
        return this.letras;
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

	public boolean getHacerSonarPelota(){

		return this.hacerSonarPelota;

	}

	public int getIndiceDePelotaASonar(){

		return this.indiceDePelotaASonar;

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

	public void setHacerSonarPelota(boolean unHacerSonarPelota){

		this.hacerSonarPelota = unHacerSonarPelota;

	}

	public void setIndiceDePelotaASonar(int unIndiceDePelotaASonar){

		this.indiceDePelotaASonar = unIndiceDePelotaASonar;

	}

}

    /* Método por el cual se ingresan las 6 letras a utilizar durante todo
	 * el juego.

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





     Se definen las letras que quiere usar el usuario
    public void definirLetras(){
            char letraIngresada;
            int maximaCantidadLetras = 6;
            for (int i=0 ; i<maximaCantidadLetras ; i++){
                letraIngresada = this.ingresarLetras();
                this.letras.add(new Letra(letraIngresada));
            }
    }*/


/*
*
public void Jugar(int indiceDeNivel,int indiceDeCancion){

	/*La primer tabla es de la forma: Segundo-ElementoDePartitura
	 * La segunda tabla es de la forma: Sonido-Tecla
	 * Entonces se fija que sonido tiene el elemento que se toco en
	 * ese segundo y se fija si  la tecla asociada coincide con la
	 * tecla asoc a ese sonido



   Cancion cancionActual = this.niveles.get(indiceDeNivel).elegirCancion(indiceDeCancion);
   TablaDeMapeo unaTabla= new TablaDeMapeo(cancionActual) ;
   unaTabla.armarTabla();
   Map<Double, ElementoDePartitura> primerTabla = unaTabla.getTabla();

   this.getNiveles().get(indiceDeNivel).distribuirTeclas();
   Map<Integer, Letra> segundaTabla = this.getNiveles().get(indiceDeNivel).getTablaDeTeclas();

   long time=System.currentTimeMillis();
   Date fechaDeComienzo=new Date(time);
   Boolean fin=false;
   Boolean sePresionaTecla=false; //CAMBIARLO TENIENDO ENCUENTA CONTROLADOR
   Letra teclaIngresada=new Letra('a');//CAMBIARLO TENIENDO ENCUENTA CONTROLADOR


 //Se habilita el teclado

   while (!fin) {

   if (sePresionaTecla){

   	long timeNuevo=System.currentTimeMillis();
       Date fechaActual=new Date(timeNuevo);
       long segundosQuePasaron = ((fechaActual.getTime()-fechaDeComienzo.getTime())/1000);

       if  ( primerTabla.containsKey(segundosQuePasaron)){

       	  ElementoDePartitura elementoActual=primerTabla.get(segundosQuePasaron);
             if (!elementoActual.getFigura().esSilencio()){

           	  if (elementoActual instanceof Nota){
           		  Sonido sonidoActual=((Nota)elementoActual).getSonido();
           		  if (segundaTabla.get(sonidoActual)==teclaIngresada){
           			  this.getNiveles().get(indiceDeNivel).contadorDeAciertos++;
           			  this.getNiveles().get(indiceDeNivel).puntajeActual=+primerTabla.get(segundosQuePasaron).puntajeIdeal;
           			  }else{this.getNiveles().get(indiceDeNivel).contadorDeErrores++;
                 }

           		  if (elementoActual instanceof Acorde){
               		  ArrayList<Sonido> sonidosActuales = ((Acorde)elementoActual).getSonidos();
               		  for(int i=0;i<sonidosActuales.size();i++){
               			 Sonido elSonidoActual = sonidosActuales.get(i);

               		  if (segundaTabla.get(elSonidoActual)==teclaIngresada){
               			  this.getNiveles().get(indiceDeNivel).contadorDeAciertos++;
               			  this.getNiveles().get(indiceDeNivel).puntajeActual=+primerTabla.get(segundosQuePasaron).puntajeIdeal;
               			  }else{this.getNiveles().get(indiceDeNivel).contadorDeErrores++;
                     }
               		  }
           		  }
           	  }
             }
       }
   }

   long timeUltimo=System.currentTimeMillis();
   Date fechaUltima=new Date(timeUltimo);
   long segundos= ((fechaUltima.getTime()-fechaDeComienzo.getTime())/1000);
   if (segundos==unaTabla.getCantidadDeSegundosDeLaCancion()){
   	fin=true;
   }



   }

   }
   */
