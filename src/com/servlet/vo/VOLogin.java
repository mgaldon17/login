package com.servlet.vo;

import java.io.Serializable;

public class VOLogin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password ;
	private int edad;
	private String nombre;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
