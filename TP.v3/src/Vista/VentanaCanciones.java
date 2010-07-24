package Vista;

import java.awt.BorderLayout;
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

	ImageIcon imagen = new ImageIcon("menuCanciones.jpg");
	JLabel aLabel = new JLabel(imagen);

    private class EscuchaSeleccion implements ActionListener {
    	private List opciones;

    	public EscuchaSeleccion(List opciones){
    		this.opciones = opciones;
    	}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cancion elegida "+ this.opciones.getSelectedItem());
			elAlgoHero.elegirCancion(this.opciones.getSelectedIndex());
		}
	}

	public VentanaCanciones(AlgoHero2010 algoHeroActual) {

		this.elAlgoHero = algoHeroActual;

		botonSeleccion.add( "cancion 1" );
        botonSeleccion.add( "cancion 2" );
        botonSeleccion.add( "cancion 3" );

        System.out.println("Cantidad de opciones " + botonSeleccion.getItemCount());

        botonSeleccion.setBounds(550, 270, 280, 40);

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
	    frame.getContentPane().add(aLabel, BorderLayout.CENTER);

	    frame.pack();
	    frame.setVisible(true);
	}

}
