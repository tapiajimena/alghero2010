 package Modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import Modelo.Letra;
import Modelo.Nivel;

public class Juego {

    //Atributos:

    private ArrayList<Nivel> niveles;
    private ArrayList<Letra> letras;
    private TablaDeMapeo tabla;

    //Métodos:

    public void Jugar(int indiceDeNivel,int indiceDeCancion){

        Cancion cancionActual = this.niveles.get(indiceDeNivel).elegirCancion(indiceDeCancion);
        TablaDeMapeo unaTabla= new TablaDeMapeo(cancionActual) ;
        unaTabla.armarTabla();
        Map<Double, ElementoDePartitura> primerTabla = unaTabla.getTabla();

        this.getNiveles().get(indiceDeNivel).distribuirTeclas();

        Map<Integer, Letra> segundaTabla = this.getNiveles().get(indiceDeNivel).getTablaDeTeclas();

        /*PSEUDOCODIGO!!!
        Se inicializa un cronometro
        Se habilita el teclado

        While (el cronometro no sea igual a la long de la cancion){

        if (se ingresa tecla){
            if  ( primerTabla.containsKey(cronometro)){
                  //DISTINTO PARA ACORDE Y PARA NOTA (CASTEAR????)
                  //PARA NOTA SERIA...
              sonido=primerTabla.get(cronometro).getSonido().getIdentificador();
              if (segundaTabla.get(sonido)==teclaingresada){

                 this.getNiveles().get(indiceDeNivel).contadorDeAciertos++;
                 this.getNiveles().get(indiceDeNivel).puntajeActual=+primerTabla.get(cronometro).puntajeIdeal;
                 }else{this.getNiveles().get(indiceDeNivel).contadorDeErrores++;
                      }
             }
           }
         }




    */
    }

    public Juego(ArrayList<Nivel> losNiveles){
        this.letras= new ArrayList<Letra>();
        this.niveles = losNiveles;
    }

    public ArrayList<Letra> getLetras(){
        return letras;
    }

    public ArrayList<Nivel> getNiveles(){
        return niveles;
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

    /* Se definen las letras que quiere usar el usuario */
    public void definirLetras(){
            char letraIngresada;
            int maximaCantidadLetras = 6;
            for (int i=0 ; i<maximaCantidadLetras ; i++){
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

    /* Método que lleva a cabo el conteo de puntos */
    public void calcularPuntaje(){
        //
    }




}
