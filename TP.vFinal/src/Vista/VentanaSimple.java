package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controlador.ControladorJuego;


public class VentanaSimple extends Ventana {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public VentanaSimple(int ancho, int alto, ControladorJuego unControlador) {
		super(ancho, alto, unControlador);
		this.setTitle("Pelotas");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

}
