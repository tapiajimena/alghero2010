package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Controlador.AlgoHero2010;
import Modelo.Letra;

/*
 * Ventana que muestra los tres niveles y da la opcion de elegir.
 */

public class VentanaIngresos extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<Letra> letrasIngresadas;
	private int cantidadMaxima = 6;
	private int actual;
	private AlgoHero2010 elAlgoHero;

	Button continua = new Button ("NEXT");

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

	ImageIcon fondo = new ImageIcon("fondoLetras1.jpg");
	JLabel etiqueta = new JLabel(fondo);

	Letra unaLetra;

	public VentanaIngresos(AlgoHero2010 algoHeroActual) {
		super("AlgoHero 2010");

		this.elAlgoHero = algoHeroActual;

		this.letrasIngresadas = new ArrayList<Letra>();
		actual = 0;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		continua.setBounds(800, 650, 100, 40);
		continua.setBackground(Color.black);
		continua.setForeground(Color.orange);

		continua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se apretó NEXT");
				cargarSiguiente();
			}
		});

		letraA.setBounds(300, 190, 50, 50);
		letraA.setForeground(Color.WHITE);
		letraA.setBackground(Color.black);

		letraB.setBounds(350, 190, 50, 50);
		letraB.setForeground(Color.WHITE);
		letraB.setBackground(Color.black);

		letraC.setBounds(400, 190, 50, 50);
		letraC.setForeground(Color.WHITE);
		letraC.setBackground(Color.black);

		letraD.setBounds(450, 190, 50, 50);
		letraD.setForeground(Color.WHITE);
		letraD.setBackground(Color.black);

		letraE.setBounds(500, 190, 50, 50);
		letraE.setForeground(Color.WHITE);
		letraE.setBackground(Color.black);

		letraF.setBounds(550, 190, 50, 50);
		letraF.setForeground(Color.WHITE);
		letraF.setBackground(Color.black);

		letraG.setBounds(600, 190, 50, 50);
		letraG.setForeground(Color.WHITE);
		letraG.setBackground(Color.black);

		letraH.setBounds(300, 240, 50, 50);
		letraH.setForeground(Color.WHITE);
		letraH.setBackground(Color.black);

		letraI.setBounds(350, 240, 50, 50);
		letraI.setForeground(Color.WHITE);
		letraI.setBackground(Color.black);

		letraJ.setBounds(400, 240, 50, 50);
		letraJ.setForeground(Color.WHITE);
		letraJ.setBackground(Color.black);

		letraK.setBounds(450, 240, 50, 50);
		letraK.setForeground(Color.WHITE);
		letraK.setBackground(Color.black);

		letraL.setBounds(500, 240, 50, 50);
		letraL.setForeground(Color.WHITE);
		letraL.setBackground(Color.black);

		letraM.setBounds(550, 240, 50, 50);
		letraM.setForeground(Color.WHITE);
		letraM.setBackground(Color.black);

		letraN.setBounds(600, 240, 50, 50);
		letraN.setForeground(Color.WHITE);
		letraN.setBackground(Color.black);

		letraO.setBounds(300, 290, 50, 50);
		letraO.setForeground(Color.WHITE);
		letraO.setBackground(Color.black);

		letraP.setBounds(350, 290, 50, 50);
		letraP.setForeground(Color.WHITE);
		letraP.setBackground(Color.black);

		letraQ.setBounds(400, 290, 50, 50);
		letraQ.setForeground(Color.WHITE);
		letraQ.setBackground(Color.black);

		letraR.setBounds(450, 290, 50, 50);
		letraR.setForeground(Color.WHITE);
		letraR.setBackground(Color.black);

		letraS.setBounds(500, 290, 50, 50);
		letraS.setForeground(Color.WHITE);
		letraS.setBackground(Color.black);

		letraT.setBounds(550, 290, 50, 50);
		letraT.setForeground(Color.WHITE);
		letraT.setBackground(Color.black);

		letraU.setBounds(600, 290, 50, 50);
		letraU.setForeground(Color.WHITE);
		letraU.setBackground(Color.black);

		letraV.setBounds(350, 340, 50, 50);
		letraV.setForeground(Color.WHITE);
		letraV.setBackground(Color.black);

		letraW.setBounds(400, 340, 50, 50);
		letraW.setForeground(Color.WHITE);
		letraW.setBackground(Color.black);

		letraX.setBounds(450, 340, 50, 50);
		letraX.setForeground(Color.WHITE);
		letraX.setBackground(Color.black);

		letraY.setBounds(500, 340, 50, 50);
		letraY.setForeground(Color.WHITE);
		letraY.setBackground(Color.black);

		letraZ.setBounds(550, 340, 50, 50);
		letraZ.setForeground(Color.WHITE);
		letraZ.setBackground(Color.black);

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


		getContentPane().add(continua);

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
		this.pack();
		this.setVisible(true);


		}


	protected void cargarSiguiente() {

		this.hide();

		VentanaPrincipal siguiente = new VentanaPrincipal(elAlgoHero);

	}


	/*
	 * Se ingresan las letras en el vector de letras designadas para jugar.
	 * Estas letras son las elegidas por el usuario.
	 */
	public void ingresarLetra(Letra unaLetra){
		boolean distinto = true;
		if(actual<cantidadMaxima){
		if (actual > 0){
				for (int i=0; i<letrasIngresadas.size(); i++){
					if (letrasIngresadas.get(i).getSimbolo()== unaLetra.getSimbolo()) distinto = false;
				}
				if (distinto){
					letrasIngresadas.add(actual, unaLetra);
					this.elAlgoHero.getJuego().getLetras().add(actual, unaLetra);
					actual++;
				}
			}else {
				letrasIngresadas.add(0, unaLetra);
				this.elAlgoHero.getJuego().getLetras().add(actual, unaLetra);
				actual++;
				}
		}
		else{
			JOptionPane.showMessageDialog(this, " Ya ingresó las 6 letras con las que va a jugar" , "Atencion!",
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


