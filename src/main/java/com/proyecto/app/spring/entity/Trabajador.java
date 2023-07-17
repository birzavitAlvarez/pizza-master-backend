package com.proyecto.app.spring.entity;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="trabajador")
public class Trabajador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Trabajador")
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "ID_Usuario",nullable=false)
    private Usuario usuario;
	
	@Column(name="Nombre_Trabajador",nullable=false,length=20)
	private String nombre;
	
	@Column(name="Apellidos_Trabajador",nullable=false,length=60)
	private String apellido;
	
	@Column(name="Edad_Trabajador",nullable=false, columnDefinition = "SMALLINT(2)")
	private short edad;
	
	@Column(name="DNI_Trabajador",nullable=false,length=8,unique=true)
	private int dni;
	
	@Column(name="Telefono_Trabajador",nullable=false,length=20)
	private String telefono;
	
	@Column(name="Correo_Trabajador",nullable=false,length=50)
	private String correo;
	
	@Column(name="Fecha_Alta",nullable=false)
	private Date fechaAlta;
	
	@Column(name="Fecha_Baja")
	private Date fechaBaja;
	
	@Column(name="Direccion",length=200)
	private String direccion;
	
	@OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private Set<Producto> productos = new HashSet<>();

	public Trabajador() {
		super();
	}

	public Trabajador(Long id, Usuario usuario, String nombre, String apellido, short edad, int dni, String telefono,
			String correo, Date fechaAlta, Date fechaBaja, String direccion, Set<Producto> productos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.direccion = direccion;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
