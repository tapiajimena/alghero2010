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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import Modelo.Juego;
import Modelo.Nivel;

public class VistaJuego extends JFrame{

	private static final long serialVersionUID = 1343048817996491590L;

	private Nivel niveles[];
	private VistaNivel vista;

	public VistaJuego() {
		//this.nivel = CreadorNiveles.crearNivel();
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

}
