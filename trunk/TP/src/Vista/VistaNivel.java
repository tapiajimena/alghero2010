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

	public VistaNivel(Nivel nivelActual) {
		this.nivel = nivelActual;
	}


	/*
	 * Recibe un conjunto de canciones que se van a usar para jugar y se las coloca
	 * en el panel de opciones de canciones
	 */
	private void cargarPanelCanciones() {
		panelCanciones.setLayout(new BoxLayout(panelCanciones, BoxLayout.Y_AXIS));
		panelCanciones.setBackground(Color.white);
		groupCancion = new ButtonGroup();
		if (this.nivel.getListaCanciones() != null)
			for (int i = 0; i < this.nivel.getListaCanciones().size(); i++) {
				JRadioButton cancionAElegir = new JRadioButton(this.nivel.getListaCanciones().get(i).getNombre());
				cancionAElegir.setBackground(Color.white);
				cancionAElegir.setActionCommand(this.nivel.getListaCanciones().get(i).getNombre());
				controlador.setControlador(cancionAElegir,nivel.elegirCancion(i));
				groupCancion.add(cancionAElegir);
				panelCanciones.add(cancionAElegir);
			}
	}


	public void actualizarVista() {

		}


}
