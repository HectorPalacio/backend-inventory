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
@Table(name = "producto")
public class ProductoEntity {
    
    private static final long serialVersionUID = -9029874457232138092L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Double valorUnitario;
    private String descripcion;
    private Boolean estado;

    //Llaves foráneas
    private Integer proveedorId;
    private Integer almacenId;
}
