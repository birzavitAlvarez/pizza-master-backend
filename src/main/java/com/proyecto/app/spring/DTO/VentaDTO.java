package com.proyecto.app.spring.DTO;

import com.proyecto.app.spring.entity.Detalle;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class VentaDTO {
    private Long id;
    private Timestamp fechaVenta;
    private BigDecimal subTotalVenta;
    private BigDecimal igvVenta;
    private BigDecimal totalVenta;
    private Set<DetalleDTO> detalles;
    public VentaDTO(Long id,Timestamp fechaVenta, BigDecimal subTotalVenta, BigDecimal igvVenta, BigDecimal totalVenta,Set<DetalleDTO>detalles) {
        this.id=id;
        this.fechaVenta = fechaVenta;
        this.subTotalVenta = subTotalVenta;
        this.igvVenta = igvVenta;
        this.detalles=detalles;
        this.totalVenta = totalVenta;
    }

    public VentaDTO() {
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

    public Set<DetalleDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleDTO> detalles) {
        this.detalles = detalles;
    }
}
