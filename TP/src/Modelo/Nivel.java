package Modelo;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Icon;


 public abstract class Nivel {

         //Atributos:


         protected ArrayList<Letra> letras;
         protected int cantidadTeclas;
         protected ArrayList<Cancion> canciones;
         protected double factorAumentoDificultad;
         /*Guarda la relacion entre los sonidos (usando su identifcador) y
          * la letra que tiene asignada
          */
         protected Map<Integer,Letra> tablaDeTeclas;
         protected String nombre;

         /* Lleva la cuenta del puntaje acumulado */
         protected double puntajeActual;

         /* Puntaje minimo a ser alcanzado para superar el nivel */
         protected double puntajeMinimo;

         /* Porcentage minimo a ser alcanzado para superar el nivel */
         protected double porcentajeMinimo;

         /* Puntaje ideal del nivel. */
         protected double puntajeIdeal;

         /* Llevan el conteo de lo que sucede con la apreciacion de las notas */
         protected double contadorDeErrores;
         protected double contadorDeAciertos;
         protected double contadorDePerfectos;





         //Métodos:

         public abstract void modificarVelocidad();

         public abstract void distribuirTeclas();

         public void aumetarContadorDeAciertos(){
        	 this.contadorDeAciertos++;
         }

         public void aumetarContadorDeErroress(){
        	 this.contadorDeErrores++;
         }

         public void aumetarContadorDePerfectos(){
        	 this.contadorDePerfectos++;
         }

         public Map<Integer,Letra> getTablaDeTeclas(){
        	 return tablaDeTeclas;
         }

         public int getCantidadDeTeclas(){
     		return cantidadTeclas;
     	}

         public ArrayList<Letra> getLetras(){
        	 return letras;

         }


         public void cargarCancion(Cancion unaCancion){
                 this.canciones.add(unaCancion);
         }

         public Cancion elegirCancion(int index){
                 return this.canciones.get(index);
         }

         public ArrayList<Cancion> getListaCanciones(){
                 return this.canciones;
         }

         public abstract double getPorcentajeMinimo();

         /* Este metodo debe ser modificado luego de establecer la verificacion de aciertos*/
         public void incrementarPuntajeActual(double valor){
                 this.puntajeActual = (this.puntajeActual + valor);
         }

         public double getPuntajeActual(){
                 return this.puntajeActual;
         }

         public double getPuntajeIdeal(){
                 return this.puntajeIdeal;
         }

         /*
          * Se establece el puntaje ideal del nivel, que se remite a la suma de puntajes ideales
          *  de cada canción que compone al nivel.
          */
         public void setPuntajeIdeal(){
                 int j = this.canciones.size();
                 for (int i=0; i<j; i++){
                         this.puntajeIdeal += this.elegirCancion(i).getPuntajeIdeal();
                 }
         }

         public double getPuntajeMinimo(){
                 return this.puntajeMinimo;
         }
         /*
          * Se establece el puntaje minimo del nivel, que se remite a la suma de puntajes
          * minimos de cada canción que compone al nivel.
          */
         public void setPuntajeMinimo(){
                 int j = this.canciones.size();
                 double valor = 0;
                 for (int i=0; i<j; i++){
                         valor = valor + this.elegirCancion(i).getPuntajeIdeal()* this.getPorcentajeMinimo();
                 }
                 this.puntajeMinimo = valor;
         }

         /* Se usa para preguntar si se ha superado el nivel */
         public boolean esSuficiente(){
                 if (this.puntajeActual >= this.puntajeMinimo) return true;
                 else return false;
         }


		public String getNombre() {
			return this.nombre;
		}
 }


