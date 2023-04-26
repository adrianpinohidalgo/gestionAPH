package com.aph.centroEducativo.model;

public class Estudiante {
	public int id, idToplogiaSexo;
	public String nombre, apellido1, apellido2, dni, direccion, email, telefono, color;
	public byte[] imagen;

	public Estudiante() {

	}

	public Estudiante(int id, int idToplogiaSexo, String nombre, String apellido1, String apellido2, String dni,
			String direccion, String email, String telefono, String color, byte[] imagen) {
		super();
		this.id = id;
		this.idToplogiaSexo = idToplogiaSexo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.color = color;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdToplogiaSexo() {
		return idToplogiaSexo;
	}

	public void setIdToplogiaSexo(int idToplogiaSexo) {
		this.idToplogiaSexo = idToplogiaSexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", idToplogiaSexo=" + idToplogiaSexo + ", nombre=" + nombre + ", apellido1="
				+ apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", direccion=" + direccion + ", email="
				+ email + ", telefono=" + telefono + "]";
	}

}
