package com.backend.inventory.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedores")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Long id;

    @Column(name = "nombre")
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @Column(name = "direccion")
    @NotNull(message = "La dirección es requerida")
    private String address;

    @Column(name = "telefono")
    @NotNull(message = "El telefono es requerido")
    private String phone;

    @Column(name = "email")
    private String email;

    @NotNull(message = "El lugar de origen es requerido")
    @Column(name = "lugar_origen")
    private String originPlace;

    @Column(name = "estado")
    private boolean status;

    @Column(name = "fecha_vinculacion")
    private LocalDate bindingDate;

    @Column(name = "fecha_desvinculacion")
    private LocalDate terminationDate;
}