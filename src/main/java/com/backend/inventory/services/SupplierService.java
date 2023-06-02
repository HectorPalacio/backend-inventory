package com.backend.inventory.services;

import com.backend.inventory.dto.requests.SupplierRequest;
import com.backend.inventory.dto.responses.SupplierResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierResponse> findAll(Pageable pageable);
    Optional<SupplierResponse> findById(long id);
    SupplierResponse save(SupplierRequest supplierRequest);
    SupplierResponse update(long id, SupplierRequest supplierRequest);
    SupplierResponse deleteById(long supplierId);
}
