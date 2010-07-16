package Controlador;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.LinkedList;

 import Audio.Elemento;
 import Excepciones.CompasLlenoException;
 import Modelo.Acorde;
 import Modelo.ArmaduraDeClave;
 import Modelo.Cancion;
 import Modelo.Compas;
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

 public class AlgoHero2010 implements ObjetoVivo{

         private ControladorJuego controlador = null;
         private ZonaDeJuego laZonaDeJuego;
         private VistaZonaDeJuego laVistaZonaDeJuego;
         private LinkedList<Pelota> pelotitas = new LinkedList<Pelota>();
         private Juego elJuego;
         private Date fechaDeComienzo;
         private boolean comenzoLaSimulacion;
         private int posicionTabla;

         public AlgoHero2010(SuperficieDeDibujo superficieDeDibujo){

                 comenzoLaSimulacion = false;
                 posicionTabla = 0;

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

         public void pruebaVista(){

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

                 //juego.getNiveles().get(0).modificarVelocidad();
                 //juego.getNiveles().get(1).modificarVelocidad();
                 //juego.getNiveles().get(2).modificarVelocidad();

                 /*for(int i=0;i< juego.getNiveles().size();i++){
                         juego.getNiveles().get(i).modificarVelocidad();

                 }*/

                 this.elJuego=juego;

         }


         public void vivir() {

                 // Con este método se arma un contenedor de notas ficticio.300*
                 pruebaVista();

                 // Ni bien empieza la simulación encendemos el cronometro.

                 if(this.comenzoLaSimulacion == false){

                         comenzoLaSimulacion = true;
                         long time = System.currentTimeMillis();
                 this.fechaDeComienzo = new Date(time);

                 }


                 // Nos fijamos si hay que agregar alguna pelotita mas.

         long timeAux = System.currentTimeMillis();
         Date fechaActual = new Date(timeAux);

         // Este if lo ponemos para no acceder a un elemento no existente de
         // contenedor.

         if(posicionTabla < elJuego.getContenedor(2,0).size()){

                 if((fechaActual.getTime() - fechaDeComienzo.getTime()) > 1000 * this.elJuego.getContenedor(2, 0).get(posicionTabla).getSegundo()){

                         Pelota pelotaAux = new Pelota((int)this.elJuego.getContenedor(2, 0).get(posicionTabla).getColumna(),this.laZonaDeJuego);
                         VistaPelota vistaPelotaAux = new VistaPelota(pelotaAux.getColumna());
                         vistaPelotaAux.setPosicionable(pelotaAux);
                         controlador.agregarObjetoVivo(pelotaAux);
                         controlador.agregarDibujable(vistaPelotaAux);;
                 posicionTabla++;

             }
         }


         }


 }
