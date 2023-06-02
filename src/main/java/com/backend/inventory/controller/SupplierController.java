package com.backend.inventory.controller;


import com.backend.inventory.dto.requests.SupplierRequest;
import com.backend.inventory.dto.responses.SupplierResponse;
import com.backend.inventory.services.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "true") boolean status
    ) {
        Pageable paging = PageRequest.of(page, size);
        List<SupplierResponse> supplierResponses = supplierService.findAll(status, paging);
        if (supplierResponses.isEmpty())
            return ResponseEntity.accepted().body(supplierResponses);

        return ResponseEntity.ok(supplierResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SupplierResponse>> findById(
            @PathVariable("id") long id
    ) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> save(
            @Valid @RequestBody SupplierRequest supplierRequest
    ) {
        return ResponseEntity.ok(supplierService.save(supplierRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(
            @PathVariable("id") int id,
            @Valid @RequestBody SupplierRequest supplierRequest
    ) {
        if (supplierService.findById(id).isEmpty())
            return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(supplierService.update(id, supplierRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierResponse> delete(
            @PathVariable("id") int id
    ) {
        if (supplierService.findById(id).isEmpty())
            return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(supplierService.deleteById(id));
    }
}
