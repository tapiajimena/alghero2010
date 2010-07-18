package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.Action;

import Controlador.ControladorJuego;
import Controlador.SuperficieDeDibujo;
import Modelo.Letra;

/*
 * Ventana que muestra los tres niveles y da la opcion de elegir.
 */

public class VentanaIngresos extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<Letra> letrasIngresadas;
	private int cantidadMaxima = 6;
	private int actual;

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

	Letra unaLetra;

	public VentanaIngresos() {
		super("AlgoHero 2010");

		this.letrasIngresadas = new ArrayList<Letra>();
		actual = 0;

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

		letraA.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la A");
				unaLetra = new Letra('A');
				ingresarLetra(unaLetra);
			}
		});
		letraB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la B");
				unaLetra = new Letra('B');
				ingresarLetra(unaLetra);
			}
		});
		letraC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la C");
				unaLetra = new Letra('C');
				ingresarLetra(unaLetra);

			}
		});
		letraD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la D");
				unaLetra = new Letra('D');
				ingresarLetra(unaLetra);

			}
		});
		letraE.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la E");
				unaLetra = new Letra('E');
				ingresarLetra(unaLetra);

			}
		});
		letraF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la F");
				unaLetra = new Letra('F');
				ingresarLetra(unaLetra);

			}
		});
		letraG.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la G");
				unaLetra = new Letra('G');
				ingresarLetra(unaLetra);
			}
		});
		letraH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la H");
				unaLetra = new Letra('H');
				ingresarLetra(unaLetra);
			}
		});
		letraI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la I");
				unaLetra = new Letra('I');
				ingresarLetra(unaLetra);
			}
		});
		letraJ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la J");
				unaLetra = new Letra('J');
				ingresarLetra(unaLetra);
			}
		});
		letraK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la K");
				unaLetra = new Letra('K');
				ingresarLetra(unaLetra);
			}
		});
		letraL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la L");
				unaLetra = new Letra('L');
				ingresarLetra(unaLetra);
			}
		});
		letraM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la M");
				unaLetra = new Letra('M');
				ingresarLetra(unaLetra);
			}
		});
		letraN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la N");
				unaLetra = new Letra('N');
				ingresarLetra(unaLetra);
			}
		});
		letraO.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la O");
				unaLetra = new Letra('O');
				ingresarLetra(unaLetra);
			}
		});
		letraP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la P");
				unaLetra = new Letra('P');
				ingresarLetra(unaLetra);
			}
		});
		letraQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la Q");
				unaLetra = new Letra('Q');
				ingresarLetra(unaLetra);
			}
		});
		letraR.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la R");
				unaLetra = new Letra('R');
				ingresarLetra(unaLetra);
			}
		});
		letraS.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la S");
				unaLetra = new Letra('S');
				ingresarLetra(unaLetra);
			}
		});
		letraT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la T");
				unaLetra = new Letra('T');
				ingresarLetra(unaLetra);
			}
		});
		letraU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la U");
				unaLetra = new Letra('U');
				ingresarLetra(unaLetra);
			}
		});
		letraV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la V");
				unaLetra = new Letra('V');
				ingresarLetra(unaLetra);
			}
		});
		letraW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la W");
				unaLetra = new Letra('W');
				ingresarLetra(unaLetra);
			}
		});
		letraX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la X");
				unaLetra = new Letra('X');
				ingresarLetra(unaLetra);
			}
		});
		letraY.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la Y");
				unaLetra = new Letra('Y');
				ingresarLetra(unaLetra);
			}
		});
		letraZ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se eligio la Z");
				unaLetra = new Letra('Z');
				ingresarLetra(unaLetra);
			}
		});



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


	/*
	 * Se ingresan las letras en el vector de letras designadas para jugar.
	 * Estas letras son las elegidas por el usuario.
	 */
	public void ingresarLetra(Letra unaLetra){
		boolean distinto = true;
		if(actual<6){
		if (actual > 0){
				for (int i=0; i<letrasIngresadas.size(); i++){
					if (letrasIngresadas.get(i).getSimbolo()== unaLetra.getSimbolo()) distinto = false;
				}
				if (distinto){
					letrasIngresadas.add(actual, unaLetra);
					actual++;
				}
			}else {
				letrasIngresadas.add(0, unaLetra);
				actual++;
				}
		}
		else{
			JOptionPane.showMessageDialog(this, " Ya ingresó las 6 letras" , "Atencion!",
					JOptionPane.WARNING_MESSAGE);
		}
	}


	/*
	 * Devuelve el vector con las 6 letras que elige el usuario para jugar.
	 */
	public ArrayList<Letra> getLetrasIngresadas(){
		return this.letrasIngresadas;
	}

}


