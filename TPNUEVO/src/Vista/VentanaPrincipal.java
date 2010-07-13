package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controlador.ControladorJuego;
import Controlador.SuperficieDeDibujo;


public class VentanaPrincipal extends Frame {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
		this.setTitle("Pelotas");
		this.setSize(400, 400);
		this.setResizable(false);
		panel = new Panel(222,242,controladorJuego);
		this.add(panel);

		Button boton = new Button();
		boton.setLabel("Boton");
		this.add(boton);

		this.setBackground(Color.green);
		panel.setBackground(Color.gray);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}
}
