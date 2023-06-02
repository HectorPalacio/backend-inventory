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
    public List<SupplierResponse> findAll(Pageable pageable) {
        return supplierRepository.findAll(pageable).getContent().stream().map(this::convertToResponse).toList();
    }

    @Override
    public Optional<SupplierResponse> findById(long id) {
        return supplierRepository.findById(id).map(this::convertToResponse);
    }

    @Override
    public SupplierResponse save(SupplierRequest supplierRequest) {
        Supplier supplier = supplierRepository.save(this.convertToEntity(supplierRequest));
        return this.convertToResponse(supplier);
    }

    private SupplierResponse convertToResponse(Supplier supplier){
        return modelMapper.map(supplier, SupplierResponse.class);
    }

    private Supplier convertToEntity(SupplierRequest supplierRequest){
        return modelMapper.map(supplierRequest, Supplier.class);
    }
}
