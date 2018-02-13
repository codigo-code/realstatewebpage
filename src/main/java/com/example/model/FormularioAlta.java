package com.example.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class FormularioAlta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3535196917954813935L;

	private String nombre;
	private String localidad;
	private double precio;
	private String imagen;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
