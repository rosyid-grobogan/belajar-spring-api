package com.rosyidgrobogan.belajarspringapi.services;

import com.rosyidgrobogan.belajarspringapi.models.enities.Product;
import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import com.rosyidgrobogan.belajarspringapi.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepo;

    private final SupplierService supplierService;

    @Autowired
    public ProductService(ProductRepository productRepo, SupplierService supplierService) {
        this.productRepo = productRepo;
        this.supplierService = supplierService;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

    // supplier
    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if (product == null){
          throw new RuntimeException("Product with ID "+ productId + " not found");
        }
        product.getSuppliers().add(supplier);

        save(product);
//        long berapa = 5L;
    }

    public Product findByProductName(String name) {
        return productRepo.findProductByName(name);
    }

    public List<Product> findByProductNameLike(String name) {
        return productRepo.findProductByNameLike("%"+name+"%");
    }

    public List<Product> findByCategoryId(Long categoryId){
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findBySupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            // kebalikan product kosong
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
