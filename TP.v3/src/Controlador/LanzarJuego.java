package Controlador;

import java.awt.Rectangle;

import Vista.Panel;
import Vista.VistaPresentacion;

public class LanzarJuego {


	public static void main(String[] args) {

		Panel panel = new Panel(10,10);
		panel.setBounds(new Rectangle(100, 42, 600, 600));

		AlgoHero2010 controladorJuego = new AlgoHero2010(panel);
		VistaPresentacion laVista = new VistaPresentacion(controladorJuego);

		//controladorJuego.comenzar();


	}


}
