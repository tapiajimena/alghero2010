
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class Pelotita implements Runnable {

    private Panel panel;
    private int radio;
    private int incremento;
    private int centroX;
    private int centroY;
    private int columna;

    public Pelotita(Panel panel, int laColumna) {
        this.panel = panel;
        this.radio = 40;
        this.incremento = 5;
        this.columna = laColumna;
        this.centroX = (int) (this.panel.getWidth() / 6 ) * columna;
        this.centroY = (int) 0;
    }

    public Panel getPanel(){

    	return panel;

    }

    public int getRadio(){

    	return radio;

    }

    public int getIncremento(){

    	return incremento;

    }

    public int getCentroX(){

    	return centroX;

    }

    public int getCentroY(){

    	return centroY;

    }

    public void setPanel(Panel elPanel){

    	this.panel = elPanel;

    }

    public void setRadio(int elRadio){

    	this.radio = elRadio;

    }

    public void setIncremento(int elIncremento){

    	this.incremento = elIncremento;

    }

    public void setCentroX(int elCentroX){

    	this.centroX = elCentroX;

    }

    public void setCentroY(int elCentroY){

    	this.centroY = elCentroY;

    }

    public void run(){

        this.centroY += this.incremento;

    }

    public void dibujar() {

    	Graphics g = this.panel.getGraphics();

        //Esto es para no dejar la estela
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.panel.getWidth(), this.panel.getHeight());

        switch(columna){

        	case 0:
        		g.setColor(Color.RED);
        		break;

        	case 1:
        		g.setColor(Color.BLUE);
        		break;

        	case 2:
        		g.setColor(Color.GREEN);
        		break;

        	case 3:
        		g.setColor(Color.YELLOW);
        		break;

        	case 4:
        		g.setColor(Color.ORANGE);
        		break;

        	case 5:
        		g.setColor(Color.CYAN);
        		break;

        }

        g.fillOval(this.centroX, this.centroY, this.radio, this.radio);
    }

}






