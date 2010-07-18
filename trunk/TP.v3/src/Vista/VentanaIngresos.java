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

/*
 * Ventana que muestra los tres niveles y da la opcion de elegir.
 */

public class VentanaIngresos extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego unJuego;
	private Timer timer;
	private int numeroNivel;

	Button letraA = new Button("A");
	Button letraB = new Button("B");
	Button letraC = new Button("C");
	Button letraD = new Button("D");
	Button letraE = new Button("E");
	Button letraF = new Button("F");
	Button letraG = new Button("G");
	Button letraH = new Button("H");
	Button letraI = new Button("I");
	Button letraJ = new Button("J");
	Button letraK = new Button("K");
	Button letraL = new Button("L");
	Button letraM = new Button("M");
	Button letraN = new Button("N");
	Button letraO = new Button("O");
	Button letraP = new Button("P");
	Button letraQ = new Button("Q");
	Button letraR = new Button("R");
	Button letraS = new Button("S");
	Button letraT = new Button("T");
	Button letraU = new Button("U");
	Button letraV = new Button("V");
	Button letraW = new Button("W");
	Button letraX = new Button("X");
	Button letraY = new Button("Y");
	Button letraZ = new Button("Z");

	Button volverMenu = new Button(" volver Menu");

	ImageIcon fondo = new ImageIcon("fondoLetras.jpg");
	JLabel etiqueta = new JLabel(fondo);

	public VentanaIngresos() {
		super("AlgoHero 2010");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Se agrega la etiqueta que contiene la imagen al frame
		etiqueta.setSize(1050,500);

		letraA.setBounds(300, 140, 25, 25);
		letraB.setBounds(325, 140, 25, 25);
		letraC.setBounds(350, 140, 25, 25);
		letraD.setBounds(375, 140, 25, 25);
		letraE.setBounds(400, 140, 25, 25);
		letraF.setBounds(425, 140, 25, 25);
		letraG.setBounds(450, 140, 25, 25);
		letraH.setBounds(475, 140, 25, 25);
		letraI.setBounds(500, 140, 25, 25);
		letraJ.setBounds(525, 140, 25, 25);
		letraK.setBounds(550, 140, 25, 25);
		letraL.setBounds(325, 165, 25, 25);
		letraM.setBounds(350, 165, 25, 25);
		letraN.setBounds(375, 165, 25, 25);
		letraO.setBounds(400, 165, 25, 25);
		letraP.setBounds(425, 165, 25, 25);
		letraQ.setBounds(450, 165, 25, 25);
		letraR.setBounds(475, 165, 25, 25);
		letraS.setBounds(500, 165, 25, 25);
		letraT.setBounds(525, 165, 25, 25);
		letraU.setBounds(350, 190, 25, 25);
		letraV.setBounds(375, 190, 25, 25);
		letraW.setBounds(400, 190, 25, 25);
		letraX.setBounds(425, 190, 25, 25);
		letraY.setBounds(450, 190, 25, 25);
		letraZ.setBounds(475, 190, 25, 25);

		getContentPane().add(letraA);
		getContentPane().add(letraB);
		getContentPane().add(letraC);
		getContentPane().add(letraD);
		getContentPane().add(letraE);
		getContentPane().add(letraF);
		getContentPane().add(letraG);
		getContentPane().add(letraH);
		getContentPane().add(letraI);
		getContentPane().add(letraJ);
		getContentPane().add(letraK);
		getContentPane().add(letraL);
		getContentPane().add(letraM);
		getContentPane().add(letraN);
		getContentPane().add(letraO);
		getContentPane().add(letraP);
		getContentPane().add(letraQ);
		getContentPane().add(letraR);
		getContentPane().add(letraS);
		getContentPane().add(letraT);
		getContentPane().add(letraU);
		getContentPane().add(letraV);
		getContentPane().add(letraW);
		getContentPane().add(letraX);
		getContentPane().add(letraY);
		getContentPane().add(letraZ);

		getContentPane().add(etiqueta);
		this.setSize(1050, 500);
		this.pack();
		this.setVisible(true);
	}

}
