package com.aph.centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import com.aph.centroEducativo.controller.CursoController;
import com.aph.centroEducativo.controller.EstudianteController;
import com.aph.centroEducativo.controller.MateriaController;
import com.aph.centroEducativo.controller.ProfesorController;
import com.aph.centroEducativo.controller.ValoracionController;
import com.aph.centroEducativo.model.Curso;
import com.aph.centroEducativo.model.Estudiante;
import com.aph.centroEducativo.model.Materia;
import com.aph.centroEducativo.model.Profesor;
import com.aph.centroEducativo.model.Valoracion;

import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class ValoracionView extends JPanel {
	private JTextField jtfId;
	private JComboBox<Estudiante> jcbEstudiante;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JPanel contentPane = null;
	JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo;
	private JTextField jtfValoracion;

	/**
	 * Create the panel.
	 */
	public ValoracionView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		add(contentPane, gbc_contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_2 = new JLabel("GESTIÓN DE MATERIAS");
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

		JLabel lblNewLabel_1 = new JLabel("ID Estudiante:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_jcbEstudiante = new GridBagConstraints();
		gbc_jcbEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEstudiante.gridx = 1;
		gbc_jcbEstudiante.gridy = 2;
		contentPane.add(jcbEstudiante, gbc_jcbEstudiante);

		JLabel lblNewLabel_1_1 = new JLabel("ID Materia:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1_1_1 = new JLabel("ID Profesor:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 4;
		contentPane.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Valoracion:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);

		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 5;
		contentPane.add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(ValoracionController.findFirst());
			}
		});
		panel.add(btnPrimero);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(ValoracionController.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(ValoracionController.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(ValoracionController.findLast());
			}
		});
		panel.add(btnUltimo);

		JButton btnGuardarReg = new JButton("Guardar");
		btnGuardarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel.add(btnGuardarReg);

		JButton btnNuevoReg = new JButton("Nuevo");
		btnNuevoReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel.add(btnNuevoReg);

		JButton btnEditarReg = new JButton("Eliminar");
		btnEditarReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		panel.add(btnEditarReg);

		fillJcb();
		show(ValoracionController.findFirst());
	}

	/**
	 * 
	 */
	private void fillJcb() {
		List<Estudiante> le = EstudianteController.findAll();
		for (Estudiante estudiante : le) {
			jcbEstudiante.addItem(estudiante);
		}
		List<Materia> lm = MateriaController.findAll();
		for (Materia materia: lm) {
			jcbMateria.addItem(materia);
		}
		List<Profesor> lp = ProfesorController.findAll();
		for (Profesor profesor : lp) {
			jcbProfesor.addItem(profesor);
		}
	}

	/**
	 * 
	 * @param m
	 */
	private void show(Valoracion v) {
		if (v != null) {
			this.jtfId.setText("" + v.getId());

			for (int i = 0; i < this.jcbEstudiante.getItemCount(); i++) {
				Estudiante e = this.jcbEstudiante.getItemAt(i);
				if (v.getIdEstudiante() == e.getId()) {
					this.jcbEstudiante.setSelectedIndex(i);
				}
			}

			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				Materia m = this.jcbMateria.getItemAt(i);
				if (v.getIdMateria() == m.getId()) {
					this.jcbMateria.setSelectedIndex(i);
				}
			}

			for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
				Profesor p = this.jcbProfesor.getItemAt(i);
				if (v.getIdProfesor() == p.getId()) {
					this.jcbProfesor.setSelectedIndex(i);
				}
			}

			this.jtfValoracion.setText("" + v.getValoracion());
		}

		// Habilito y deshabilito botones de navegación
		if (ValoracionController.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
			this.btnPrimero.setEnabled(false);
			this.btnAnterior.setEnabled(false);
		} else {
			this.btnPrimero.setEnabled(true);
			this.btnAnterior.setEnabled(true);
		}

		if (ValoracionController.findNext(Integer.parseInt(jtfId.getText())) == null) {
			this.btnUltimo.setEnabled(false);
			this.btnSiguiente.setEnabled(false);
		} else {
			this.btnUltimo.setEnabled(true);
			this.btnSiguiente.setEnabled(true);
		}
	}

	/**
	 * 
	 */
	private void clear() {
		this.jtfId.setText("0");
		if (this.jcbEstudiante.getItemCount() > 0) {
			this.jcbEstudiante.setSelectedIndex(0);
		}
		if (this.jcbMateria.getItemCount() > 0) {
			this.jcbMateria.setSelectedIndex(0);
		}
		if (this.jcbProfesor.getItemCount() > 0) {
			this.jcbProfesor.setSelectedIndex(0);
		}
		this.jtfValoracion.setText("");
	}

	/**
	 * 
	 */
	private void save() {
		Valoracion v = new Valoracion();
		v.setId(Integer.parseInt(jtfId.getText()));

		Estudiante e = (Estudiante) jcbEstudiante.getSelectedItem();
		v.setIdEstudiante(e.getId());

		Materia m = (Materia) jcbMateria.getSelectedItem();
		v.setIdMateria(m.getId());

		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		v.setIdProfesor(p.getId());
		
		v.setValoracion(Float.parseFloat(jtfValoracion.getText()));

		if (Integer.parseInt(jtfId.getText()) != 0) {
			JOptionPane.showMessageDialog(null, "Filas afectadas: " + ValoracionController.update(v));
		} else {
			JOptionPane.showMessageDialog(null, "Filas afectadas: " + ValoracionController.insert(v));
			show(ValoracionController.findLast());
		}
	}

	/**
	 * 
	 */
	private void delete() {
		int actualId = Integer.parseInt(jtfId.getText());

		JOptionPane.showMessageDialog(null, "Filas afectadas: " + ValoracionController.delete(actualId));

		if (ValoracionController.findPrevious(actualId) != null) {
			show(ValoracionController.findPrevious(actualId));
		} else if (ValoracionController.findNext(actualId) != null) {
			show(ValoracionController.findNext(actualId));
		} else {
			clear();
		}
	}
}
