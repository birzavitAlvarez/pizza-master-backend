package com.proyecto.app.spring.DTO;

import java.math.BigDecimal;

public class IngredienteDTO {
    private Long id;
    private String nombreProducto;
    private BigDecimal cantidadProducto;
    private Long idCarta;
    private String nombreCarta;

    public IngredienteDTO(){
    }
    public IngredienteDTO(Long id,String nombreProducto, BigDecimal cantidadProducto,Long idCarta,String nombreCarta){
        this.id=id;
        this.nombreProducto=nombreProducto;
        this.cantidadProducto=cantidadProducto;
        this.idCarta=idCarta;
        this.nombreCarta=nombreCarta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigDecimal cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
