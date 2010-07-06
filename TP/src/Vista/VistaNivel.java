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
		int nroVivosModelo = nivel.cantidadDePooglinsVivos();
		escenario.actualizar();
		actualizarProgress();
		while (nroVivosModelo > this.pooglins.size()) {
			Pooglin nuevoPooglin = nivel.getPooglinsVivos().get(
					this.pooglins.size());
			VistaPooglin vistaPooglin = new VistaPooglin(nuevoPooglin);
			controlador.setPooglin(vistaPooglin, nuevoPooglin);
			pooglins.add(vistaPooglin);
			escenario.add(vistaPooglin);
		}
		for (int i = 0; i < this.pooglins.size(); i++) {
			pooglins.get(i).actualizar();
			if ((pooglins.get(i).getPooglin().EstaSalvado())
					|| (pooglins.get(i).getPooglin().estaMuerto())) {
				pooglins.get(i).borrar();
				pooglins.remove(i);
			}
		}


}
