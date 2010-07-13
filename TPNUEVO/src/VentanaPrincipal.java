import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class VentanaPrincipal extends Frame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Panel panel;
	private Image imageIcon;
	private ArrayList<Pelotita> pelotitas = new ArrayList<Pelotita>();

	public VentanaPrincipal() {
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(NORMAL);
			}
		});

		this.panel = new Panel();
		this.imageIcon = new ImageIcon("Presentacion.jpg").getImage();

		// Aca hay que tratar de poner la imagen de fondo.
		this.panel.setLayout(new GridBagLayout());
		add(this.panel, BorderLayout.CENTER);

		setSize(800, 600);
		setVisible(true);
	}

	private void addPelotita(int laColumna) {
		this.pelotitas.add(new Pelotita(this.panel, laColumna));
	}

	public void run() {
		while(true) {
			//El for de antes puede tener problemas de concurrencia
			for(int i = 0; i < this.pelotitas.size(); ++i){
				this.dibujarFondo();
				this.recorrerPelotitas(this.pelotitas.get(i));
			}
		}
	}

	private void recorrerPelotitas(Pelotita pelotita) {
		pelotita.run();
		pelotita.dibujar();
		try {
			Thread.sleep(1 / pelotitas.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void dibujarFondo() {
		Graphics g = this.panel.getGraphics();
		g.drawImage(this.imageIcon, 0, 0, 800, 600, this);
	}

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Thread t = new Thread(ventanaPrincipal);

		ventanaPrincipal.addPelotita(0);
		ventanaPrincipal.addPelotita(1);
		ventanaPrincipal.addPelotita(2);

		//Este método lanza un hilo de ejecuión aparte, hace tareas de inicializacion y llama al run del objeto que le pase
		//Para eso el objeto debe implementar la interfaz runnable
		t.start();

		// Como hago para lanzar otras pelotitas unos segundos dsp
		// de lanzar las anteriores?

		//Espero 1000 ms y mando las otras 3
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ventanaPrincipal.addPelotita(3);
		ventanaPrincipal.addPelotita(4);
		ventanaPrincipal.addPelotita(5);

		//Espero 1000 ms más y mando otras 2
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ventanaPrincipal.addPelotita(3);
		ventanaPrincipal.addPelotita(4);
	}

}