package com.proyecto.app.spring.DTO;

import java.math.BigDecimal;

public class ProductoDTO {
	private Long id;
	private String nombre;
	private String unidadMedida;
	private BigDecimal cantidadProducto;
	private String claseProducto;
	private Long idProveedor;
	private String nombreProveedor;
	private Long idTrabajador;
	private String nombreTrabajador;

	public ProductoDTO(BigDecimal cantidadProducto) {
		this.cantidadProducto=cantidadProducto;
	}

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(Long id, String nombre, String unidadMedida, BigDecimal cantidadProducto, String claseProducto
			,Long idProveedor,String nombreProveedor,Long idTrabajador, String nombreTrabajador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.cantidadProducto = cantidadProducto;
		this.claseProducto = claseProducto;
		this.idProveedor=idProveedor;
		this.idTrabajador=idTrabajador;
		this.nombreProveedor = nombreProveedor;
		this.nombreTrabajador = nombreTrabajador;
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

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Long getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
}
