package Controlador;

import java.util.ArrayList;
import java.util.Date;

import Excepciones.CompasLlenoException;
import Modelo.Acorde;
import Modelo.ArmaduraDeClave;
import Modelo.Compas;
import Modelo.Do;
import Modelo.DoSostenido;
import Modelo.Fa;
import Modelo.Mi;
import Modelo.Negra;
import Modelo.Nota;
import Modelo.Partitura;
import Modelo.Re;
import Modelo.Sol;
import Modelo.Sonido;
import Vista.VentanaPrincipal;



public class ControladorJuego  {

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


	    ArmadorDeContenedor unArmador=new ArmadorDeContenedor(unaPartitura);
	    ArrayList<ElementoDeContenedor> contenedor =new ArrayList<ElementoDeContenedor>();
	    contenedor = unArmador.getContenedor();

//HASTA ACA TODO BIEN

	    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        /*ventanaPrincipal.addPelotita(0);
        ventanaPrincipal.addPelotita(1);
        ventanaPrincipal.addPelotita(2);*/

        // Pedimos la fecha del comienzo del ciclo.
        long time = System.currentTimeMillis();
        Date fechaDeComienzo = new Date(time);
        int j = 0;

        while(true){

        	// Borramos las pelotitas que ya terminaron de dibujarse.
        	for(int i = 0 ; i < ventanaPrincipal.getPelotitas().size() ; i++){

        		if(((ventanaPrincipal.getPelotitas()).get(i)).getCentroY() > (ventanaPrincipal.getPanel()).getHeight())
        			(ventanaPrincipal.getPelotitas()).remove(i);

        	}

        	// Dibujamos todas las pelotitas que hay que dibujar
        	ventanaPrincipal.run();

        	// Nos fijamos si hay que agregar alguna pelotita mas.

        	time = System.currentTimeMillis();
            Date fechaActual = new Date(time);

            // Este if lo ponemos para no acceder a un elemento no existente de
            // contenedor.

            if(j < contenedor.size()){

            	if((fechaActual.getTime() - fechaDeComienzo.getTime()) > 1000 * (contenedor.get(j)).getSegundo()){

            		// Cambiar getColumna de double a int.
            		ventanaPrincipal.addPelotita((int)(contenedor.get(j)).getColumna());
            		j++;
            	}
            }
        }

    }

}








/*	    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        ventanaPrincipal.addPelotita(0);
        ventanaPrincipal.addPelotita(1);
        ventanaPrincipal.addPelotita(2);

        // Pedimos la fecha del comienzo del ciclo.
        long time = System.currentTimeMillis();
        Date fechaDeComienzo = new Date(time);

        while(true){

        	// Borramos las pelotitas que ya terminaron de dibujarse.
        	for(int i = 0 ; i < ventanaPrincipal.getPelotitas().size() ; i++){

        		if(((ventanaPrincipal.getPelotitas()).get(i)).getCentroY() > (ventanaPrincipal.getPanel()).getHeight())
        			(ventanaPrincipal.getPelotitas()).remove(i);

        	}

        	ventanaPrincipal.run();

        	time = System.currentTimeMillis();
            Date fechaAux = new Date(time);

            // Pasado 1 segundo de lanzar las primeras 3 pelotitas lanzo una
            // cuarta pelotita.

            if(fechaAux.getTime()==(1000 + fechaDeComienzo.getTime()))
            	ventanaPrincipal.addPelotita(3);

        }


    }

}


*/




/*

	    int index=0;


	        	ventanaPrincipal.run();
		while(index<contenedor.size()){



			while((contenedor.get(index).getSegundo())==(contenedor.get(index+1).getSegundo())){


				ventanaPrincipal.addPelotita(contenedor.get(index).getColumna());
				index=index+1;

			}
			if((!((contenedor.get(index).getSegundo())==(contenedor.get(index+1).getSegundo())))  || (index==contenedor.size()) ){


				ventanaPrincipal.addPelotita(contenedor.get(index).getColumna());
				index=index+1;


			}


		}



        }





}
*/
//COSAS VIEJAS/PARA AGREGAR
/*VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();


        ventanaPrincipal.addPelotita(0);
        ventanaPrincipal.addPelotita(1);
        ventanaPrincipal.addPelotita(2);

        // Pedimos la fecha del comienzo del ciclo.
        long time = System.currentTimeMillis();
        Date fechaDeComienzo = new Date(time);

        while(true){

        	// Borramos las pelotitas que ya terminaron de dibujarse.
        	for(int i = 0 ; i < ventanaPrincipal.pelotitas.size() ; i++){

        		if(ventanaPrincipal.pelotitas.get(i).getCentroY()>600)
        			ventanaPrincipal.pelotitas.remove(i);

        	}

        	ventanaPrincipal.run();

        	time = System.currentTimeMillis();
            Date fechaAux = new Date(time);

            // Pasado 1 segundo de lanzar las primeras 3 pelotitas lanzo una
            // cuarta pelotita.

            if(fechaAux.getTime()==(1000 + fechaDeComienzo.getTime()))
            	ventanaPrincipal.addPelotita(3);*/









/*

     Método por el cual se ingresan las 6 letras a utilizar durante todo
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
    public void definirLetras(Juego unJuego){
            char letraIngresada;
            int maximaCantidadLetras = 6;
            for (int i=0 ; i<maximaCantidadLetras ; i++){
                letraIngresada = this.ingresarLetras();
                unJuego.getLetras().add(new Letra(letraIngresada));
            }
    }


	/*public Reproductor getReproductorDeAudio() {
		if(!this.estaReproductorActivo)
			throw new OperacionNoValida();
		return this.reproductor;
	}

}
public void Jugar(Juego unJuego,int indiceDeNivel,int indiceDeCancion){

	La primer tabla es de la forma: Segundo-ElementoDePartitura
	 * La segunda tabla es de la forma: Sonido-Tecla
	 * Entonces se fija que sonido tiene el elemento que se toco en
	 * ese segundo y se fija si  la tecla asociada coincide con la
	 * tecla asoc a ese sonido



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
//FORMA PARA VER SI SE PRESIONA UNA TECLA?
    	//Y ADEMAS GUARDAR EL EVENT EN UNA VARIABLE PARA COMPARAR
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



    }*/



