package Vista;

import java.awt.Color;

public class VistaPelota extends Circulo {

	public VistaPelota(int laColumna) {
		super(50);

		switch(laColumna){

			case 0:
				setColor(Color.RED);
				break;

			case 1:
				setColor(Color.BLUE);
				break;

			case 2:
				setColor(Color.GREEN);
				break;

			case 3:
				setColor(Color.YELLOW);
				break;

			case 4:
				setColor(Color.CYAN);
				break;

			case 5:
				setColor(Color.ORANGE);
				break;

		}

	}

}
