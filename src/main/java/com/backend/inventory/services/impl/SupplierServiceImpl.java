package com.backend.inventory.services.impl;

import com.backend.inventory.dto.requests.SupplierRequest;
import com.backend.inventory.dto.responses.SupplierResponse;
import com.backend.inventory.infrastructure.entities.Supplier;
import com.backend.inventory.infrastructure.repositories.SupplierRepository;
import com.backend.inventory.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;

    public SupplierServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public List<SupplierResponse> findAll(boolean status, Pageable pageable) {
        return supplierRepository.findAllByStatus(status, pageable).getContent().stream().map(this::convertToResponse).toList();
    }

    @Override
    public Optional<SupplierResponse> findById(long id) {
        return supplierRepository.findById(id).map(this::convertToResponse);
    }

    @Override
    public SupplierResponse save(SupplierRequest supplierRequest) {
        Supplier supplier = this.convertToEntity(supplierRequest);
        supplier.setStatus(true);
        supplier.setBindingDate(LocalDate.now());
        Supplier supplierResponse = supplierRepository.save(supplier);
        return this.convertToResponse(supplierResponse);
    }

    @Override
    public SupplierResponse update(long id, SupplierRequest supplierRequest) {
        Supplier supplier = convertToEntity(supplierRequest);
        supplier.setId(id);
        return convertToResponse(supplierRepository.save(supplier));
    }

    @Override
    public SupplierResponse deleteById(long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow();
        supplier.setStatus(false);
        supplier.setTerminationDate(LocalDate.now());
        return this.convertToResponse(supplierRepository.save(supplier));
    }

    private SupplierResponse convertToResponse(Supplier supplier){
        return modelMapper.map(supplier, SupplierResponse.class);
    }

    private Supplier convertToEntity(SupplierRequest supplierRequest){
        return modelMapper.map(supplierRequest, Supplier.class);
    }
}
