package Vista;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import Controlador.ControladorJuego;
import Modelo.Nivel;
import Vista.VistaAplicacion;

public class VistaNivel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelCanciones;
	private ButtonGroup groupCancion;
	private VistaAplicacion escenario;
	private Nivel nivel;
	private ControladorJuego controlador;
	private JProgressBar progressBar;

	/*
	 * Recibe un conjunto de letras que se van a usar para jugar y se las coloca
	 * en el panel de opciones de letras
	 */
	private void cargarPanelCanciones() {
		panelCanciones.setLayout(new BoxLayout(panelCanciones, BoxLayout.Y_AXIS));
		panelCanciones.setBackground(Color.white);
		groupCancion = new ButtonGroup();
		if (this.nivel.getListaCanciones() != null)
			for (int i = 0; i < this.nivel.getListaCanciones().size(); i++) {
				JRadioButton cancion = new JRadioButton(this.nivel.getListaCanciones().get(i).getNombre());
				cancion.setBackground(Color.white);
				//cancion.setActionCommand(actionCommand);
				controlador.setControlador(cancion);
				groupCancion.add(cancion);
				panelCanciones.add(cancion);
			}
	}

	public void actualizarVista() {

		}


}
