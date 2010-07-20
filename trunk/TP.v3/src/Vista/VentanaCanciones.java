package Vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaCanciones {

    JFrame frame = new JFrame("AlgoHero 2010");
    Choice botonSeleccion = new Choice();

	ImageIcon imagen = new ImageIcon("menuCanciones.jpg");
	JLabel aLabel = new JLabel(imagen);

	public VentanaCanciones() {

		botonSeleccion.addItem( "cancion 1" );
        botonSeleccion.addItem( "cancion 2" );
        botonSeleccion.addItem( "cancion 3" );

        botonSeleccion.setBounds(400, 70, 500, 40);

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
