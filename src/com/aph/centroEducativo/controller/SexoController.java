package com.aph.centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aph.centroEducativo.ConnectionManager;
import com.aph.centroEducativo.model.Sexo;

public class SexoController {
	/**
	 * 
	 * @return
	 */
	public static List<Sexo> findAll() {
		List<Sexo> l = new ArrayList<Sexo>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo.tipologiaSexo");

			while (rs.next()) {
				Sexo o = new Sexo();
				o.setId(rs.getInt("id"));
				o.setDescripcion(rs.getString("descripcion"));
				l.add(o);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return l;
	}

	/**
	 * 
	 * @return
	 */
	public static Sexo findById(int id) {
		Sexo o = null;

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tipologiaSexo where id =" + id);

			if (rs.next()) {
				o = new Sexo();
				o.setId(rs.getInt("id"));
				o.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return o;
	}
}
