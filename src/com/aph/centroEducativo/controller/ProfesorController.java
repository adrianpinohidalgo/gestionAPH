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
import com.aph.centroEducativo.model.Estudiante;
import com.aph.centroEducativo.model.Profesor;

public class ProfesorController {
	/**
	 * 
	 * @return
	 */
	public static Profesor loadFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.profesor order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Profesor profesor = null;
			if (rs.next()) {
				profesor = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"));
				return profesor;
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
	 * @return
	 */
	public static Profesor findFirst() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.profesor order by id limit 1");
			ResultSet rs = ps.executeQuery();

			Profesor profesor = null;
			if (rs.next()) {
				profesor = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"));
				return profesor;
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
	 * @return
	 */
	public static Profesor findLast() {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.profesor order by id desc limit 1");
			ResultSet rs = ps.executeQuery();

			Profesor profesor = null;
			if (rs.next()) {
				profesor = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"));
				return profesor;
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
	public static Profesor next(Profesor p) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.profesor where id > ? order by id limit 1");
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();

			Profesor profesor = null;
			if (rs.next()) {
				profesor = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"));
				return profesor;
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
	public static Profesor previous(Profesor p) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.profesor where id < ? order by id desc limit 1");
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();

			Profesor profesor = null;
			if (rs.next()) {
				profesor = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("direccion"),
						rs.getString("email"), rs.getString("telefono"));
				return profesor;
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
	public static void update(Profesor p) {

		try {
			Connection conn = ConnectionManager.getConexion();
			if (!(p.getId() == ProfesorController.getSiguienteIdValido("profesor"))) {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres guardar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn.prepareStatement(
							"update centroeducativo.profesor set nombre=?, apellido1=?, apellido2=?, dni=?, direccion=?, email=?, telefono=? where id=?");
					ps.setString(1, p.getNombre());
					ps.setString(2, p.getApellido1());
					ps.setString(3, p.getApellido2());
					ps.setString(4, p.getDni());
					ps.setString(5, p.getDireccion());
					ps.setString(6, p.getEmail());
					ps.setString(7, p.getTelefono());
					ps.setInt(8, p.getId());

					int filasAfectadas = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

					ps.close();
				}
			} else {
				int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres insertar el registro?");
				if (answer == 0) {
					PreparedStatement ps = conn.prepareStatement(
							"insert into centroeducativo.profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) values (?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setInt(1, p.getId());
					ps.setString(2, p.getNombre());
					ps.setString(3, p.getApellido1());
					ps.setString(4, p.getApellido2());
					ps.setString(5, p.getDni());
					ps.setString(6, p.getDireccion());
					ps.setString(7, p.getEmail());
					ps.setString(8, p.getTelefono());

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
	 * @param p
	 * @param jtfId
	 * @param jtfNombre
	 * @param jtfApellido1
	 * @param jtfApellido2
	 * @param jtfDni
	 * @param jtfDireccion
	 * @param jtfEmail
	 * @param jtfTelefono
	 */
	public static void delete(Profesor p, JTextField jtfId, JTextField jtfNombre, JTextField jtfApellido1,
			JTextField jtfApellido2, JTextField jtfDni, JTextField jtfDireccion, JTextField jtfEmail,
			JTextField jtfTelefono) {
		int answer = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el registro?");
		if (answer == 0) {
			try {
				Connection conn = ConnectionManager.getConexion();
				PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.profesor where id=?");
				ps.setInt(1, p.getId());

				int filasAfectadas = ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Filas afectadas: " + filasAfectadas);

				ps.close();
				conn.close();

				// Carga el registro anterior al borrar
				Profesor p1 = ProfesorController.previous(p);
				if (p1 != null) {
					jtfId.setText(String.valueOf(p1.getId()));
					jtfNombre.setText(p1.getNombre());
					jtfApellido1.setText(p1.getApellido1());
					jtfApellido2.setText(p1.getApellido2());
					jtfDni.setText(p1.getDni());
					jtfDireccion.setText(p1.getDireccion());
					jtfEmail.setText(p1.getEmail());
					jtfTelefono.setText(p1.getTelefono());
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
		jtfId.setText(String.valueOf(CursoController.getSiguienteIdValido("profesor")));
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
	public static List<Profesor> findAll() {
		List<Profesor> profesores = new ArrayList<Profesor>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo.profesor");

			while (rs.next()) {
				Profesor p = new Profesor();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido1(rs.getString("apellido1"));
				p.setApellido2(rs.getString("apellido2"));
				p.setDni(rs.getString("dni"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				profesores.add(p);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return profesores;
	}
}