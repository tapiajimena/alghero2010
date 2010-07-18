package Vista;

import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Action;

import Modelo.Juego;
import Modelo.Nivel;

/*
 * Ventana que muestra los tres niveles y da la opcion de elegir.
 */

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	Button nivelFacil = new Button("NIVEL  FACIL");
	Button nivelMedio = new Button("NIVEL  MEDIO");
	Button nivelDificil = new Button("NIVEL  DIFICIL");

	ImageIcon fondo = new ImageIcon("niveles.jpg");
	JLabel etiqueta = new JLabel(fondo);

	private Juego juego;

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


		nivelFacil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio el Nivel Fácil");
				cargarNivel(0);
			}
		});

		nivelMedio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio el Nivel Medio");
				cargarNivel(1);
			}
		});

		nivelDificil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio el Nivel Difícil");
				cargarNivel(2);
			}
		});


		getContentPane().add(nivelFacil);
		getContentPane().add(nivelMedio);
		getContentPane().add(nivelDificil);
		getContentPane().add(etiqueta);
		this.setSize(1050, 500);
		this.pack();
		this.setVisible(true);
	}

	public void cargarNivel(int numeroNivel) {
		getContentPane().remove(etiqueta);
		getContentPane().remove(nivelFacil);
		getContentPane().remove(nivelMedio);
		getContentPane().remove(nivelDificil);

		ImageIcon fondo = new ImageIcon("Presentación2.jpg");
		JLabel etiqueta = new JLabel(fondo);
		getContentPane().add(etiqueta);

		this.pack();
		this.setVisible(true);
	}

}
