package com.proyecto.app.spring.DTO;

import java.sql.Date;

public class TrabajadorDTO {

	private Long id;

	private String nombre;

	private String apellido;

	private short edad;

	private int dni;

	private String telefono;

	private String correo;

	private Date fechaAlta;

	private Date fechaBaja;

	private String direccion;

	private String nombreUsuario;

	private Long idUsuario;

	public TrabajadorDTO() {
		super();
	}

	public TrabajadorDTO(Long id, String nombre, String apellido, short edad, int dni, String telefono, String correo,
			Date fechaAlta, Date fechaBaja, String direccion, String nombreUsuario, Long idUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.idUsuario = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public short getEdad() {
		return edad;
	}

	public void setEdad(short edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
