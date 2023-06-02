package com.backend.inventory.models.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalogo")
public class CatalogoEntity {
    
    private static final long serialVersionUID = -9029874457232138092L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "extra_benefit", columnDefinition = "jsonb")
    private String imagenProductos;
    private String descripcion;
    private Boolean estado;

    //LLaves foráneas
    private Integer productoId;
}
