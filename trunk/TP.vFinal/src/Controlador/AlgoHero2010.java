package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import Modelo.Cancion;
import Modelo.Juego;
import Modelo.Letra;
import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.NivelFacil;
import Modelo.NivelMedio;

import Vista.ZonaDeJuego;
import Vista.Pelota;
import Vista.VistaZonaDeJuego;
import Vista.VistaPelota;
//
public class AlgoHero2010 implements ObjetoVivo{

	private ControladorJuego controlador = null;
	private ZonaDeJuego laZonaDeJuego;
	private VistaZonaDeJuego laVistaZonaDeJuego;
	private Juego elJuego;
	private boolean comenzoLaSimulacion;
	private int indiceDeContenedor;

	private boolean creamosElRegistradorDeEventos;


	public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

		creamosElRegistradorDeEventos = false;

		this.controlador = new ControladorJuego(true);
        this.controlador.setSuperficieDeDibujo(superficieDeDibujo);

        this.laZonaDeJuego = new ZonaDeJuego(600, 600);
        this.laVistaZonaDeJuego = new VistaZonaDeJuego();
        this.laVistaZonaDeJuego.setPosicionable(laZonaDeJuego);

		this.comenzoLaSimulacion = false;

		this.indiceDeContenedor = 0;

		// Cargo la lista de canciones en todas sus dificultades.
		CargarCanciones();

        this.controlador.agregarObjetoVivo(this);

        this.controlador.agregarDibujable(laVistaZonaDeJuego);

        this.controlador.setIntervaloSimulacion(10);

		// Referenciamos en el objeto juego el reproductor de audio.
		this.elJuego.setReferenciaAlReproductor(this.controlador.getReproductorDeAudio());

	}

	public ControladorJuego getControlador(){

		return this.controlador;

	}

	public ZonaDeJuego getZonaDeJuego(){

		return this.laZonaDeJuego;

	}

	public VistaZonaDeJuego getVistaZonaDeJuego(){

		return this.laVistaZonaDeJuego;

	}


	public Juego getJuego(){

		return this.elJuego;

	}


	public boolean getComenzoLaSimulacion(){

		return this.comenzoLaSimulacion;

	}

	public int getIndiceContenedor(){

		return this.indiceDeContenedor;

	}


	public void setControlador(ControladorJuego unControlador){

		this.controlador = unControlador;

	}

	public void setZonaDeJuego(ZonaDeJuego unaZonaDeJuego){

		this.laZonaDeJuego = unaZonaDeJuego;

	}

	public void setVistaZonaDeJuego(VistaZonaDeJuego unaVistaZonaDeJuego){

		this.laVistaZonaDeJuego = unaVistaZonaDeJuego;

	}


	public void setJuego(Juego unJuego){

		this.elJuego = unJuego;

	}

	public void setComenzoLaSimulacion(boolean unComenzoLaSimulacion){

		this.comenzoLaSimulacion = unComenzoLaSimulacion;

	}

	public void setIndiceContenedor(int unIndiceDeContenedor){

		this.indiceDeContenedor = unIndiceDeContenedor;

	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo unaSuperficieDeDibujo){

		this.controlador.setSuperficieDeDibujo(unaSuperficieDeDibujo);

		if(this.creamosElRegistradorDeEventos == false){

			//Agrego el KeyListener sobre el panel
			ControladorDeEventos controladorDeEventos = new ControladorDeEventos(this.elJuego);
			unaSuperficieDeDibujo.agregarKeyListener(controlador);
			controlador.agregarKeyPressObservador(controladorDeEventos);
			this.creamosElRegistradorDeEventos = true;

		}

	}

	public void elegirCancion(int unIndiceDeCancion){

		this.elJuego.setIndiceCancion(unIndiceDeCancion);

	}

	public void elegirNivel(int unIndiceDeNivel){

		this.elJuego.setIndiceNivel(unIndiceDeNivel);

	}


	public void comenzar(){
		controlador.comenzarJuegoAsyn();
	}

	public void detener() {
		controlador.detenerJuego();
	}


	public void CargarCanciones() {

		Cancion cancionUno=null;
		Cancion cancionDos=null;
		Cancion cancionTres=null;

		try{
	         cancionUno = Cancion.recuperar("HimnoDeLaAlegria.xml");


	        }catch(IOException ex){
	            System.out.println("NO RECUPERA EL ARCHIVO");
	        }



	        try{
		         cancionDos = Cancion.recuperar("MarchaDeLosSantos.xml");


		        }catch(IOException ex){
		            System.out.println("NO RECUPERA EL ARCHIVO");
		        }
		        try{
			         cancionTres = Cancion.recuperar("InspectorGadjet.xml");


			        }catch(IOException ex){
			            System.out.println("NO RECUPERA EL ARCHIVO");
			        }


	    NivelFacil nivelFacil = new NivelFacil();

		NivelMedio nivelMedio = new NivelMedio();

	    NivelDificil nivelDificil = new NivelDificil();



		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();

		listaNiveles.add(nivelFacil);
		listaNiveles.add(nivelMedio);
		listaNiveles.add(nivelDificil);

		this.elJuego = new Juego(listaNiveles);

        //Estas letras las ingresa el usuario
		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');
		Letra f=new Letra('f');
		Letra g=new Letra('g');
		Letra h=new Letra('h');

		this.elJuego.getLetras().add(a);
		this.elJuego.getLetras().add(s);
		this.elJuego.getLetras().add(d);
		this.elJuego.getLetras().add(f);
		this.elJuego.getLetras().add(g);
		this.elJuego.getLetras().add(h);

		this.elJuego.asignarLetrasNivel();
		for(int i=0;i< this.elJuego.getNiveles().size();i++){
			this.elJuego.getNiveles().get(i).distribuirTeclas();

		}

		this.elJuego.getNiveles().get(0).cargarCancion(cancionUno);
		this.elJuego.getNiveles().get(1).cargarCancion(cancionUno);
		this.elJuego.getNiveles().get(2).cargarCancion(cancionUno);
		this.elJuego.getNiveles().get(0).cargarCancion(cancionDos);
		this.elJuego.getNiveles().get(1).cargarCancion(cancionDos);
		this.elJuego.getNiveles().get(2).cargarCancion(cancionDos);
		this.elJuego.getNiveles().get(0).cargarCancion(cancionTres);
		this.elJuego.getNiveles().get(1).cargarCancion(cancionTres);
		this.elJuego.getNiveles().get(2).cargarCancion(cancionTres);



	}


	public void vivir() {

	// Con este método se arma un contenedor de notas ficticio.300*


		// Ni bien empieza la simulación encendemos el cronometro.
		if(this.comenzoLaSimulacion == false){

			comenzoLaSimulacion = true;
			long time = System.currentTimeMillis();
			Date unaFechaDeComienzo = new Date(time);
			this.elJuego.setFechaDeComienzo(unaFechaDeComienzo);

		}


		// Nos fijamos si hay que agregar alguna pelotita mas.

		long timeAux = System.currentTimeMillis();
		Date fechaActual = new Date(timeAux);
		double tiempoDeSimulacion = (double)(fechaActual.getTime() - this.elJuego.getFechaDeComienzo().getTime())/1000;

		// Este if lo ponemos para no acceder a un elemento no existente de
		// contenedor.

		if(indiceDeContenedor < this.elJuego.getContenedorIndexado().size()){

			// Si es momento de crear una pelota
			if(tiempoDeSimulacion > this.elJuego.getContenedorIndexado().get(indiceDeContenedor).getSegundo()){

				if((int)this.elJuego.getContenedorIndexado().get(indiceDeContenedor).getColumna()>=0){

					// Creamos la pelota y su vista y lo agregamos a la coleccion de objetos vivos y dibujables del controlador.
					Pelota pelotaAux = new Pelota((int)this.elJuego.getContenedorIndexado().get(indiceDeContenedor).getColumna(),this.laZonaDeJuego);
					VistaPelota vistaPelotaAux = new VistaPelota(pelotaAux.getColumna());
					vistaPelotaAux.setPosicionable(pelotaAux);
					controlador.agregarObjetoVivo(pelotaAux);
					controlador.agregarDibujable(vistaPelotaAux);
				}

				indiceDeContenedor++;

			}
		}

	}

}


