package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controlador.AlgoHero2010;

public class VentanaCanciones {

	private AlgoHero2010 elAlgoHero;

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


	protected void cargarSiguiente() {

		frame.hide();

		VentanaAplicacion siguiente = new VentanaAplicacion(elAlgoHero);


	}

}
