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
import Modelo.Redonda;
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

		Negra negraS=new Negra(true);
		Negra negra=new Negra(false);
		Redonda redondaS=new Redonda(true);
		Redonda redonda=new Redonda(false);
		Blanca blanca=new Blanca(false);
		Blanca blancaS=new Blanca(true);
		Do unDo=new Do();
		Mi unMi=new Mi();
		Sol unSol=new Sol();
		Re unRe=new Re();
		Fa unFa=new Fa();


		Nota notaFaSil=new Nota(blancaS,unFa);
		Nota notaReSil=new Nota(negraS,unRe);
		Nota notaDoSil=new Nota(redondaS,unDo);
		Nota notaDo=new Nota(negra,unDo);
		Nota notaMi=new Nota(negra,unMi);
		Nota notaFa=new Nota(negra,unFa);
		Nota notaSol=new Nota(negra,unSol);

		ArmaduraDeClave armaduraDos=new ArmaduraDeClave(4,negra);
		Compas primerCompas= new Compas(armaduraDos);
		try {
			primerCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			primerCompas.addElementoDePartitura(notaDo);
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


        Nota solRedonda=new Nota(redonda,unSol);


	    Compas segundoCompas= new Compas(armaduraDos);
	    try {
			segundoCompas.addElementoDePartitura(solRedonda);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota otraNotaSol=new Nota(blanca,unSol);
	    Nota otraNotaMi=new Nota(blanca,unMi);

	    Compas sextoCompas= new Compas(armaduraDos);
	    try {
			sextoCompas.addElementoDePartitura(otraNotaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			sextoCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota otraNotaDo=new Nota(blanca,unDo);

	    Compas septimoCompas= new Compas(armaduraDos);
	    try {
			septimoCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			septimoCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Nota notaRe=new Nota(negra,unRe);
	    Nota otraNotaRe=new Nota(redonda,unRe);
	    Compas octavoCompas= new Compas(armaduraDos);
	    try {
			octavoCompas.addElementoDePartitura(otraNotaRe);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas novenoCompas= new Compas(armaduraDos);
	    try {
			novenoCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	    try {
			novenoCompas.addElementoDePartitura(notaRe);
		} catch (CompasLlenoException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	    Compas decimoCompas= new Compas(armaduraDos);
	    try {
			decimoCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
			decimoCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			decimoCompas.addElementoDePartitura(notaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    Compas onceCompas= new Compas(armaduraDos);
	    try {
			onceCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			onceCompas.addElementoDePartitura(otraNotaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Nota otraNotaFa=new Nota(blanca,unFa);
	    Compas doceCompas= new Compas(armaduraDos);
	    try {
			doceCompas.addElementoDePartitura(notaSol);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doceCompas.addElementoDePartitura(otraNotaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doceCompas.addElementoDePartitura(notaReSil);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas treceCompas= new Compas(armaduraDos);
	    try {
			treceCompas.addElementoDePartitura(notaFaSil);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			treceCompas.addElementoDePartitura(notaMi);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			treceCompas.addElementoDePartitura(notaFa);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Compas catorceCompas= new Compas(armaduraDos);
	    try {
			catorceCompas.addElementoDePartitura(otraNotaSol);
		} catch (CompasLlenoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
			catorceCompas.addElementoDePartitura(otraNotaMi);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Nota notaReBlanca=new Nota(blanca,unRe);
	    Compas quinceCompas= new Compas(armaduraDos);
	    try {
			quinceCompas.addElementoDePartitura(otraNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			quinceCompas.addElementoDePartitura(notaReBlanca);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    Nota ultimaNotaDo=new Nota(redonda,unDo);
	    Compas dieciseisCompas= new Compas(armaduraDos);
	    try {
			dieciseisCompas.addElementoDePartitura(ultimaNotaDo);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(sextoCompas);
	    unaPartitura.getCompases().add(septimoCompas);
	    unaPartitura.getCompases().add(octavoCompas);
	    unaPartitura.getCompases().add(novenoCompas);
	    unaPartitura.getCompases().add(decimoCompas);
	    unaPartitura.getCompases().add(onceCompas);
	    unaPartitura.getCompases().add(doceCompas);
	    unaPartitura.getCompases().add(treceCompas);
	    unaPartitura.getCompases().add(catorceCompas);
	    unaPartitura.getCompases().add(quinceCompas);
	    unaPartitura.getCompases().add(dieciseisCompas);



	    Cancion cancion=new Cancion(unaPartitura,"Marcha de los santos","nose",1);

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


