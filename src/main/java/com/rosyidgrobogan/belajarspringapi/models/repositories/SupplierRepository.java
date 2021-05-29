package com.rosyidgrobogan.belajarspringapi.models.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    // supplier berdasarkan email
    Supplier findByEmail(String email);
    
}
