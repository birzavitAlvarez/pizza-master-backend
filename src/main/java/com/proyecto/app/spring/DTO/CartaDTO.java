package com.proyecto.app.spring.DTO;

import com.proyecto.app.spring.entity.Detalle;
import com.proyecto.app.spring.entity.Ingrediente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CartaDTO {
    private Long idCarta;
    private String nombreCarta;
    private String imagenCarta;
    private String descripcionCarta;
    private BigDecimal precioCarta;
    private Set<Ingrediente> ingredientes;

    private Set<Detalle> detalles = new HashSet<>();

    public CartaDTO() {
    }

    public CartaDTO(Long idCarta,String nombreCarta,String imagenCarta,String descripcionCarta,BigDecimal precioCarta,Set<Ingrediente>ingredientes,Set<Detalle>detalles) {
        this.idCarta = idCarta;
        this.nombreCarta=nombreCarta;
        this.imagenCarta=imagenCarta;
        this.descripcionCarta=descripcionCarta;
        this.precioCarta=precioCarta;
        this.ingredientes=ingredientes;
        this.detalles=detalles;
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

    public String getImagenCarta() {
        return imagenCarta;
    }

    public void setImagenCarta(String imagenCarta) {
        this.imagenCarta = imagenCarta;
    }

    public String getDescripcionCarta() {
        return descripcionCarta;
    }

    public void setDescripcionCarta(String descripcionCarta) {
        this.descripcionCarta = descripcionCarta;
    }

    public BigDecimal getPrecioCarta() {
        return precioCarta;
    }

    public void setPrecioCarta(BigDecimal precioCarta) {
        this.precioCarta = precioCarta;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }
}
