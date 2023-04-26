package com.aph.centroEducativo.model;

public class Sexo {
	private int id;
	private String descripcion;

	public Sexo() {

	}

	public Sexo(int id, String descripcion) {
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
	public String toString() {
		return descripcion;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Sexo) {
//			Sexo o = (Sexo) obj;
//			if (this.id == o.id) {
//				return true;
//			}
//		}
//		return false;
//	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Sexo) obj ).getId();
	}

}
