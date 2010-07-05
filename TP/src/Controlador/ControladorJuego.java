package Controlador;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import Modelo.Juego;

import Vista.Dibujable;
import Controlador.KeyPressedObservador;
import Vista.MouseClickObservador;
import Vista.ObjetoVivo;
import Excepciones.OperacionNoValida;
import Vista.SuperficieDeDibujo;

import Modelo.Acorde;
import Modelo.Cancion;
import Modelo.ElementoDePartitura;
import Modelo.Letra;
import Modelo.Nota;
import Modelo.Sonido;
import Modelo.TablaDeMapeo;


public class ControladorJuego implements Runnable {

	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List<ObjetoVivo> objetosVivos;
	private List<Dibujable> dibujables;
	private List<MouseClickObservador> mouseClickObservadores;
	private List<KeyPressedObservador> keyPressedObservadores;
	private SuperficieDeDibujo superficieDeDibujo;
	//private Reproductor reproductor;
	private Thread hiloAudio;
	private boolean estaReproductorActivo;

	public ControladorJuego(boolean activarReproductor){
		this.objetosVivos = new ArrayList<ObjetoVivo>();
		this.dibujables = new ArrayList<Dibujable>();
		this.mouseClickObservadores = new ArrayList<MouseClickObservador>();
		this.keyPressedObservadores = new ArrayList<KeyPressedObservador>();
		/*this.estaReproductorActivo = activarReproductor;
		if(this.estaReproductorActivo)
			this.reproductor = new Reproductor();*/
	}

	public void Jugar(Juego unJuego,int indiceDeNivel,int indiceDeCancion){

    	/*La primer tabla es de la forma: Segundo-ElementoDePartitura
    	 * La segunda tabla es de la forma: Sonido-Tecla
    	 * Entonces se fija que sonido tiene el elemento que se toco en
    	 * ese segundo y se fija si  la tecla asociada coincide con la
    	 * tecla asoc a ese sonido
    	 */


        Cancion cancionActual = unJuego.getNiveles().get(indiceDeNivel).elegirCancion(indiceDeCancion);
        TablaDeMapeo unaTabla= new TablaDeMapeo(cancionActual) ;
        unaTabla.armarTabla();
        Map<Double, ElementoDePartitura> primerTabla = unaTabla.getTabla();

        unJuego.getNiveles().get(indiceDeNivel).distribuirTeclas();
        Map<Integer, Letra> segundaTabla = unJuego.getNiveles().get(indiceDeNivel).getTablaDeTeclas();

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
                			  unJuego.getNiveles().get(indiceDeNivel).aumetarContadorDeAciertos();
                			  unJuego.getNiveles().get(indiceDeNivel).incrementarPuntajeActual(primerTabla.get(segundosQuePasaron).getPuntajeIdeal());
                			  }else{unJuego.getNiveles().get(indiceDeNivel).aumetarContadorDeErroress();
                      }

                		  if (elementoActual instanceof Acorde){
                    		  ArrayList<Sonido> sonidosActuales = ((Acorde)elementoActual).getSonidos();
                    		  for(int i=0;i<sonidosActuales.size();i++){
                    			 Sonido elSonidoActual = sonidosActuales.get(i);

                    		  if (segundaTabla.get(elSonidoActual)==teclaIngresada){
                    			  unJuego.getNiveles().get(indiceDeNivel).aumetarContadorDeAciertos();
                    			  unJuego.getNiveles().get(indiceDeNivel).incrementarPuntajeActual(primerTabla.get(segundosQuePasaron).getPuntajeIdeal());
                    			  }else{unJuego.getNiveles().get(indiceDeNivel).aumetarContadorDeErroress();
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


	public boolean estaEnEjecucion(){
		return this.estaEnEjecucion;
	}

	public void comenzarJuego(){
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				simular();
				dibujar();
				Thread.sleep(intervaloSimulacion);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void comenzarJuegoAsyn(){
		Thread thread = new Thread(this);
		thread.start();
		if(this.estaReproductorActivo){
			/*this.reproductor.encender();
			this.hiloAudio =  new Thread(this.reproductor);
			this.hiloAudio.start();*/
		}
	}

	/**
	 * Le da comienzo al juego poniendo en marcha el gameloop.
	 * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..
	 */
	public void comenzarJuego(int cantidadDeCiclos){
		int contador = 0;
		estaEnEjecucion = true;
		try{
			while(contador < cantidadDeCiclos && estaEnEjecucion){
				simular();
				dibujar();
				Thread.sleep(intervaloSimulacion);
				contador++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Detiene el juego provocando la salida del gameloop.
	 */
	public void detenerJuego(){
		this.estaEnEjecucion = false;
		//this.reproductor.apagar();
	}

	public void agregarObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.add(objetoVivo);
	}

	public void removerObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.remove(objetoVivo);
	}

	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}

	public void removerDibujable(Dibujable unDibujable){
		dibujables.remove(unDibujable);
	}

	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}

	private void dibujar() {
		Iterator<Dibujable> iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = iterador.next();
			dibujable.dibujar(this.superficieDeDibujo);
		}
		this.superficieDeDibujo.actualizar();
	}

	/**
	 * Ejecuta la simulacion recorriendo la coleccion de objetivos vivos.
	 */
	private void simular() {
		this.superficieDeDibujo.limpiar();
		Iterator<ObjetoVivo> iterador = objetosVivos.iterator();
		while(iterador.hasNext()){
			iterador.next().vivir();
		}
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}

	/**
	 * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
	 * @param x posición horizontal del mouse
	 * @param y posición vertial del mouse
	 */
	public void despacharMouseClick(int x, int y){
		MouseClickObservador mouseClickObservador;
		Iterator<MouseClickObservador> iterador = this.mouseClickObservadores.iterator();
		while(iterador.hasNext()){
			mouseClickObservador = iterador.next();
			mouseClickObservador.MouseClick(x, y);
		}
	}

	public void agregarMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.add(unMouseClickObservador);
	}

	public void removerMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.remove(unMouseClickObservador);
	}

	/**
	 * Se encarga de derivar el manejo del evento keyPress al objeto vista correspondiente
	 * @param KeyEvent evento
	 */
	public void despacharKeyPress(KeyEvent event){
		for (KeyPressedObservador observador : this.keyPressedObservadores){
			observador.keyPressed(event);
		}
	}

	public void agregarKeyPressObservador(KeyPressedObservador unMouseClickObservador){
		this.keyPressedObservadores.add(unMouseClickObservador);
	}

	public void removerKeyPressObservador(KeyPressedObservador unMouseClickObservador){
		this.keyPressedObservadores.remove(unMouseClickObservador);
	}



	public void run() {
		this.comenzarJuego();
	}

	/*public Reproductor getReproductorDeAudio() {
		if(!this.estaReproductorActivo)
			throw new OperacionNoValida();
		return this.reproductor;
	}*/

}

