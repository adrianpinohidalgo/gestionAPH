package com.aph.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.aph.centroEducativo.ConnectionManager;
import com.aph.centroEducativo.model.Curso;

public class CursoController {
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static boolean loadId(JTextField jtfCursoId) {
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement s = (Statement) conn.createStatement();

			ResultSet rs = s.executeQuery("select * from centroeducativo.curso");

			while (rs.next()) {
				if (String.valueOf(rs.getInt(1)).equals(jtfCursoId.getText())) {
					return true;
				} else {
					return false;
				}
			}
			rs.close();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Curso loadFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.curso order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Curso curso = null;
			if (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				return curso;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Curso findFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.curso order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Curso curso = null;
			if (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				return curso;
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Curso findLast() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.curso order by id desc limit 1");
			ResultSet rs = ps.executeQuery();

			Curso curso = null;
			if (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				return curso;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Curso next(Curso c) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.curso where id > ? order by id limit 1");
			ps.setInt(1, c.getId());
			ResultSet rs = ps.executeQuery();

			Curso curso = null;
			if (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				return curso;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Curso previous(Curso c) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.curso where id < ? order by id desc limit 1");
			ps.setInt(1, c.getId());
			ResultSet rs = ps.executeQuery();

			Curso curso = null;
			if (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("descripcion"));
				return curso;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static void update(Curso c) {

		try {
			Connection conn = ConnectionManager.getConexion();
			if (!(c.getId() == CursoController.getSiguienteIdValido("curso"))) {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres guardar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn
							.prepareStatement("update centroeducativo.curso set descripcion=? where id=?");
					ps.setString(1, c.getDescripcion());
					ps.setInt(2, c.getId());

					int filasAfectadas = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

					ps.close();
				}
			} else {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres insertar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn
							.prepareStatement("insert into centroeducativo.curso (id, descripcion) values (?, ?)");
					ps.setInt(1, c.getId());
					ps.setString(2, c.getDescripcion());

					int filasAfectadas = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

					ps.close();
				}
			}

			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param c
	 * @param jtfId
	 * @param jtfDescripcion
	 */
	public static void delete(Curso c, JTextField jtfId, JTextField jtfDescripcion) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.curso where id=?");
				ps.setInt(1, c.getId());

				int filasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

				ps.close();
				conn.close();

				// Carga el registro anterior al borrar
				Curso c1 = CursoController.previous(c);
				if (c1 != null) {
					jtfId.setText(String.valueOf(c1.getId()));
					jtfDescripcion.setText(c1.getDescripcion());
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param tabla
	 * @return
	 */
	public static int getSiguienteIdValido(String tabla) {
		Connection conn;
		try {
			conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo." + tabla);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			rs.close();
			ps.close();
			ps.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 1;
	}

	/**
	 * 
	 * @param jtfId
	 * @param jtfDescripcion
	 */
	public static void insert(JTextField jtfId, JTextField jtfDescripcion) {
		jtfId.setText(String.valueOf(CursoController.getSiguienteIdValido("curso")));
		jtfDescripcion.setText("");
	}

	/**
	 * 
	 * @return
	 */
	public static List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo.curso");

			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				cursos.add(c);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cursos;
	}
}