package Modelo;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Icon;
//

 public abstract class Nivel {

         //Atributos:


         protected ArrayList<Letra> letras;
         protected int cantidadTeclas;
         protected ArrayList<Cancion> canciones;
         protected ArrayList<TablaDeMapeo> tablasDeMapeo;
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

         // Los contenedores son tablas con un matcheo tiempo - columna, esto
         // es, en que tiempo se debe lanzar una pelitita ubicada en una
         // determinada columna. Desde luego, que la columna a caer es función
         // de la nota a ejecutar y del nivel que se esta jugando, ya que los
         // niveles pueden variar sus columnas a usar.
         protected ArrayList<ArrayList<ElementoDeContenedor>> contenedores;



         //Métodos:

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

         public Cancion elegirCancion(int index){
                 return this.canciones.get(index);
         }

         public ArrayList<TablaDeMapeo> getTablasDeMapeo(){
             return this.tablasDeMapeo;
         }

         public ArrayList<Cancion> getListaCanciones(){
                 return this.canciones;
         }

         public ArrayList<ArrayList<ElementoDeContenedor>> getContenedores(){
             return this.contenedores;
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

		public abstract Cancion modificarVelocidad(Cancion unaCancion);


		public void cargarCancion(Cancion unaCancion){

			// Al momento de cargar una canción, cargamos su tabla de mapeo
			// correspondiente, que tiene los tiempos adecuados al nivel en
			// que estamos y el contenedor apropiado..

			unaCancion = modificarVelocidad(unaCancion);
			this.canciones.add(unaCancion);
			TablaDeMapeo unaTablaDeMapeo = new TablaDeMapeo(unaCancion);
			unaTablaDeMapeo.armarTabla();
			tablasDeMapeo.add(unaTablaDeMapeo);
			this.contenedores.add(armarContenedor(unaTablaDeMapeo));

		}


		private ArrayList<ElementoDeContenedor> armarContenedor(TablaDeMapeo unaTablaDeMapeo){

			ArrayList<ElementoDeContenedor> elContenedor = new ArrayList<ElementoDeContenedor>();

			for(int i=0; i< unaTablaDeMapeo.getArrayDeSegundos().size();i++){

				double segundoActual=unaTablaDeMapeo.getArrayDeSegundos().get(i);

				ElementoDePartitura elementoActual=unaTablaDeMapeo.getTabla().get((segundoActual));

				if(!elementoActual.getFigura().esSilencio()){

					if (elementoActual instanceof Nota){
						int identificadorActual=((Nota)elementoActual).getSonido().getIdentificador();
						ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
						elContenedor.add(struct);
					}

					if (elementoActual instanceof Acorde){

						ArrayList<Sonido> sonidosActuales = ((Acorde)elementoActual).getSonidos();
						for(int j=0;j<sonidosActuales.size();j++){
							Sonido elSonidoActual = sonidosActuales.get(j);
							int identificadorActual= elSonidoActual.getIdentificador();
							ElementoDeContenedor struct=new ElementoDeContenedor(segundoActual,asignarColumna(identificadorActual));
							elContenedor.add(struct);

						}
					}
				}
			}

			return elContenedor;

		}

		private int asignarColumna(int tipoDeSonido){

			Letra letra=tablaDeTeclas.get(tipoDeSonido);

			int columna=this.letras.indexOf(letra);

			return (columna);

		}


 }


