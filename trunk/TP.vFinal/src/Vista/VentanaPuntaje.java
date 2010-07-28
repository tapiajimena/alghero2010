package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import Controlador.AlgoHero2010;
import Modelo.Letra;

public class VentanaPuntaje extends JFrame{

	private AlgoHero2010 elAlgoHero;
	private static final long serialVersionUID = 1L;
	ImageIcon imagen = new ImageIcon("fondoPuntaje1.jpg");

	Button play = new Button("PLAY AGAIN");
	Button next = new Button("NEXT LEVEL");
	Button restart = new Button("RESTART");

	private String contadorMal;
	private String contadorBien;
	private String puntajeFinal;
	private String nivelSuperado;

	private int indiceNivel;

	JLabel etiqueta2 = new JLabel(imagen);

	private Button terminarJuego = new Button(" EXIT ");

	@SuppressWarnings("deprecation")
	public VentanaPuntaje(AlgoHero2010 algoHeroActual){

		super("Felicitaciones!");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.elAlgoHero = algoHeroActual;
		this.indiceNivel = (int)this.elAlgoHero.getJuego().getIndiceNivel();

		/* Se hacen calcular estos puntajes para poder obtener resultados de performance
		 * del jugador.
		 */
		this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).setPuntajeIdeal();
		this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).setPuntajeMinimo(this.elAlgoHero.getJuego().getIndiceDeCancion());

		if (this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).esSuficiente() == true){
			this.nivelSuperado = ("Superó el Nivel");
		}else{
			this.nivelSuperado = ("No fue suficiente para superar el Nivel");
		}

		Button nivelSuperado = new Button(this.nivelSuperado);

		nivelSuperado.setBackground(Color.black);
		nivelSuperado.setForeground(Color.cyan);
		nivelSuperado.setBounds(620, 300, 250, 50);
		nivelSuperado.enable();


		this.puntajeFinal = (""+(int)this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).getPuntajeActual());
		Button puntajeFinal = new Button(this.puntajeFinal);

		puntajeFinal.setBackground(Color.black);
		puntajeFinal.setForeground(Color.pink);
		puntajeFinal.setBounds(550, 300, 50, 50);
		puntajeFinal.enable();


		this.contadorBien = (""+(int)this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).getCantidadAciertos());
		Button cantidadBien = new Button(this.contadorBien);

		cantidadBien.setBackground(Color.black);
		cantidadBien.setForeground(Color.pink);
		cantidadBien.setBounds(550, 100, 50, 50);
		cantidadBien.enable();

		this.contadorMal = (""+(int)this.elAlgoHero.getJuego().getNiveles().get(indiceNivel).getCantidadErrores());
		Button cantidadMal = new Button(this.contadorMal);

		cantidadMal.setBackground(Color.black);
		cantidadMal.setForeground(Color.pink);
		cantidadMal.setBounds(550, 160, 50, 50);
		cantidadMal.enable();

		play.setBackground(Color.black);
		play.setForeground(Color.orange);
		play.setBounds(250, 540, 150, 60);

		play.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se apretó el botón de play AGAIN");
				cargarPlayAgain();
			}
		});


		next.setBackground(Color.black);
		next.setForeground(Color.orange);
		next.setBounds(400, 540, 150, 60);

		next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se apretó el botón NEXT LEVEL");
				if (elAlgoHero.getJuego().getIndiceNivel() < 2) {
					cargarNextLevel();
				}else{
					mostrarMensaje();
				}
			}
		});


		restart.setBackground(Color.black);
		restart.setForeground(Color.orange);
		restart.setBounds(550, 540, 150, 60);

		restart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("se apretó el botón RESTART");
				cargarRestart();
			}
		});


        terminarJuego.setBounds(800, 650, 100, 40);
        terminarJuego.setBackground(Color.black);
        terminarJuego.setForeground(Color.green);

        terminarJuego.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                        System.out.println("se apretó EXIT");
        				System.exit(NORMAL);
                }
        });


		getContentPane().add(play);
		getContentPane().add(next);
		getContentPane().add(restart);
		getContentPane().add(terminarJuego);
		getContentPane().add(nivelSuperado);
		getContentPane().add(puntajeFinal);
		getContentPane().add(cantidadMal);
		getContentPane().add(cantidadBien);
		getContentPane().add(etiqueta2);

		getContentPane().setBackground(Color.black);

		this.pack();
		this.setVisible(true);
	}



	protected void mostrarMensaje() {
		JOptionPane.showMessageDialog(this, " Ha llegado al último nivel! Felicitaciones!" , "Atencion!",JOptionPane.WARNING_MESSAGE);
	}



	/* Se encarga de resetear el juego al principio dandole la oportunidad al jugador
	 * de elegir nuevamente las letras, el nivel y la canción que desea jugar.
	 */
	@SuppressWarnings("deprecation")
	protected void cargarRestart() {
		this.hide();

		Panel panel = new Panel(10,10);
		panel.setBounds(new Rectangle(100, 42, 600, 600));

		AlgoHero2010 controladorJuego = new AlgoHero2010(panel);
		@SuppressWarnings("unused")
		VentanaIngresos ventanaRestart = new VentanaIngresos(controladorJuego);
	}



	/* Se encarga de cargar el próximo nivel del juego.
	 * Se juegan con las mismas letras.
	 */
	@SuppressWarnings("deprecation")
	protected void cargarNextLevel() {
		this.hide();

		this.inicializarNivelSiguiente(elAlgoHero.getJuego().getIndiceNivel()+1,elAlgoHero.getJuego().getIndiceDeCancion(),elAlgoHero.getJuego().getLetras());
	}


	/* Se encarga de volver a cargar el nivel que se acaba de jugar para que el
	 * jugador pueda volver a jugarlo
	 */
	@SuppressWarnings("deprecation")
	protected void cargarPlayAgain(){

		this.hide();

		this.inicializarNivelSiguiente(elAlgoHero.getJuego().getIndiceNivel(),elAlgoHero.getJuego().getIndiceDeCancion(),elAlgoHero.getJuego().getLetras());

	}


	/* Se encarga de hacer la inicializacion del juego dependiendo de la opción elegida*/
	protected AlgoHero2010 inicializarNivelSiguiente(int numeroNivel, int numeroCancion, ArrayList<Letra> lasLetras){

		Panel panel = new Panel(10,10);
		panel.setBounds(new Rectangle(100, 42, 600, 600));

		final AlgoHero2010 controladorJuego = new AlgoHero2010(panel);

		controladorJuego.getJuego().setIndiceNivel(numeroNivel);
		controladorJuego.getJuego().setIndiceCancion(numeroCancion);
		controladorJuego.getJuego().setLetras(lasLetras);

	       SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                    VentanaAplicacion thisClass = new VentanaAplicacion(controladorJuego);
	                    thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                    thisClass.setVisible(true);
	            }
	    });


		return controladorJuego;
	}


}
