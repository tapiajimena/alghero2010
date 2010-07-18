package Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import Audio.Elemento;
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
	private LinkedList<Pelota> pelotitas = new LinkedList<Pelota>();
	private Juego elJuego;
	private Date fechaDeComienzo;
	private boolean comenzoLaSimulacion;
	private int posicionTabla;
	private int indiceDeNivel;

	public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

		comenzoLaSimulacion = false;
		posicionTabla = 0;
		indiceDeNivel = 1;

        this.laZonaDeJuego = new ZonaDeJuego(600, 600);

        this.controlador = new ControladorJuego(true);
        this.controlador.setSuperficieDeDibujo(superficieDeDibujo);

        this.laVistaZonaDeJuego = new VistaZonaDeJuego();
        this.laVistaZonaDeJuego.setPosicionable(laZonaDeJuego);

        this.controlador.agregarObjetoVivo(this);

        this.controlador.agregarDibujable(laVistaZonaDeJuego);


        this.controlador.setIntervaloSimulacion(10);

	}

	public LinkedList<Pelota> getPelotitas(){
		return pelotitas;
	}

	public void comenzar(){
		controlador.comenzarJuegoAsyn();
	}

	public void detener() {
		controlador.detenerJuego();
	}

	public void pruebaVista() {
/*
		Negra negra=new Negra(true);
		Corchea corchea = new Corchea(true);
		Negra otraNegra=new Negra(false);

		ArmaduraDeClave unaArmadura=new ArmaduraDeClave(6,otraNegra);
		Compas primerCompas= new Compas(unaArmadura);
		Do unDo=new Do();
		Mi unMi=new Mi();
		Sol unSol=new Sol();
		Re unRe=new Re();
		Fa unFa=new Fa();
		DoSostenido unDoSostenido=new DoSostenido();

	    Nota unaNota=new Nota(negra,unDo);//
	    Nota otraNota=new Nota(otraNegra,unMi);
	    ArrayList<Sonido> sonidos=new ArrayList<Sonido>();
	    sonidos.add(unSol);
	    sonidos.add(unRe);
	    sonidos.add(unFa);
	    sonidos.add(unDoSostenido);
	    Acorde unAcorde=new Acorde(otraNegra,sonidos);

	    try {
			primerCompas.addElementoDePartitura(unaNota);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			primerCompas.addElementoDePartitura(otraNota);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			primerCompas.addElementoDePartitura(unAcorde);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Compas segundoCompas= new Compas(unaArmadura);
		Nota notaUno=new Nota(otraNegra,unMi);
		Nota notaDos=new Nota(otraNegra,unDo);
		Nota notaTres=new Nota(otraNegra,unRe);
		Nota notaCuatro=new Nota(corchea,unFa);
		Nota notaCinco=new Nota(corchea,unDoSostenido);
		Nota notaSeis=new Nota(corchea,unSol);

		try {
			segundoCompas.addElementoDePartitura(notaUno);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaDos);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaTres);
		} catch (CompasLlenoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaCuatro);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaCinco);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			segundoCompas.addElementoDePartitura(notaSeis);
		} catch (CompasLlenoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    Partitura unaPartitura=new Partitura();
	    unaPartitura.getCompases().add(primerCompas);
	    unaPartitura.getCompases().add(segundoCompas);

	    Cancion cancion=new Cancion(unaPartitura,"hola","chau",2);

	    NivelFacil nivelFacil = new NivelFacil();

		NivelMedio nivelMedio = new NivelMedio();

	    NivelDificil nivelDificil = new NivelDificil();



		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();

		listaNiveles.add(nivelFacil);
		listaNiveles.add(nivelMedio);
		listaNiveles.add(nivelDificil);

		Juego juego = new Juego(listaNiveles);

        //Estas letras las ingresa el usuario
		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');
		Letra f=new Letra('f');
		Letra g=new Letra('g');
		Letra h=new Letra('h');

		juego.getLetras().add(a);
		juego.getLetras().add(s);
		juego.getLetras().add(d);
		juego.getLetras().add(f);
		juego.getLetras().add(g);
		juego.getLetras().add(h);

		juego.asignarLetrasNivel();
		for(int i=0;i< juego.getNiveles().size();i++){
			juego.getNiveles().get(i).distribuirTeclas();

		}

		juego.getNiveles().get(0).cargarCancion(cancion);
		juego.getNiveles().get(1).cargarCancion(cancion);
		juego.getNiveles().get(2).cargarCancion(cancion);

		this.elJuego=juego;
*/

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

		Juego juego = new Juego(listaNiveles);

        //Estas letras las ingresa el usuario
		Letra a=new Letra('a');
		Letra s=new Letra('s');
		Letra d=new Letra('d');
		Letra f=new Letra('f');
		Letra g=new Letra('g');
		Letra h=new Letra('h');

		juego.getLetras().add(a);
		juego.getLetras().add(s);
		juego.getLetras().add(d);
		juego.getLetras().add(f);
		juego.getLetras().add(g);
		juego.getLetras().add(h);

		juego.asignarLetrasNivel();
		for(int i=0;i< juego.getNiveles().size();i++){
			juego.getNiveles().get(i).distribuirTeclas();

		}

		juego.getNiveles().get(0).cargarCancion(cancion);
		juego.getNiveles().get(1).cargarCancion(cancion);
		juego.getNiveles().get(2).cargarCancion(cancion);

		this.elJuego=juego;












	}


	public void vivir() {

		// Con este método se arma un contenedor de notas ficticio.300*


		// Ni bien empieza la simulación encendemos el cronometro.

		if(this.comenzoLaSimulacion == false){

			comenzoLaSimulacion = true;
			long time = System.currentTimeMillis();
	        this.fechaDeComienzo = new Date(time);
	        pruebaVista();

		}


		// Nos fijamos si hay que agregar alguna pelotita mas.

        long timeAux = System.currentTimeMillis();
        Date fechaActual = new Date(timeAux);

        // Este if lo ponemos para no acceder a un elemento no existente de
        // contenedor.

        if(posicionTabla < elJuego.getNiveles().get(indiceDeNivel).getContenedores().get(0).size()){

        	if((fechaActual.getTime() - fechaDeComienzo.getTime()) > 1000 * this.elJuego.getNiveles().get(indiceDeNivel).getContenedores().get(0).get(posicionTabla).getSegundo()){

        		Pelota pelotaAux = new Pelota((int)this.elJuego.getNiveles().get(indiceDeNivel).getContenedores().get(0).get(posicionTabla).getColumna(),this.laZonaDeJuego);
        		VistaPelota vistaPelotaAux = new VistaPelota(pelotaAux.getColumna());
    			vistaPelotaAux.setPosicionable(pelotaAux);
    			controlador.agregarObjetoVivo(pelotaAux);
    			controlador.agregarDibujable(vistaPelotaAux);;
            	posicionTabla++;

            }
        }


	}


}


