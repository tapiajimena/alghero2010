package Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import Audio.Elemento;
import Audio.Reproductor;
import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Corchea;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.ElementoDeContenedor;
import Modelo.Fa;
import Modelo.Juego;
import Modelo.Letra;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nivel;
import Modelo.NivelDificil;
import Modelo.NivelFacil;
import Modelo.NivelMedio;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sol;
import Modelo.Sonido;
import Vista.VentanaAplicacion;
import Vista.VentanaPrincipal;
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


	public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

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

        //Agrego el KeyListener sobre el panel
		ControladorDeEventos controladorDeEventos = new ControladorDeEventos(this.elJuego);
		superficieDeDibujo.agregarKeyListener(controlador);
		controlador.agregarKeyPressObservador(controladorDeEventos);

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

		Negra negra=new Negra(false);
		ArmaduraDeClave unaArmadura=new ArmaduraDeClave(4,negra);
		Compas primerCompas= new Compas(unaArmadura);

		Mi unMi=new Mi();
		Fa unFa=new Fa();
		Sol unSol=new Sol();
		Nota notaMi=new Nota(negra,unMi);
		Nota notaFa=new Nota(negra,unFa);
		Nota notaSol=new Nota(negra,unSol);

		try {
			primerCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Re unRe=new Re();
		Nota notaRe=new Nota(negra,unRe);
		Compas segundoCompas= new Compas(unaArmadura);
		try {
			segundoCompas.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Do unDo=new Do();
		Nota notaDo=new Nota(negra,unDo);
		Compas tercerCompas= new Compas(unaArmadura);
		try {
			tercerCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tercerCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tercerCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tercerCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Blanca blanca=new Blanca(false);
		Nota otraNotaRe=new Nota(blanca,unRe);
		Compas cuartoCompas= new Compas(unaArmadura);
		try {
			cuartoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cuartoCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cuartoCompas.addElementoDePartitura(otraNotaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Nota otraNotaDo=new Nota(blanca,unDo);
		Compas octavoCompas= new Compas(unaArmadura);
		try {
			octavoCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			octavoCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			octavoCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(tercerCompas);
	    unaPartitura.getCompases().add(cuartoCompas);
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(tercerCompas);
	    unaPartitura.getCompases().add(octavoCompas);

	    Cancion cancion=new Cancion(unaPartitura,"Himno de la alegría","Beethoven",1);

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

		this.elJuego.getNiveles().get(0).cargarCancion(cancion);
		this.elJuego.getNiveles().get(1).cargarCancion(cancion);
		this.elJuego.getNiveles().get(2).cargarCancion(cancion);



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

				// Creamos la pelota y su vista y lo agregamos a la coleccion de objetos vivos y dibujables del controlador.
				Pelota pelotaAux = new Pelota((int)this.elJuego.getContenedorIndexado().get(indiceDeContenedor).getColumna(),this.laZonaDeJuego);
				VistaPelota vistaPelotaAux = new VistaPelota(pelotaAux.getColumna());
				vistaPelotaAux.setPosicionable(pelotaAux);
				controlador.agregarObjetoVivo(pelotaAux);
				controlador.agregarDibujable(vistaPelotaAux);

				indiceDeContenedor++;

			}
		}

	}

}

