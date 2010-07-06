import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class VentanaPrincipal extends Frame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);

	}


	private static final long serialVersionUID = 1L;
	private Button botonIniciar = null;
	private Pelotita panelDeDibujo = null;

	/**
	 * This method initializes botonIniciar
	 *
	 * @return java.awt.Button
	 */
	private Button getBotonIniciar() {

		if (botonIniciar == null) {

			botonIniciar = new Button();

			botonIniciar.setLabel("Inicar simulación");

			botonIniciar.addActionListener(new java.awt.event.ActionListener(){

				public void actionPerformed(java.awt.event.ActionEvent e) {

					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					Thread thread = new Thread(panelDeDibujo);
					thread.start();

				}
			});
		}

		return botonIniciar;
	}

	/**
	 * This method initializes panelDeDibujo
	 *
	 * @return java.awt.Panel
	 */
	private Panel getPanelDeDibujo() {

		if (panelDeDibujo == null) {

			panelDeDibujo = new Pelotita();

			panelDeDibujo.setLayout(new GridBagLayout());

		}

		return panelDeDibujo;
	}

	/**
	 * This is the default constructor
	 */
	public VentanaPrincipal() {

		super();
		initialize();

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {

		this.setSize(800,600 );

		this.setTitle("Java2D - Ejemplo 2");

		this.add(getBotonIniciar(), BorderLayout.SOUTH);

		this.add(getPanelDeDibujo(), BorderLayout.CENTER);

		this.addWindowListener(new java.awt.event.WindowAdapter(){

			public void windowClosing(java.awt.event.WindowEvent e) {

				System.out.println("windowClosing()");
				System.exit(NORMAL);

			}
		});
	}

}
