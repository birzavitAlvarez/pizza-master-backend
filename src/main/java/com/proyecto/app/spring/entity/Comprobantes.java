package com.proyecto.app.spring.entity;

import java.math.BigDecimal;
import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;



@Entity
@Table(name="registro_comprobantes")
public class Comprobantes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Registro_Compro")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="ID_Producto")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Producto producto;
	
	@Column(name="Fecha_Comprobante",nullable=false)
	private Date fechaCompro;
	
	@Column(name="Total_Comprobante", nullable = false, columnDefinition = "DECIMAL(6,2)")
	private BigDecimal totalCompro;

	
	public Comprobantes() {
		super();
	}


	public Comprobantes(Long id, Producto producto, Date fechaCompro, BigDecimal totalCompro) {
		super();
		this.id = id;
		this.producto = producto;
		this.fechaCompro = fechaCompro;
		this.totalCompro = totalCompro;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Date getFechaCompro() {
		return fechaCompro;
	}


	public void setFechaCompro(Date fechaCompro) {
		this.fechaCompro = fechaCompro;
	}


	public BigDecimal getTotalCompro() {
		return this.totalCompro;
	}


	public void setTotalCompro(BigDecimal totalCompro) {
		this.totalCompro = totalCompro;
	}
	
	
	
}
