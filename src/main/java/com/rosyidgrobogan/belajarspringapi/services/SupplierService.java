package com.rosyidgrobogan.belajarspringapi.services;

import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import com.rosyidgrobogan.belajarspringapi.models.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SupplierService {

    private final SupplierRepository supplierRepo;

    @Autowired
    public SupplierService(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }

    public Supplier findOne(Long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if (!supplier.isPresent()) {
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removeOne(Long id){
        supplierRepo.deleteById(id);
    }

    public Supplier findByEmail(String email) {
        return supplierRepo.findByEmail(email);
    }
}
