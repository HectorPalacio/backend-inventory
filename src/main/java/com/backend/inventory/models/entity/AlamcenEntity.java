package com.backend.inventory.models.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "almacen")
public class AlamcenEntity {

    private static final long serialVersionUID = -9029874457232138092L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer cantidad_stock;
    private Date fecha_ingreso;
}
