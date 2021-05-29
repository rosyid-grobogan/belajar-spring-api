package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.dto.ResponseData;
import com.rosyidgrobogan.belajarspringapi.dto.SupplierData;
import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import com.rosyidgrobogan.belajarspringapi.models.repositories.ProductRepository;
import com.rosyidgrobogan.belajarspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(
                        @RequestBody @Valid Product product,
                        Errors errors)
    {
        ResponseData<Product> responseData = new ResponseData();

        if (errors.hasErrors()) {

            for (ObjectError err: errors.getAllErrors()) {
//                System.out.println("getAllErrors(): " + err.getDefaultMessage());
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseData);
//            throw  new RuntimeException("Validation error");
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product)); // TODO: ini bisa terjadi error

        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id) {
//        Optional<Product> product = productRepo.findById(id);
//        if (!product.isPresent()) {
//            return null;
//        }
        return productService.findOne(id);
    }

//    @PutMapping
//    public Product update(@RequestBody Product product) {
//        return productService.save(product);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Boolean product = productRepo.existsById(id);
        if (product) {
            productService.removeOne(id);
        }
    }

    @PostMapping("/{id}")
    public void addSupplier(
            @RequestBody Supplier supplier,
            @PathVariable("id") Long productId)
    {
        productService.addSupplier(supplier, productId);
    }
}
