package com.aph.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.aph.centroEducativo.ConnectionManager;
import com.aph.centroEducativo.model.Valoracion;

public class ValoracionController {
	/**
	 * 
	 * @return
	 */
	public static int getNextId() {
		Connection conn;
		try {
			conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("SELECT max(id) FROM centroeducativo.valoracionmateria");
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
	private static Valoracion getData(String sql) {
		Valoracion valoracion = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				valoracion = new Valoracion();
				valoracion.setId(rs.getInt("id"));
				valoracion.setIdEstudiante(rs.getInt("idEstudiante"));
				valoracion.setIdMateria(rs.getInt("idMateria"));
				valoracion.setIdProfesor(rs.getInt("idProfesor"));
				valoracion.setValoracion(rs.getFloat("valoracion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valoracion;
	}

	/**
	 * 
	 * @return
	 */
	public static Valoracion findFirst() {
		return getData("SELECT * FROM centroeducativo.valoracionmateria ORDER BY ID LIMIT 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Valoracion findLast() {
		return getData("SELECT * FROM centroeducativo.valoracionmateria ORDER BY ID DESC LIMIT 1");
	}

	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Valoracion findNext(int actualId) {
		return getData("SELECT * FROM centroeducativo.valoracionmateria where id > " + actualId + " order by id limit 1");
	}

	/**
	 * 
	 * @param actualId
	 * @return
	 */
	public static Valoracion findPrevious(int actualId) {
		return getData("SELECT * FROM centroeducativo.valoracionmateria where id < " + actualId + " order by id desc limit 1");
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public static int update(Valoracion v) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres actualizar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn
						.prepareStatement("UPDATE valoracionmateria SET idEstudiante = ?, idMateria = ?, idProfesor = ?, valoracion = ? WHERE id = ?");

				ps.setInt(1, v.getIdEstudiante());
				ps.setInt(2, v.getIdMateria());
				ps.setInt(3, v.getIdProfesor());
				ps.setFloat(4, v.getValoracion());
				ps.setInt(5, v.getId());
				
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
	 * @param v
	 * @return
	 */
	public static int insert(Valoracion v) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres insertar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO valoracionmateria (id, idEstudiante, idMateria, idProfesor, valoracion) VALUES (?, ?, ?, ?, ?)");

				ps.setInt(1, getNextId());
				ps.setInt(2, v.getIdEstudiante());
				ps.setInt(3, v.getIdMateria());
				ps.setInt(4, v.getIdProfesor());
				ps.setFloat(5, v.getValoracion());

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
				PreparedStatement ps = conn.prepareStatement("DELETE FROM valoracionmateria WHERE id = ?");

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
}