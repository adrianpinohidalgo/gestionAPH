package com.aph.centroEducativo.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	public MainWindow() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(800, 600));

		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel pnl = new JPanel();
		tabbedPane.add("Curso", new CursoView());

		JPanel pnl2 = new JPanel();
		tabbedPane.add("Estudiante", new EstudianteView());

		JPanel pnl3 = new JPanel();
		tabbedPane.add("Materia", new MateriaView());

		JPanel pnl4 = new JPanel();
		tabbedPane.add("Profesor", new ProfesorView());

		JPanel pnl5 = new JPanel();
		tabbedPane.add("Valoración Materia", new ValoracionView());

		JPanel pnl6 = new JPanel();
		tabbedPane.add("Gestión Estudiante", new PanelGestionEstudiante());

		this.setContentPane(tabbedPane);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		mw.setBackground(Color.GRAY);
		mw.setVisible(true);
	}

}