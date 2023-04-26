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

public class EstudianteController {
	/**
	 * 
	 * @param e
	 * @return
	 */
	public static Estudiante loadFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Estudiante estudiante = null;
			if (rs.next()) {
				estudiante = new Estudiante(rs.getInt("id"), rs.getInt("idTipologiaSexo"), rs.getString("nombre"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
						rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("colorPreferido"), rs.getBytes("imagen"));
				return estudiante;
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
	 * @param e
	 * @return
	 */
	public static Estudiante findFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Estudiante estudiante = null;
			if (rs.next()) {
				estudiante = new Estudiante(rs.getInt("id"), rs.getInt("idTipologiaSexo"), rs.getString("nombre"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
						rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("colorPreferido"), rs.getBytes("imagen"));
				return estudiante;
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
	 * @param e
	 * @return
	 */
	public static Estudiante findLast() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante order by id desc limit 1");
			ResultSet rs = ps.executeQuery();

			Estudiante estudiante = null;
			if (rs.next()) {
				estudiante = new Estudiante(rs.getInt("id"), rs.getInt("idTipologiaSexo"), rs.getString("nombre"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
						rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("colorPreferido"), rs.getBytes("imagen"));
				return estudiante;
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
	 * @param e
	 * @return
	 */
	public static Estudiante next(Estudiante e) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante where id > ? order by id limit 1");
			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();

			Estudiante estudiante = null;
			if (rs.next()) {
				estudiante = new Estudiante(rs.getInt("id"), rs.getInt("idTipologiaSexo"), rs.getString("nombre"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
						rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("colorPreferido"), rs.getBytes("imagen"));
				return estudiante;
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
	 * @param e
	 * @return
	 */
	public static Estudiante previous(Estudiante e) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante where id < ? order by id desc limit 1");
			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();

			Estudiante estudiante = null;
			if (rs.next()) {
				estudiante = new Estudiante(rs.getInt("id"), rs.getInt("idTipologiaSexo"), rs.getString("nombre"),
						rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("dni"),
						rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("colorPreferido"), rs.getBytes("imagen"));
				return estudiante;
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
	 * @param e
	 * @return
	 */
	public static void update(Estudiante e) {

		try {
			Connection conn = ConnectionManager.getConexion();
			if (!(e.getId() == EstudianteController.getSiguienteIdValido("estudiante"))) {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres guardar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn.prepareStatement(
							"update centroeducativo.estudiante set nombre=?, apellido1=?, apellido2=?, imagen=?, dni=?, direccion=?, email=?, telefono=?, colorPreferido=?, idTipologiaSexo=? where id=?");
					ps.setString(1, e.getNombre());
					ps.setString(2, e.getApellido1());
					ps.setString(3, e.getApellido2());
					ps.setBytes(4, e.getImagen());
					ps.setString(5, e.getDni());
					ps.setString(6, e.getDireccion());
					ps.setString(7, e.getEmail());
					ps.setString(8, e.getTelefono());
					ps.setString(9, e.getColor());
					ps.setInt(10, e.getIdToplogiaSexo());
					ps.setInt(11, e.getId());

					int filasAfectadas = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

					ps.close();
				}
			} else {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres insertar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn.prepareStatement(
							"insert into centroeducativo.estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) values (?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setInt(1, e.getId());
					ps.setString(2, e.getNombre());
					ps.setString(3, e.getApellido1());
					ps.setString(4, e.getApellido2());
					ps.setString(5, e.getDni());
					ps.setString(6, e.getDireccion());
					ps.setString(7, e.getEmail());
					ps.setString(8, e.getTelefono());

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
	 * @param e
	 * @param jtfId
	 * @param jtfNombre
	 * @param jtfApellido1
	 * @param jtfApellido2
	 * @param jtfDni
	 * @param jtfDireccion
	 * @param jtfEmail
	 * @param jtfTelefono
	 */
	public static void delete(Estudiante e, JTextField jtfId, JTextField jtfNombre, JTextField jtfApellido1,
			JTextField jtfApellido2, JTextField jtfDni, JTextField jtfDireccion, JTextField jtfEmail,
			JTextField jtfTelefono) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.estudiante where id=?");
				ps.setInt(1, e.getId());

				int filasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

				ps.close();
				conn.close();

				// Carga el registro anterior al borrar
				Estudiante e1 = EstudianteController.previous(e);
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
	 * @param jtfNombre
	 * @param jtfApellido1
	 * @param jtfApellido2
	 * @param jtfDni
	 * @param jtfDireccion
	 * @param jtfEmail
	 * @param jtfTelefono
	 */
	public static void insert(JTextField jtfId, JTextField jtfNombre, JTextField jtfApellido1, JTextField jtfApellido2,
			JTextField jtfDni, JTextField jtfDireccion, JTextField jtfEmail, JTextField jtfTelefono) {
		jtfId.setText(String.valueOf(CursoController.getSiguienteIdValido("estudiante")));
		jtfNombre.setText("");
		jtfApellido1.setText("");
		jtfApellido2.setText("");
		jtfDni.setText("");
		jtfDireccion.setText("");
		jtfEmail.setText("");
		jtfTelefono.setText("");
	}

	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo.estudiante");

			while (rs.next()) {
				Estudiante e = new Estudiante();
				e.setId(rs.getInt("id"));
				e.setNombre(rs.getString("nombre"));
				e.setApellido1(rs.getString("apellido1"));
				e.setApellido2(rs.getString("apellido2"));
				e.setDni(rs.getString("dni"));
				e.setDireccion(rs.getString("direccion"));
				e.setEmail(rs.getString("email"));
				e.setTelefono(rs.getString("telefono"));
				estudiantes.add(e);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return estudiantes;
	}
}