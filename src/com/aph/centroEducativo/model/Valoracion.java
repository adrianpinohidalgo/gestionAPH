package com.aph.centroEducativo.model;

public class Valoracion {
	public int id, idEstudiante, idMateria, idProfesor;
	public float valoracion;

	public Valoracion() {

	}

	public Valoracion(int id, int idEstudiante, int idMateria, int idProfesor, float valoracion) {
		this.id = id;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.idProfesor = idProfesor;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", idEstudiante=" + idEstudiante + ", idMateria=" + idMateria + ", idProfesor="
				+ idProfesor + ", valoracion=" + valoracion + "]";
	}

}
