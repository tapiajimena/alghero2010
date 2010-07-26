package Vista;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import javax.swing.JLabel;


import Controlador.AlgoHero2010;

import java.awt.GridBagConstraints;


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
	private JPanel jPanelEstado = null;
	private JLabel jLabel = null;

	ImageIcon fondo = new ImageIcon("fondoPelotitas.jpg");
	JLabel etiqueta = new JLabel(fondo);

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
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
		System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
		this.controladorJuego = new AlgoHero2010(getSuperficieDeDibujo());
		this.controladorJuego.comenzar();
	}

	private void detener() {
		this.controladorJuego.detener();

	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText(" STOP ");
			jMenuItem1.setBackground(Color.orange);
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					detener();
				}
			});
		}
		return jMenuItem1;
	}

	private Panel getSuperficieDeDibujo() {
		if (panel == null) {
			panel = new Panel(10,10);
			panel.setBounds(new Rectangle(100, 42, 600, 600));
		}
		return panel;
	}


	public VentanaAplicacion() {
		super();
		initialize();
	}


	private void initialize() {
		this.setSize(1024, 768);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().add(getJContentPane());
		this.getContentPane().add(getJJToolBarBar());
		this.getContentPane().add(etiqueta);
		this.setTitle("AlgoHero 2010");


		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
				System.exit(NORMAL);
			}
		});
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
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaAplicacion thisClass = new VentanaAplicacion();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"

