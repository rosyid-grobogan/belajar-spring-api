package com.rosyidgrobogan.belajarspringapi.models.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
