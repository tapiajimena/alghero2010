import java.util.ArrayList;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Blanca;
import Modelo.Cancion;
import Modelo.Compas;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.ElementoDeContenedor;
import Modelo.ElementoDePartitura;
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


/*
 * En este caso
 * Para Dificil
 * Segundo-Columna
 * 2-2
 * 4-3
 * 4-1
 * 4-2
 * 4-4
 * 6-2
 * 8-1
 * 10-1
 * 12-2
 * 14-4
 * 16-3
 *
 * * Para Medio
 * Segundo-Columna
 * 2-1
 * 4-2
 * 4-1
 * 4-2
 * 4-3
 * 6-1
 * 8-1
 * 10-1
 * 12-2
 * 14-3
 * 16-2
 *
 *   Para Facil
 * Segundo-Columna
 * 2-1
 * 4-2
 * 4-1
 * 4-1
 * 4-2
 * 6-1
 * 8-1
 * 10-1
 * 12-1
 * 14-2
 * 16-2
 *
 */

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Negra negra=new Negra(true);
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
		Nota notaCuatro=new Nota(otraNegra,unFa);
		Nota notaCinco=new Nota(otraNegra,unDoSostenido);
		Nota notaSeis=new Nota(otraNegra,unSol);

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
	    NivelDificil nivelDificil = new NivelDificil();
		nivelDificil.cargarCancion(cancion);
	    NivelMedio nivelMedio = new NivelMedio();
		nivelMedio.cargarCancion(cancion);
	    NivelFacil nivelFacil = new NivelFacil();
		nivelFacil.cargarCancion(cancion);

		ArrayList<Nivel> listaNiveles = new ArrayList<Nivel>();
		listaNiveles.add(nivelDificil);
		listaNiveles.add(nivelMedio);
		listaNiveles.add(nivelFacil);

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


		ArrayList<ElementoDeContenedor> contenedorDificil=juego.getContenedores(0, 0);
		ArrayList<ElementoDeContenedor> contenedorMedio=juego.getContenedores(1, 0);
		ArrayList<ElementoDeContenedor> contenedorFacil=juego.getContenedores(2, 0);

	    for(int i=0;i< contenedorDificil.size();i++){
	    	System.out.println(contenedorDificil.get(i).getSegundo());
	    	System.out.println(contenedorDificil.get(i).getColumna());


}
	    for(int i=0;i< contenedorMedio.size();i++){
	    	System.out.println(contenedorMedio.get(i).getSegundo());
	    	System.out.println(contenedorMedio.get(i).getColumna());


}
	    for(int i=0;i< contenedorFacil.size();i++){
	    	System.out.println(contenedorFacil.get(i).getSegundo());
	    	System.out.println(contenedorFacil.get(i).getColumna());


}




}





}



