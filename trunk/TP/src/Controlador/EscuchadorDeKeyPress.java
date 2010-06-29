package Controlador;

import Controlador.KeyPressedObservador;
import java.awt.event.KeyEvent;

public class EscuchadorDeKeyPress implements KeyPressedObservador {

	private Pelota pelota;

	public EscuchadorDeKeyPress(Pelota pelota){
		this.pelota = pelota;
	}

	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			pelota.moverEnY(5);
			break;

		case KeyEvent.VK_LEFT:
			pelota.moverEnX(-5);
			break;

		case KeyEvent.VK_UP:
			pelota.moverEnY(-5);
			break;

		case KeyEvent.VK_RIGHT:
			pelota.moverEnX(5);
			break;

		default:
			System.out.println("No apreto una tecla posta: " + event.getKeyCode());
			break;
		}
	}

}
