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

	Button nivelFacil = new Button("NIVEL  FACIL");
	Button nivelMedio = new Button("NIVEL  MEDIO");
	Button nivelDificil = new Button("NIVEL  DIFICIL");
	Button volverMenu = new Button(" volver Menu");

	ImageIcon fondo = new ImageIcon("niveles.jpg");
	JLabel etiqueta = new JLabel(fondo);

	public VentanaPrincipal() {
		super("AlgoHero 2010");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Se agrega la etiqueta que contiene la imagen al frame
		etiqueta.setSize(1050,500);

		nivelFacil.setBounds(720, 170, 130, 60);
		nivelFacil.setForeground(Color.WHITE);
		nivelFacil.setBackground(Color.gray);

		nivelMedio.setBounds(720, 320, 130, 60);
		nivelMedio.setForeground(Color.WHITE);
		nivelMedio.setBackground(Color.gray);

		nivelDificil.setBounds(720, 470, 130, 60);
		nivelDificil.setForeground(Color.WHITE);
		nivelDificil.setBackground(Color.gray);

		getContentPane().add(volverMenu);
		getContentPane().add(nivelFacil);
		getContentPane().add(nivelMedio);
		getContentPane().add(nivelDificil);
		getContentPane().add(etiqueta);
		this.setSize(1050, 500);
		this.pack();
		this.setVisible(true);
	}

}
