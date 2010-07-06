
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class Pelotita extends Panel implements Runnable{

	private static final long serialVersionUID = 1L;
	private boolean hayQuePintar;
	private int radio;
	private int incremento;
	private boolean estoyPintando;
	private int centroX;
	private int centroY;
	private int contador;

	public Pelotita(){
		this.radio = 40;
		this.incremento = 5;
		this.estoyPintando = false;
		this.hayQuePintar = false;
		this.contador = 0;
	}

	//@Override
	public void run() {

		if(this.estoyPintando)
			return;

		this.centroX= (int) (this.getWidth() / 6 ) * contador;
		this.centroY= (int) 0;
		this.hayQuePintar = true;
		this.estoyPintando = true;
		while(hayQuePintar){
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.centroY += this.incremento;

			if(this.centroY < 1 || this.centroY + this.radio > this.getHeight()){

				this.hayQuePintar = false;
				this.estoyPintando = false;

			}
			this.repaint();
		}

		contador = (contador + 1) % 6;
	}

	@Override
	public void paint(Graphics graphics){
		if(hayQuePintar){
			switch(contador){

			case 0:
				graphics.setColor(Color.BLUE);

				break;

			case 1:
				graphics.setColor(Color.RED);

				break;

			case 2:
				graphics.setColor(Color.GREEN);

				break;

			case 3:
				graphics.setColor(Color.BLACK);

				break;

			case 4:
				graphics.setColor(Color.YELLOW);

				break;

			case 5:
				graphics.setColor(Color.ORANGE);

				break;

			}

			graphics.fillOval(this.centroX, this.centroY, this.radio, this.radio);
		}
		//super.paint(graphics);
	}
}




