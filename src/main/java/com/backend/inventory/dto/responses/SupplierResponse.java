package com.backend.inventory.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String originPlace;
    private boolean status;
    private LocalDate bindingDate;
    private LocalDate terminationDate;
}
