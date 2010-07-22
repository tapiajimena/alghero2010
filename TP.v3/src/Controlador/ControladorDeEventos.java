package Controlador;

import java.awt.event.KeyEvent;
import java.util.Date;

import Modelo.Juego;

public class ControladorDeEventos implements KeyPressedObservador{


	private Juego elJuego;


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


	public ControladorDeEventos(Juego unJuego){

		this.elJuego = unJuego;

	}


	public void keyPressed(KeyEvent arg0) {

		// En este método se debe resolver el tema de la interacción con
		// el usuario.

		// Obtenemos el tiempo de simulación actual en segundos contemplando el tiempo
		// que tarda en caer una pelotita (que es 3seg).
		long timeAux = System.currentTimeMillis();
		Date fechaActual = new Date(timeAux);
		double tiempoDeSimulacion = (double)(fechaActual.getTime() - this.elJuego.getFechaDeComienzo().getTime())/1000 - 3;

		// Si el tiempo dio negativo, es decir, que el usuario apreto una tecla antes de que
		// termine de caer la primer pelotita, forzamos a cero el tiempo de Simulacion.
		if(tiempoDeSimulacion < 0)
			tiempoDeSimulacion = 0;

		// Me fijo si la diferencia entre segundo mas cercano de la tabla al segundo ingresado es
		// es menor a la tolerancia permitida para considerarla como un acierto.

		double segundoDeTabla = elJuego.getTablaDeMapeoIndexada().getArrayDeSegundos().get(obtenerIndiceDeTablaDeMapeoMasCercano(tiempoDeSimulacion));

		double diferenciaEntreIngresoYSegundoDeTabla = segundoDeTabla - tiempoDeSimulacion;

		// Si hubo un acierto temporal
		if(diferenciaEntreIngresoYSegundoDeTabla <= 0.15 && diferenciaEntreIngresoYSegundoDeTabla >= -0.15){

			System.out.println("BIEN");

			// Nos fijamos si hubo un acierto de tecla

			elJuego.setHacerSonarPelota(true);
			elJuego.setIndiceDePelotaASonar(obtenerIndiceDeTablaDeMapeoMasCercano(tiempoDeSimulacion));


		}else{


			System.out.println("MAL");

		}





	}


}
