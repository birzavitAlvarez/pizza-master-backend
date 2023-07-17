package com.proyecto.app.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta")
    private Long idCarta;

    @Column(name = "nombre_carta",nullable = false,length = 50)
    private String nombreCarta;

    @Column(name = "imagen_carta",nullable = false,length = 255)
    private String imagenCarta;

    @Column(name = "descripcion_carta",nullable = false,length = 255)
    private String descripcionCarta;

    @Column(name = "precio_carta", nullable = false, columnDefinition = "DECIMAL(6,3)")
    private BigDecimal precioCarta;

    @OneToMany(mappedBy = "carta", cascade = CascadeType.ALL)
    private Set<Ingrediente> ingredientes = new HashSet<>();

    @OneToMany(mappedBy = "carta", cascade = CascadeType.ALL)
    private Set<Detalle> detalles = new HashSet<>();
    public Carta() {
    }

    public Carta(Long id, String nombreCarta,String imagenCarta,String descripcionCarta, BigDecimal precioCarta) {
        this.idCarta = id;
        this.nombreCarta=nombreCarta;
        this.precioCarta=precioCarta;
        this.imagenCarta=imagenCarta;
        this.descripcionCarta=descripcionCarta;
    }

    public Long getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Long id) {
        this.idCarta = id;
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
