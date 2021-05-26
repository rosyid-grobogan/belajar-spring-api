package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import com.rosyidgrobogan.belajarspringapi.repositories.ProductRepository;
import com.rosyidgrobogan.belajarspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    private final ProductRepository productRepo;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepo) {
        this.productService = productService;
        this.productRepo = productRepo;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product findOne(@PathVariable("id") Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return productService.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Boolean product = productRepo.existsById(id);
        if (product) {
            productService.removeOne(id);
        }
    }
}
