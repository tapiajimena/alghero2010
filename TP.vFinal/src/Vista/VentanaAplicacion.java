package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import javax.swing.JLabel;

import Controlador.AlgoHero2010;



/*
 * Ventana para jugar
 */

public class VentanaAplicacion extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar jJToolBarBar = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private Panel panel = null;
	private AlgoHero2010 controladorJuego = null;

	ImageIcon fondo = new ImageIcon("fondoPelotitas.jpg");
	JLabel etiqueta = new JLabel(fondo);

	/* Los botones que mostrarán las letras que serán usadas para jugar */
	String letra1 = "-";
	String letra2 = "-";
	String letra3 = "-";
	String letra4 = "-";
	String letra5 = "-";
	String letra6 = "-";

	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setBounds(new Rectangle(0, 0, 200, 33));
			jJToolBarBar.add(getJMenuItem());
			jJToolBarBar.add(getJMenuItem1());
		}
		return jJToolBarBar;
	}


	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText(" START ");
			jMenuItem.setBackground(Color.orange);
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
				}
			});
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					comenzar();
				}
			});
		}
		return jMenuItem;
	}

	private void comenzar(){
		System.out.println("actionPerformed()");

		this.controladorJuego.setSuperficieDeDibujo(getSuperficieDeDibujo());
		this.controladorJuego.comenzar();
	}

	private void detener() {
		this.controladorJuego.detener();

	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText(" END ");
			jMenuItem1.setBackground(Color.orange);
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					detener();
					cargarPuntaje();
				}
			});
		}
		return jMenuItem1;
	}

	@SuppressWarnings("deprecation")
	protected void cargarPuntaje() {
		this.hide();
		@SuppressWarnings("unused")
		VentanaPuntaje puntos = new VentanaPuntaje(controladorJuego);
	}


	private Panel getSuperficieDeDibujo() {
		if (panel == null) {
			panel = new Panel(10,10);
			panel.setBounds(new Rectangle(100, 42, 600, 600));
		}
		return panel;
	}


	public VentanaAplicacion(AlgoHero2010 unAlgoHero) {

		super();
		this.controladorJuego = unAlgoHero;
		initialize();
	}


	private void asignarLetras() {
		if (this.controladorJuego.getJuego().getIndiceNivel() == 0){
			this.letra1 = (""+ this.controladorJuego.getJuego().getLetras().get(0).getSimbolo());
			this.letra2 = (""+ this.controladorJuego.getJuego().getLetras().get(1).getSimbolo());
			this.letra3 = (""+ this.controladorJuego.getJuego().getLetras().get(2).getSimbolo());
		}else{
			if (this.controladorJuego.getJuego().getIndiceNivel() == 1){
				this.letra1 = (""+ this.controladorJuego.getJuego().getLetras().get(0).getSimbolo());
				this.letra2 = (""+ this.controladorJuego.getJuego().getLetras().get(1).getSimbolo());
				this.letra3 = (""+ this.controladorJuego.getJuego().getLetras().get(2).getSimbolo());
				this.letra4 = (""+ this.controladorJuego.getJuego().getLetras().get(3).getSimbolo());
			}else{
				this.letra1 = (""+ this.controladorJuego.getJuego().getLetras().get(0).getSimbolo());
				this.letra2 = (""+ this.controladorJuego.getJuego().getLetras().get(1).getSimbolo());
				this.letra3 = (""+ this.controladorJuego.getJuego().getLetras().get(2).getSimbolo());
				this.letra4 = (""+ this.controladorJuego.getJuego().getLetras().get(3).getSimbolo());
				this.letra5 = (""+ this.controladorJuego.getJuego().getLetras().get(4).getSimbolo());
				this.letra6 = (""+ this.controladorJuego.getJuego().getLetras().get(5).getSimbolo());
			}
		}
	}


	private void initialize() {
		this.setSize(1024, 768);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().add(getJContentPane());
		this.getContentPane().add(getJJToolBarBar());
		asignarLetras();
		agregarBotonesLetras();
		this.getContentPane().add(etiqueta);
		this.setTitle("AlgoHero 2010");


		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()");
				System.exit(NORMAL);
			}
		});
	}

	private void agregarBotonesLetras() {

				Button letra1 = new Button(this.letra1);
				Button letra2 = new Button(this.letra2);
				Button letra3 = new Button(this.letra3);
				Button letra4 = new Button(this.letra4);
				Button letra5 = new Button(this.letra5);
				Button letra6 = new Button(this.letra6);

				letra1.setBounds(100, 657, 50, 50);
                letra1.setForeground(Color.WHITE);
                letra1.setBackground(Color.black);

                letra2.setBounds(200, 657, 50, 50);
                letra2.setForeground(Color.WHITE);
                letra2.setBackground(Color.black);

                letra3.setBounds(300, 657, 50, 50);
                letra3.setForeground(Color.WHITE);
                letra3.setBackground(Color.black);

                letra4.setBounds(400, 657, 50, 50);
                letra4.setForeground(Color.WHITE);
                letra4.setBackground(Color.black);

                letra5.setBounds(500, 657, 50, 50);
                letra5.setForeground(Color.WHITE);
                letra5.setBackground(Color.black);

                letra6.setBounds(600, 657, 50, 50);
                letra6.setForeground(Color.WHITE);
                letra6.setBackground(Color.black);

				this.getContentPane().add(letra1);
				this.getContentPane().add(letra2);
				this.getContentPane().add(letra3);
				this.getContentPane().add(letra4);
				this.getContentPane().add(letra5);
				this.getContentPane().add(letra6);
	}


	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getSuperficieDeDibujo(), null);
		}
		return jContentPane;
	}

	public static void main(String[] args) {
		Panel panel = new Panel(10,10);
		panel.setBounds(new Rectangle(100, 42, 600, 600));

		final AlgoHero2010 elAlgoHero = new AlgoHero2010(panel);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaAplicacion thisClass = new VentanaAplicacion(elAlgoHero);
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"

