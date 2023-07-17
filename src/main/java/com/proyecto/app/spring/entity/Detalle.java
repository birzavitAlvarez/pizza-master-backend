package com.proyecto.app.spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="detalles_ventas")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_venta")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_carta")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Carta carta;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Venta venta;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "precio", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal precio;
    @Column(name = "total", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal total;


}
