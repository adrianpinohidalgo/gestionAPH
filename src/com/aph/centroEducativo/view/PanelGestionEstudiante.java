package com.aph.centroEducativo.view;

import javax.swing.JPanel;

import com.aph.centroEducativo.ConnectionManager;
import com.aph.centroEducativo.controller.CursoController;
import com.aph.centroEducativo.controller.EstudianteController;
import com.aph.centroEducativo.controller.MateriaController;
import com.aph.centroEducativo.controller.SexoController;
import com.aph.centroEducativo.model.Curso;
import com.aph.centroEducativo.model.Estudiante;
import com.aph.centroEducativo.model.Materia;
import com.aph.centroEducativo.model.Sexo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelGestionEstudiante extends JPanel {
	PanelDatosPersonales datosPersonales = new PanelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelGestionEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
//		gridBagLayout.columnWeights = new double[] { 1.0 };
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("GESTIÓN DE ESTUDIANTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		GridBagLayout gridBagLayout_1 = (GridBagLayout) datosPersonales.getLayout();
//		gridBagLayout_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
//		gridBagLayout_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		gridBagLayout_1.columnWeights = new double[] { 1.0, 1.0 };
//		gridBagLayout_1.columnWidths = new int[] { 0, 0 };
		GridBagConstraints gbc_datosPersonales_1 = new GridBagConstraints();
		gbc_datosPersonales_1.fill = GridBagConstraints.BOTH;
		gbc_datosPersonales_1.insets = new Insets(0, 0, 5, 0);
		gbc_datosPersonales_1.gridx = 0;
		gbc_datosPersonales_1.gridy = 1;
		add(datosPersonales, gbc_datosPersonales_1);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		this.add(panel, gbc_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFirst();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weightx = 1.0;
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);

	}

	/**
	 * 
	 */
	public void findFirst() {
		Estudiante o = EstudianteController.loadFirst();
		datosPersonales.setId(o.getId());
		datosPersonales.setNombre(o.getNombre());
		datosPersonales.setApellido1(o.getApellido1());
		datosPersonales.setApellido2(o.getApellido2());
		datosPersonales.setDni(o.getDni());
		datosPersonales.setDireccion(o.getDireccion());
		datosPersonales.setEmail(o.getEmail());
		datosPersonales.setTelefono(o.getTelefono());
		datosPersonales.setImagen(o.getImagen());
		datosPersonales.setColor(o.getColor());
	}

	/**
	 * 
	 */
	private void save() {
		Estudiante o = new Estudiante();
		o.setId(datosPersonales.getId());
		o.setNombre(datosPersonales.getNombre());
		o.setApellido1(datosPersonales.getApellido1());
		o.setApellido2(datosPersonales.getApellido2());
		o.setImagen(datosPersonales.getImagen());
		o.setDni(datosPersonales.getDni());
		o.setDireccion(datosPersonales.getDireccion());
		o.setEmail(datosPersonales.getEmail());
		o.setTelefono(datosPersonales.getTelefono());
		o.setIdToplogiaSexo(datosPersonales.getSexo());
		o.setColor(datosPersonales.getColor());

		EstudianteController.update(o);
	}

}
