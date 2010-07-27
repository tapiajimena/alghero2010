package Controlador;

import java.awt.event.KeyEvent;
import java.util.Date;

import Audio.Elemento;
import Modelo.Juego;
import Modelo.Letra;
import Modelo.Nota;

public class ControladorDeEventos implements KeyPressedObservador{

	//Atributos:

	private Juego elJuego;
	boolean yaProceseElEvento;


	//Métodos:

	public ControladorDeEventos(Juego unJuego){

		this.elJuego = unJuego;
		yaProceseElEvento = false;

	}


	private int obtenerIndiceDeTablaDeMapeoMasCercano(double unTiempoDeSimulacion){

		// Este método busca en la tabla de mapeo de elJuego el tiempo mas cercano de la columna
		// tiempo del mismo y lo devuelve.

		for(int i = 0 ; i < elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().size() ; i++){

			// Si encontré un segundo mayor al tiempo de simulación en la tabla de Mapeo
			if(elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(i) > unTiempoDeSimulacion){

				double diferenciaPorExceso =  (elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(i) - unTiempoDeSimulacion);

				if(i > 0){

					i = i - 1;
				}

				double diferenciaPorDefecto = (unTiempoDeSimulacion - elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(i));


				if(diferenciaPorExceso < diferenciaPorDefecto){

					return i + 1;

				}

					return i;

			}


		}

		return (this.elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().size()) - 1;

	}

	private boolean huboAciertoDeTecla(KeyEvent unArgumento, int unIndiceDeTablaDeMapeo){

		// Este método se fija si la tecla ingresada fue correcta

		Letra letraIngresada = new Letra(unArgumento.getKeyChar());
		Letra letraCorrecta = new Letra(elJuego.getLetras().get(elJuego.getContenedorIndexado().get(unIndiceDeTablaDeMapeo).getColumna()).getSimbolo());

		if(letraIngresada.getSimbolo() == letraCorrecta.getSimbolo())
			return true;

		return false;

	}

	public void keyPressed(KeyEvent argumento) {

		// En este método se debe resolver el tema de la interacción con
		// el usuario.


		if(this.yaProceseElEvento == false){

			// Obtenemos el tiempo de simulación actual en segundos contemplando el tiempo
			// que tarda en caer una pelotita (que es 3seg).
			long timeAux = System.currentTimeMillis();
			Date fechaActual = new Date(timeAux);
			double tiempoDeSimulacion = (double)(fechaActual.getTime() - this.elJuego.getFechaDeComienzo().getTime())/1000 - 3;

			// Solo acepto entradas que ocurran dsp de caer la primer pelotita.
			if(tiempoDeSimulacion >= -0.125){


				// Me fijo si la diferencia entre segundo mas cercano de la tabla al segundo ingresado es
				// es menor a la tolerancia permitida para considerarla como un acierto.

				int indiceDeTablaDeMapeo = obtenerIndiceDeTablaDeMapeoMasCercano(tiempoDeSimulacion);
				double segundoDeTabla = elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(indiceDeTablaDeMapeo);

				double diferenciaEntreIngresoYSegundoDeTabla = segundoDeTabla - tiempoDeSimulacion;

				// Si hubo un acierto temporal
				if(diferenciaEntreIngresoYSegundoDeTabla <= 0.125 && diferenciaEntreIngresoYSegundoDeTabla >= -0.125){


					//Ahora detectamos si hubo o no un acierto de tecla.

					if(huboAciertoDeTecla(argumento,indiceDeTablaDeMapeo) == true){

						System.out.println("BIEN");


						double key = this.elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(indiceDeTablaDeMapeo);
						Nota notaAux = (Nota) this.elJuego.getTablaDeMapeoIndexada().getTabla().get(key);


						double tiempoDeNegra = this.elJuego.getCancionIndexada().getTiempoDeNegra();
						int duracionAux = (int) (1000 * notaAux.getFigura().duracion(tiempoDeNegra));
						Elemento elementoAux = new Elemento(notaAux.getSonido().getIdentificador(),duracionAux);
						this.elJuego.getReferenciaAlReproductor().reproducir(elementoAux);

						//Se aumentan la cantidad de aciertos y el respectivo puntaje
						this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).aumetarContadorDeAciertos();
						this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).incrementarPuntajeActual();
						System.out.println("puntaje con aciertos:" + this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).getPuntajeActual());

					}else{

						System.out.println("MAL");

						//Se aumentan la cantidad de errores y no debe haber cambios en el puntaje actual
						this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).aumetarContadorDeErroress();
						System.out.println("puntaje con errores:" + this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).getPuntajeActual());


					}

				}else{

					System.out.println("MAL");

					//Se aumentan la cantidad de errores y no debe haber cambios en el puntaje actual
					this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).aumetarContadorDeErroress();
					System.out.println("puntaje con errores:" + this.elJuego.getNiveles().get((int)this.elJuego.getIndiceNivel()).getPuntajeActual());


				}

			}


			this.yaProceseElEvento = true;

		}else{

			this.yaProceseElEvento = false;

		}

	}
}




