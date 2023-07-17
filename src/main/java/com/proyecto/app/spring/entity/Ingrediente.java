package com.proyecto.app.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Ingrediente_Carta")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_carta")
    private Long id;

    @Column(name="nombre_producto",nullable = false,length = 50)
    private String nombreProducto;

    @Column(name = "cant_producto", nullable = false, columnDefinition = "DECIMAL(8,3)")
    private BigDecimal cantidadProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_carta")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Carta carta;

    public Ingrediente() {
    }

    public Ingrediente(Long id,String nombreProducto,BigDecimal cantidadProducto,Carta carta) {
        this.id = id;
        this.nombreProducto=nombreProducto;
        this.cantidadProducto=cantidadProducto;
        this.carta=carta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigDecimal cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }
}
