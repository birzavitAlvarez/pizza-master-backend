package com.proyecto.app.spring.entity;

import java.math.BigDecimal;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;

@Entity
@Table(name = "registro_producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Producto")
	private Long id;

	@Column(name = "Nombre_Producto", nullable = false, length = 20,unique = true)
	private String nombre;

	@Column(name = "U_medida", nullable = false,length=20)
	private String unidadMedida;

	@Column(name = "Cantidad_Producto", nullable = false, columnDefinition = "DECIMAL(8,3)")
	private BigDecimal cantidadProducto;

	@Column(name = "Clase_Producto", nullable = false, length = 20)
	private String claseProducto;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private Set<Comprobantes> comprobantes = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_Proveedor")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Proveedor proveedor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_Trabajador")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Trabajador trabajador;
	
	public Producto() {
		super();
	}

	

	public Producto(Long id, Proveedor proveedor, Trabajador trabajador, String nombre, String unidadMedida,
			BigDecimal cantidadProducto, String claseProducto) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.trabajador = trabajador;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.cantidadProducto = cantidadProducto;
		this.claseProducto = claseProducto;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	

	public Trabajador getTrabajador() {
		return trabajador;
	}



	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public BigDecimal getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(BigDecimal cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getClaseProducto() {
		return claseProducto;
	}

	public void setClaseProducto(String claseProducto) {
		this.claseProducto = claseProducto;
	}



	public Set<Comprobantes> getComprobantes() {
		return comprobantes;
	}



	public void setComprobantes(Set<Comprobantes> comprobantes) {
		this.comprobantes = comprobantes;
	}
}
