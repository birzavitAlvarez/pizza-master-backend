package com.proyecto.app.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Long id;
    @Column(name = "fecha_venta", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaVenta;
    @Column(name = "subTotal_venta", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal subTotalVenta;
    @Column(name = "igv_venta", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal igvVenta;
    @Column(name = "total_venta", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal totalVenta;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<Detalle> detalles = new HashSet<>();

    public Venta() {
    }
    public Venta(Long id, BigDecimal subTotalVenta, BigDecimal igvVenta, BigDecimal totalVenta) {
        this.subTotalVenta = subTotalVenta;
        this.igvVenta = igvVenta;
        this.totalVenta = totalVenta;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getSubTotalVenta() {
        return subTotalVenta;
    }

    public void setSubTotalVenta(BigDecimal subTotalVenta) {
        this.subTotalVenta = subTotalVenta;
    }

    public BigDecimal getIgvVenta() {
        return igvVenta;
    }

    public void setIgvVenta(BigDecimal igvVenta) {
        this.igvVenta = igvVenta;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }
    @PrePersist
    public void prePersist() {
        this.fechaVenta = new Timestamp(System.currentTimeMillis());
    }
    public Set<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }
}
