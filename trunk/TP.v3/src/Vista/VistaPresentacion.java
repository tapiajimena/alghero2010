package Vista;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controlador.AlgoHero2010;

public class VistaPresentacion extends JFrame {

	private AlgoHero2010 elAlgoHero;

	/*	SE CREA UN OBJETO QUE PUEDA CONTENER LA IMAGEN. ESTA IMAGEN
		PUEDE SER UN ARCHIVO .GIF O .JPG. PARA ESTO UTILIZAMOS LA CLASE
		ImageIcon. AL INSTANCIAR, SE LE PARA COMO PARAMETRO UNA CADENA
		QUE ESPECIFICA EL NOMBRE O LA RUTA EN DONDE SE ENCUENTRA LA IMAGEN.
		Ej.:SI LA IMAGEN SE LLAMA "logotipo.gif", Y LA MISMA SE ENCUENTRA
		EN EL MISMO DIRECTORIO EN DONDE ESTOY HACIENDO MI PROGRAMA,
		INVOCO AL CONTRUCTOR DE LA SIGUIENTE MANERA:
		ImageIcon img = new ImageIcon("logotipo.gif").

	Ej.:EL OTRO CASO SERÍA, QUE LA MISMA IMAGEN "logotipo.gif", SE
		ENCUENTRE EN UN DIRECTORIO QUE NO SEA EN DONDE ESTA MI PROGRAMA.
		SUPONGAMOS QUE LA RUTA EN DONDE ESTA LA IMAGEN SEA:
		"C:/IMAGENES/logotipo.gif", PARA ELLO INVOCAMOS AL CONSTRUCTOR
		DE ImageIcon DE IGUAL MANERA QUE EN EL EJEMPLO ANTERIOR, SOLO QUE
		AHORA COLOCAMOS LA RUTA COMPLETA.
		ImageIcon img = new ImageIcon("C:/IMAGENES/logotipo.gif");
	*/

	private static final long serialVersionUID = 1L;
	ImageIcon imagen = new ImageIcon("Presentación2.jpg");

	/*	COMO LAS IMAGENES, SE DEBEN COLOCAR DENTRO DE COMPONENTES
		(ETIQUETAS, BOTONES, ETC..), LO QUE HARÉ SERÁ UNA ETIQUETA (LABEL)
		SIN TEXTO, (AUNQUE TAMBIÉN SE LE PUEDE AGREGAR TEXTO) Y EN ELLA
		COLOCO LA IMAGEN.
		PARA COLOCAR LA IMAGEN, LE PASAMOS COMO PARAMETRO A LA ETIQUETA
		EL OBJETO QUE CONTIENE LA IMAGEN.
	*/

	Button play = new Button("PLAY");
	JLabel etiqueta2 = new JLabel(imagen);

	public VistaPresentacion(AlgoHero2010 algoHeroActual)
	{
		super("Bienvenidos");

		this.elAlgoHero = algoHeroActual;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		play.setBackground(Color.black);
		play.setForeground(Color.orange);

		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se apretó el botón de play");
				cargarSiguiente();
			}
		});

		getContentPane().add(play,BorderLayout.PAGE_END);
		getContentPane().add(etiqueta2);

		getContentPane().setBackground(Color.black);

		this.pack();
		this.setVisible(true);
	}

	protected void cargarSiguiente(){

		this.hide();
		VentanaIngresos siguiente = new VentanaIngresos(elAlgoHero);


	}
}