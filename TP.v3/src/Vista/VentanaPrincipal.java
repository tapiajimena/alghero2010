package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.JProgressBar;

import javax.swing.Timer;
import javax.swing.plaf.basic.BasicButtonListener;

import com.sun.media.sound.Toolkit;


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

	private JProgressBar progressBar;
	private Timer timer;

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


	/*
	 * Se encarga de cargar la vista dependiendo del nivel
	 */
	public void cargarNivel(int numeroNivel) {

		getContentPane().remove(etiqueta);
		getContentPane().remove(nivelFacil);
		getContentPane().remove(nivelMedio);
		getContentPane().remove(nivelDificil);

		final Button botonStart = new Button("Load");
		botonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
            	timer.start();
            	cargarsiguiente();
        }});

		botonStart.setBounds(430, 650, 100, 30);
		botonStart.setBackground(Color.BLACK);
		botonStart.setForeground(Color.white);

		progressBar = new JProgressBar(0,10);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	for (int i=0; i<1000; i++){
            		progressBar.setValue(i);
            	}
            }
        });

		getContentPane().add(progressBar, BorderLayout.PAGE_END);
		getContentPane().add(botonStart);

		if(numeroNivel == 0) {
			ImageIcon fondo = new ImageIcon("fondoNivelF.jpg");
			JLabel etiqueta2 = new JLabel(fondo);
			getContentPane().add(etiqueta2);
		}
		if(numeroNivel == 1) {
			ImageIcon fondo = new ImageIcon("fondoNivelM.jpg");
			JLabel etiqueta2 = new JLabel(fondo);
			getContentPane().add(etiqueta2);
		}
		if(numeroNivel == 2) {
			ImageIcon fondo = new ImageIcon("fondoNivelD.jpg");
			JLabel etiqueta2 = new JLabel(fondo);
			getContentPane().add(etiqueta2);
		}

		this.pack();
		this.setVisible(true);
	}


	protected void cargarsiguiente() {

		this.hide();

		VentanaCanciones siguiente = new VentanaCanciones();
	}

}
