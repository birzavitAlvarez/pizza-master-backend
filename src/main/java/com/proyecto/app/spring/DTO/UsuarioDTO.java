package com.proyecto.app.spring.DTO;

public class UsuarioDTO {
	private Long id;
	private Long idRol;
	private String nombreRol;
	private String usuario;
	private String contrasena;
	private Long idTrabajador;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long idRol) {
		super();
		this.idRol = idRol;
	}

	public UsuarioDTO(Long id, Long idRol, String usuario) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.usuario = usuario;
	}

	public UsuarioDTO(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public UsuarioDTO(Long id, Long idRol, String nombreRol, String usuario, String contrasena) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public UsuarioDTO(Long id, Long idRol, String nombreRol, String usuario, String contrasena,Long idTrabajador) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.usuario = usuario;
		this.idTrabajador=idTrabajador;
		this.contrasena = contrasena;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
}
