package Modelo;

/*
 * La funcion de esta clase es armar los elementos de tipo: Segundo-Columna
 * que usa el contenedor utilizado en la clase Nivel
 */

public class ElementoDeContenedor {

		private double segundo;
		private int columna;

		public ElementoDeContenedor(double unSegundo,int unaColumna){

			this.segundo=unSegundo;
			this.columna=unaColumna;

		}

		public double getSegundo(){
			return segundo;
		}

		public int getColumna(){
			return columna;
		}


	}






