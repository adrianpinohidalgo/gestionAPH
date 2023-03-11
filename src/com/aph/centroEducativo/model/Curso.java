package com.aph.centroEducativo.model;

public class Curso {
	public int id;
	public String descripcion;

	/**
	 * 
	 */
	public Curso() {
	}

	/**
	 * 
	 * @param id
	 * @param descripcion
	 */
	public Curso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Curso) obj).id;
	}

	@Override
	public String toString() {
		return "Curso " + descripcion;
	}

}
