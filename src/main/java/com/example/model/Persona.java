package com.example.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6254186453669517902L;
	private String nombre;
	private String apellido;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
