package com.proyecto.app.spring.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Proveedor")
	private Long id;

	@Column(name = "Nombre_Proveedor", nullable = false, length = 100)
	private String nombreP;

	@Column(name = "Ruc_Proveedor", nullable = false, length = 11, unique = true)
	private String ruc;

	@Column(name = "Direccion_Proveedor", nullable = false, length = 50)
	private String direccion;

	@Column(name = "telefono", nullable = false, length = 20)
	private String telefono;

	@Column(name = "correo", nullable = false, length = 50)
	private String correo;

	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
	private Set<Producto> productos = new HashSet<>();

	public Proveedor() {
		super();
	}

	public Proveedor(Long id, String nombreP, String ruc, String direccion, String telefono, String correo) {
		super();
		this.id = id;
		this.nombreP = nombreP;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
