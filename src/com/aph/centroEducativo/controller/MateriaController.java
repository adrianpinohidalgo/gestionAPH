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
import com.aph.centroEducativo.model.Estudiante;
import com.aph.centroEducativo.model.Materia;

public class MateriaController {
	/**
	 * 
	 * @param tabla
	 * @return
	 */
	public static int getNextId() {
		Connection conn;
		try {
			conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("SELECT max(id) FROM centroeducativo.materia");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 1;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	private static Materia getData(String sql) {
		Materia materia = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAcronimo(rs.getString("acronimo"));
				materia.setCurso_id(rs.getInt("curso_id"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materia;
	}

	/**
	 * 
	 * @return
	 */
	public static Materia findFirst() {
		return getData("SELECT * FROM centroeducativo.materia ORDER BY ID LIMIT 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Materia findLast() {
		return getData("SELECT * FROM centroeducativo.materia ORDER BY ID DESC LIMIT 1");
	}

	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Materia findNext(int actualId) {
		return getData("SELECT * FROM centroeducativo.materia where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Materia findPrevious(int actualId) {
		return getData("SELECT * FROM centroeducativo.materia where id < " + actualId + " order by id desc limit 1");
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int update(Materia m) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres actualizar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn
						.prepareStatement("UPDATE materia SET nombre = ?, acronimo = ?, curso_id = ? WHERE id = ?");

				ps.setString(1, m.getNombre());
				ps.setString(2, m.getAcronimo());
				ps.setInt(3, m.getCurso_id());
				ps.setInt(4, m.getId());
				int rows = ps.executeUpdate();

				ps.close();
				conn.close();

				return rows;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int insert(Materia m) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres insertar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO materia (id, nombre, acronimo, curso_id) VALUES (?, ?, ?, ?)");

				ps.setInt(1, getNextId());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getAcronimo());
				ps.setInt(4, m.getCurso_id());

				int rows = ps.executeUpdate();

				ps.close();
				conn.close();

				return rows;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static int delete(int id) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM materia WHERE id = ?");

				ps.setInt(1, id);

				int rows = ps.executeUpdate();

				ps.close();
				conn.close();
				return rows;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll() {
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo.materia");
			
			while (rs.next()) {
				Materia m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setAcronimo(rs.getString("acronimo"));
				m.setCurso_id(rs.getInt("curso_id"));
				materias.add(m);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return materias;
	}
}