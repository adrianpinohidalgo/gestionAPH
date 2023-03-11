package com.aph.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import com.aph.centroEducativo.controller.CursoController;
import com.aph.centroEducativo.model.Curso;

import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CursoView extends JPanel {
	private JTextField jtfId;
	private JTextField jtfDescripcion;

	/**
	 * Create the panel.
	 */
	public CursoView() {
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
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_2 = new JLabel("GESTIÓN DE CURSOS");
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

		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescripcion = new JTextField();
		jtfDescripcion.setColumns(10);
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		contentPane.add(jtfDescripcion, gbc_jtfDescripcion);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPrimerReg = new JButton("<<");
		btnPrimerReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso();
				Curso c1 = CursoController.findFirst();
				jtfId.setText(String.valueOf(c1.getId()));
				jtfDescripcion.setText(c1.getDescripcion());
			}
		});
		panel.add(btnPrimerReg);

		JButton btnAnteriorReg = new JButton("<");
		btnAnteriorReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescripcion.getText());
				Curso c1 = CursoController.previous(c);
				if (c1 != null) {
					jtfId.setText(String.valueOf(c1.getId()));
					jtfDescripcion.setText(c1.getDescripcion());
				}
			}
		});
		panel.add(btnAnteriorReg);

		JButton btnSiguienteReg = new JButton(">");
		btnSiguienteReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescripcion.getText());
				Curso c1 = CursoController.next(c);
				if (c1 != null) {
					jtfId.setText(String.valueOf(c1.getId()));
					jtfDescripcion.setText(c1.getDescripcion());
				}
			}
		});
		panel.add(btnSiguienteReg);

		JButton btnUltimoReg = new JButton(">>");
		btnUltimoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso();
				Curso c1 = CursoController.findLast();
				jtfId.setText(String.valueOf(c1.getId()));
				jtfDescripcion.setText(c1.getDescripcion());
			}
		});
		panel.add(btnUltimoReg);

		JButton btnGuardarReg = new JButton("Guardar");
		btnGuardarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescripcion.getText());
				CursoController.update(c);
			}
		});
		panel.add(btnGuardarReg);

		JButton btnNuevoReg = new JButton("Nuevo");
		btnNuevoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescripcion.getText());
				CursoController.insert(jtfId, jtfDescripcion);
			}
		});
		panel.add(btnNuevoReg);

		JButton btnEditarReg = new JButton("Eliminar");
		btnEditarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(Integer.parseInt(jtfId.getText()), jtfDescripcion.getText());
				CursoController.delete(c, jtfId, jtfDescripcion);
			}
		});
		panel.add(btnEditarReg);

		Curso c = new Curso();
		Curso c1 = CursoController.loadFirst();
		jtfId.setText(String.valueOf(c1.getId()));
		jtfDescripcion.setText(c1.getDescripcion());
	}

}
