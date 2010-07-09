import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class VentanaPrincipal extends Frame {

    private static final long serialVersionUID = 1L;
    private Panel panel;
    private ArrayList<Pelotita> pelotitas = new ArrayList<Pelotita>();

    public VentanaPrincipal(){
        this.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(NORMAL);
            }
        });

        this.panel = new Panel();
        ImageIcon imagen = new ImageIcon("Presentacion.jpg");
        // Aca hay que tratar de poner la imagen de fondo.
        this.panel.setBackground(Color.WHITE);
        this.panel.setLayout(new GridBagLayout());
        add(this.panel, BorderLayout.CENTER);

        setSize(800, 600);
        setVisible(true);
    }

    private void addPelotita(int laColumna){

    	this.pelotitas.add(new Pelotita(this.panel, laColumna));

    }

    private void run() {

        while(true){
            for(Pelotita pelotita: this.pelotitas){
                pelotita.run();
                pelotita.dibujar();
                try {
                    Thread.sleep(20/pelotitas.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.addPelotita(0);
        ventanaPrincipal.addPelotita(1);
        ventanaPrincipal.addPelotita(2);
        ventanaPrincipal.run();

        //Como hago para lanzar otras pelotitas unos segundos dsp
        //de lanzar las anteriores?

        ventanaPrincipal.addPelotita(3);
        ventanaPrincipal.addPelotita(4);
        ventanaPrincipal.addPelotita(5);


    }

}