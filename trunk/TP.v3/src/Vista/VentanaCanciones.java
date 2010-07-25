package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import Controlador.AlgoHero2010;

public class VentanaCanciones {

	private AlgoHero2010 elAlgoHero;
	private JPanel jContentPane = null;
	private JToolBar jJToolBarBar = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private Panel panel = null;
	private AlgoHero2010 controladorJuego = null;

    JFrame frame = new JFrame("AlgoHero 2010");
    List botonSeleccion = new List();

    Button comenzarJuego = new Button(" Start Playing ");

	ImageIcon imagen = new ImageIcon("menuCanciones1.jpg");
	JLabel aLabel = new JLabel(imagen);

	public VentanaCanciones(AlgoHero2010 algoHeroActual) {

		this.elAlgoHero = algoHeroActual;

        comenzarJuego.setBounds(800, 650, 100, 40);
        comenzarJuego.setBackground(Color.black);
        comenzarJuego.setForeground(Color.orange);

        comenzarJuego.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("se apretó Start Playing");
                        cargarSiguiente();
                }
        });

		botonSeleccion.add( "cancion 1" );
        botonSeleccion.add( "cancion 2" );
        botonSeleccion.add( "cancion 3" );

        System.out.println("Cantidad de opciones " + botonSeleccion.getItemCount());

        botonSeleccion.setBounds(560, 200, 280, 40);

        class EscuchaSeleccion implements ActionListener {
        	private List opciones;

        	public EscuchaSeleccion(List opciones){
        		this.opciones = opciones;
        	}
    		public void actionPerformed(ActionEvent e) {
    			System.out.println("Cancion elegida "+ this.opciones.getSelectedItem());
    			elAlgoHero.elegirCancion(this.opciones.getSelectedIndex());
    		}
    	}

        botonSeleccion.addActionListener(new EscuchaSeleccion(botonSeleccion));


        WindowListener l = new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
		    System.exit(0);
	        }
	    };

	    frame.addWindowListener(l);

	    /* Agrego el boton y la imagen a la ventana.
	     * Todavia no se como hacer para que se superpongan
	     */
	    frame.getContentPane().add(botonSeleccion);
	    frame.getContentPane().add(comenzarJuego);
	    frame.getContentPane().add(aLabel, BorderLayout.CENTER);

	    frame.pack();
	    frame.setVisible(true);
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


	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setBounds(new Rectangle(0, 0, 200, 33));
			jJToolBarBar.add(getJMenuItem());
			jJToolBarBar.add(getJMenuItem1());
		}
		return jJToolBarBar;
	}


	private void comenzar(){
		System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
		this.controladorJuego = this.elAlgoHero;
		this.controladorJuego.comenzar();
	}

	private void detener() {
		this.controladorJuego.detener();

	}


	protected void cargarSiguiente() {
		frame.getContentPane().remove(botonSeleccion);
		frame.getContentPane().remove(comenzarJuego);
		frame.getContentPane().remove(aLabel);

		ImageIcon fondo = new ImageIcon("fondoPelotitas.jpg");
		JLabel etiqueta = new JLabel(fondo);

		frame.getContentPane().add(getJJToolBarBar());
		frame.getContentPane().add(etiqueta);

	    frame.pack();
	    frame.setVisible(true);

	}

}
