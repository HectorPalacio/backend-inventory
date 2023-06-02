package com.backend.inventory.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequest {
    private String name;
    @NotNull(message = "La dirección es requerida")
    private String address;
    @NotNull(message = "El telefono es requerido")
    private String phone;
    private String email;
    @NotNull(message = "El lugar de origen es requerido")
    private String originPlace;
    private boolean status;
    private LocalDate bindingDate;
    private LocalDate terminationDate;
}
