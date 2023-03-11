package com.aph.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import com.aph.centroEducativo.controller.CursoController;
import com.aph.centroEducativo.controller.EstudianteController;
import com.aph.centroEducativo.model.Curso;
import com.aph.centroEducativo.model.Estudiante;

import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstudianteView extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;

	/**
	 * Create the panel.
	 */
	public EstudianteView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		add(contentPane, gbc_contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_2 = new JLabel("GESTIÓN DE ESTUDIANTES");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 15, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setEditable(false);
		jtfId.setColumns(10);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		contentPane.add(jtfId, gbc_jtfId);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		contentPane.add(jtfNombre, gbc_jtfNombre);

		JLabel lblNewLabel_3 = new JLabel("Primer Apellido:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfApellido1 = new JTextField();
		jtfApellido1.setColumns(10);
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		contentPane.add(jtfApellido1, gbc_jtfApellido1);

		JLabel lblNewLabel_3_1 = new JLabel("Segundo Apellido:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 4;
		contentPane.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);

		jtfApellido2 = new JTextField();
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		contentPane.add(jtfApellido2, gbc_jtfApellido2);

		JLabel lblNewLabel_3_2 = new JLabel("DNI:");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 0;
		gbc_lblNewLabel_3_2.gridy = 5;
		contentPane.add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);

		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		contentPane.add(jtfDni, gbc_jtfDni);

		JLabel lblNewLabel_3_3 = new JLabel("Dirección:");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3.gridx = 0;
		gbc_lblNewLabel_3_3.gridy = 6;
		contentPane.add(lblNewLabel_3_3, gbc_lblNewLabel_3_3);

		jtfDireccion = new JTextField();
		jtfDireccion.setColumns(10);
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		contentPane.add(jtfDireccion, gbc_jtfDireccion);

		JLabel lblNewLabel_3_4 = new JLabel("Email:");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3_4 = new GridBagConstraints();
		gbc_lblNewLabel_3_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_4.gridx = 0;
		gbc_lblNewLabel_3_4.gridy = 7;
		contentPane.add(lblNewLabel_3_4, gbc_lblNewLabel_3_4);

		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		contentPane.add(jtfEmail, gbc_jtfEmail);

		JLabel lblNewLabel_3_5 = new JLabel("Teléfono:");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3_5 = new GridBagConstraints();
		gbc_lblNewLabel_3_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_5.gridx = 0;
		gbc_lblNewLabel_3_5.gridy = 8;
		contentPane.add(lblNewLabel_3_5, gbc_lblNewLabel_3_5);

		jtfTelefono = new JTextField();
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		contentPane.add(jtfTelefono, gbc_jtfTelefono);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPrimerReg = new JButton("<<");
		btnPrimerReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante();
				Estudiante e1 = EstudianteController.findFirst();
				jtfId.setText(String.valueOf(e1.getId()));
				jtfNombre.setText(e1.getNombre());
				jtfApellido1.setText(e1.getApellido1());
				jtfApellido2.setText(e1.getApellido2());
				jtfDni.setText(e1.getDni());
				jtfDireccion.setText(e1.getDireccion());
				jtfEmail.setText(e1.getEmail());
				jtfTelefono.setText(e1.getTelefono());
			}
		});
		panel.add(btnPrimerReg);

		JButton btnAnteriorReg = new JButton("<");
		btnAnteriorReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante(Integer.parseInt(jtfId.getText()), jtfNombre.getText(),
						jtfApellido1.getText(), jtfApellido2.getText(), jtfDni.getText(), jtfDireccion.getText(),
						jtfEmail.getText(), jtfTelefono.getText());
				Estudiante e1 = EstudianteController.previous(e0);
				if (e1 != null) {
					jtfId.setText(String.valueOf(e1.getId()));
					jtfNombre.setText(e1.getNombre());
					jtfApellido1.setText(e1.getApellido1());
					jtfApellido2.setText(e1.getApellido2());
					jtfDni.setText(e1.getDni());
					jtfDireccion.setText(e1.getDireccion());
					jtfEmail.setText(e1.getEmail());
					jtfTelefono.setText(e1.getTelefono());
				}
			}
		});
		panel.add(btnAnteriorReg);

		JButton btnSiguienteReg = new JButton(">");
		btnSiguienteReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante(Integer.parseInt(jtfId.getText()), jtfNombre.getText(),
						jtfApellido1.getText(), jtfApellido2.getText(), jtfDni.getText(), jtfDireccion.getText(),
						jtfEmail.getText(), jtfTelefono.getText());
				Estudiante e1 = EstudianteController.next(e0);
				if (e1 != null) {
					jtfId.setText(String.valueOf(e1.getId()));
					jtfNombre.setText(e1.getNombre());
					jtfApellido1.setText(e1.getApellido1());
					jtfApellido2.setText(e1.getApellido2());
					jtfDni.setText(e1.getDni());
					jtfDireccion.setText(e1.getDireccion());
					jtfEmail.setText(e1.getEmail());
					jtfTelefono.setText(e1.getTelefono());
				}
			}
		});
		panel.add(btnSiguienteReg);

		JButton btnUltimoReg = new JButton(">>");
		btnUltimoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante();
				Estudiante e1 = EstudianteController.findLast();
				jtfId.setText(String.valueOf(e1.getId()));
				jtfNombre.setText(e1.getNombre());
				jtfApellido1.setText(e1.getApellido1());
				jtfApellido2.setText(e1.getApellido2());
				jtfDni.setText(e1.getDni());
				jtfDireccion.setText(e1.getDireccion());
				jtfEmail.setText(e1.getEmail());
				jtfTelefono.setText(e1.getTelefono());
			}
		});
		panel.add(btnUltimoReg);

		JButton btnGuardarReg = new JButton("Guardar");
		btnGuardarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante(Integer.parseInt(jtfId.getText()), jtfNombre.getText(),
						jtfApellido1.getText(), jtfApellido2.getText(), jtfDni.getText(), jtfDireccion.getText(),
						jtfEmail.getText(), jtfTelefono.getText());
				EstudianteController.update(e0);
			}
		});
		panel.add(btnGuardarReg);

		JButton btnNuevoReg = new JButton("Nuevo");
		btnNuevoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante(Integer.parseInt(jtfId.getText()), jtfNombre.getText(),
						jtfApellido1.getText(), jtfApellido2.getText(), jtfDni.getText(), jtfDireccion.getText(),
						jtfEmail.getText(), jtfTelefono.getText());
				EstudianteController.insert(jtfId, jtfNombre, jtfApellido1, jtfApellido2, jtfDni, jtfDireccion,
						jtfEmail, jtfTelefono);
			}
		});
		panel.add(btnNuevoReg);

		JButton btnEditarReg = new JButton("Eliminar");
		btnEditarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estudiante e0 = new Estudiante(Integer.parseInt(jtfId.getText()), jtfNombre.getText(),
						jtfApellido1.getText(), jtfApellido2.getText(), jtfDni.getText(), jtfDireccion.getText(),
						jtfEmail.getText(), jtfTelefono.getText());
				EstudianteController.delete(e0, jtfId, jtfNombre, jtfApellido1, jtfApellido2, jtfDni, jtfDireccion,
						jtfEmail, jtfTelefono);
			}
		});
		panel.add(btnEditarReg);

		Estudiante e0 = new Estudiante();
		Estudiante e1 = EstudianteController.loadFirst();
		jtfId.setText(String.valueOf(e1.getId()));
		jtfNombre.setText(e1.getNombre());
		jtfApellido1.setText(e1.getApellido1());
		jtfApellido2.setText(e1.getApellido2());
		jtfDni.setText(e1.getDni());
		jtfDireccion.setText(e1.getDireccion());
		jtfEmail.setText(e1.getEmail());
		jtfTelefono.setText(e1.getTelefono());

	}

}
