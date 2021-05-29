package com.rosyidgrobogan.belajarspringapi.models.repositories;

import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // custom
    List<Product> findByNameContains(String name);

    // Mencari di table products berdasarkan name
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product  p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier); // apakah supplier itu ada di suppliers
}
