package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controlador.AlgoHero2010;

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

	private AlgoHero2010 elAlgoHero;

	public VentanaPrincipal(AlgoHero2010 algoHeroActual) {
		super("AlgoHero 2010");

		this.elAlgoHero = algoHeroActual;

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
				elAlgoHero.elegirNivel(0);
			}
		});

		nivelMedio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio el Nivel Medio");
				cargarNivel(1);
				elAlgoHero.elegirNivel(1);
			}
		});

		nivelDificil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio el Nivel Difícil");
				cargarNivel(2);
				elAlgoHero.elegirNivel(2);
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
            	cargarsiguiente();
        }});

		botonStart.setBounds(430, 650, 100, 30);
		botonStart.setBackground(Color.BLACK);
		botonStart.setForeground(Color.white);

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


	@SuppressWarnings("deprecation")
	protected void cargarsiguiente() {

		this.hide();

		@SuppressWarnings("unused")
		VentanaCanciones siguiente = new VentanaCanciones(elAlgoHero);
	}

}
