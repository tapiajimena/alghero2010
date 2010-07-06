package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import Modelo.Juego;
import Modelo.Nivel;
import Modelo.NivelFacil;

public class VistaJuego extends JFrame{

	private static final long serialVersionUID = 1343048817996491590L;

	private JPanel panelNiveles;
	private ButtonGroup groupNiveles;
	private VistaNivel vista;
	private Juego juego;

	public VistaJuego() {
		//this.niveles[0] = new NivelFacil();
		//this.vista = new VistaNivel(this.niveles[1]);
		//barraMenu();
		super.getContentPane().add(vista);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.getContentPane().setLayout(
				new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
		super.getContentPane().setBackground(Color.black);
		super.setPreferredSize(new Dimension(1050, 500));
		super.pack();
	}

	private void cargarPanelNiveles() {
		panelNiveles.setLayout(new BoxLayout(panelNiveles, BoxLayout.Y_AXIS));
		panelNiveles.setBackground(Color.white);
		groupNiveles = new ButtonGroup();
		if (this.juego.getNiveles() != null)
			for (int i = 0; i < this.juego.getNiveles().size(); i++) {
				JRadioButton nivelAElegir = new JRadioButton(this.juego.getNiveles().get(i).getNombre());
				nivelAElegir.setBackground(Color.white);
				nivelAElegir.setActionCommand(this.juego.getNiveles().get(i).getNombre());
				//controlador.setControlador(nivelAElegir,nivel.elegirCancion(i));
				groupNiveles.add(nivelAElegir);
				panelNiveles.add(nivelAElegir);
			}
		}

}
