package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.Timer;
import javax.swing.Action;

import Controlador.ControladorJuego;
import Controlador.SuperficieDeDibujo;
import Modelo.Juego;



public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego unJuego;
	private Timer timer;
	private int numeroNivel;

	Button nivelFacil = new Button();
	Button nivelMedio = new Button();
	Button nivelDificil = new Button();

	ImageIcon fondo = new ImageIcon("niveles.jpg");
	JLabel etiqueta = new JLabel(fondo);

	public VentanaPrincipal() {
		super("AlgoHero 2010");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Se agrega la etiqueta que contiene la imagen al frame
		etiqueta.setSize(1050,500);
		nivelFacil.setBounds(700, 150, 150, 80);
		nivelMedio.setBounds(700, 280, 150, 80);
		nivelDificil.setBounds(700, 410, 150, 80);
		getContentPane().add(nivelFacil);
		getContentPane().add(nivelMedio);
		getContentPane().add(nivelDificil);
		getContentPane().add(etiqueta);
		this.setSize(1050, 500);
		this.pack();
		this.setVisible(true);
	}

}
