package com.proyecto.app.spring.DTO;

import java.math.BigDecimal;
public class DetalleDTO {
    private Long idDetalle;
    private Long idCarta;
    private String nombreCarta;
    private BigDecimal precioCarta;
    private Long idVenta;
    private int cantidad;
    private BigDecimal precio;
    private BigDecimal total;

    public DetalleDTO() {
    }
    public DetalleDTO(Long idDetalle,Long idCarta,String nombreCarta,BigDecimal precioCarta,Long idVenta,int cantidad,BigDecimal precio,BigDecimal total) {
        this.idDetalle=idDetalle;
        this.idCarta=idCarta;
        this.nombreCarta=nombreCarta;
        this.precioCarta=precioCarta;
        this.idVenta=idVenta;
        this.cantidad=cantidad;
        this.precio=precio;
        this.total=total;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Long idCarta) {
        this.idCarta = idCarta;
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    public BigDecimal getPrecioCarta() {
        return precioCarta;
    }

    public void setPrecioCarta(BigDecimal precioCarta) {
        this.precioCarta = precioCarta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
