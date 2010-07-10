package Vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.ImageIcon;

public class VentanaPrincipal extends Frame {

    private static final long serialVersionUID = 1L;
    private Panel panel;
    private LinkedList<Pelotita> pelotitas = new LinkedList<Pelotita>();

    public VentanaPrincipal(){

    	this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(NORMAL);
            }
        });

        this.panel = new Panel();

        // Tratar de poner una imagen de fondo.
        ImageIcon imagen = new ImageIcon("Presentacion.jpg");
        this.panel.setBackground(Color.WHITE);

        this.panel.setLayout(new GridBagLayout());
        add(this.panel, BorderLayout.CENTER);

        setSize(800, 600);
        setVisible(true);

    }

    public Panel getPanel(){

    	return panel;

    }

    public LinkedList<Pelotita> getPelotitas(){

    	return pelotitas;

    }

    public void setPanel(Panel elPanel){

    	this.panel = elPanel;

    }

    public void setPelotitas(LinkedList<Pelotita> lasPelotitas){

    	this.pelotitas = lasPelotitas;

    }

    private void addPelotita(int laColumna){

    	this.pelotitas.add(new Pelotita(this.panel, laColumna));

    }

    private void run() {

    	for(int i = 0 ; i < pelotitas.size() ; i++){
             pelotitas.get(i).run();
             pelotitas.get(i).dibujar();
             try {
                 Thread.sleep(20/pelotitas.size());
             }	 catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }

    public static void main(String[] args) {

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

        ventanaPrincipal.addPelotita(0);
        ventanaPrincipal.addPelotita(1);
        ventanaPrincipal.addPelotita(2);

        // Pedimos la fecha del comienzo del ciclo.
        long time = System.currentTimeMillis();
        Date fechaDeComienzo = new Date(time);

        while(true){

        	// Borramos las pelotitas que ya terminaron de dibujarse.
        	for(int i = 0 ; i < ventanaPrincipal.getPelotitas().size() ; i++){

        		if(((ventanaPrincipal.getPelotitas()).get(i)).getCentroY() > (ventanaPrincipal.getPanel()).getHeight())
        			(ventanaPrincipal.getPelotitas()).remove(i);

        	}

        	ventanaPrincipal.run();

        	time = System.currentTimeMillis();
            Date fechaAux = new Date(time);

            // Pasado 1 segundo de lanzar las primeras 3 pelotitas lanzo una
            // cuarta pelotita.

            if(fechaAux.getTime()==(1000 + fechaDeComienzo.getTime()))
            	ventanaPrincipal.addPelotita(3);

        }



    }

}