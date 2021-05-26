package com.rosyidgrobogan.belajarspringapi.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // custom
    List<Product> findByNameContains(String name);
}
