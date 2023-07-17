package com.proyecto.app.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Usuario")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_Rol")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Roles rol;
	
	@Column(name="Usuario",nullable=false,length=15,unique=true)
	private String usuario;
	
	@Column(name="Contraseña",nullable=false,length=100)
	private String contrasena;

	public Usuario() {
		super();
	}

	public Usuario(Long id, Roles rol, String usuario, String contrasena) {
		super();
		this.id = id;
		this.rol = rol;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
