package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import com.rosyidgrobogan.belajarspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
        return productService.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.removeOne(id);
    }
}
