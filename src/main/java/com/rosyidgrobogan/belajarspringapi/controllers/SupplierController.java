package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.dto.ResponseData;
import com.rosyidgrobogan.belajarspringapi.dto.SearchData;
import com.rosyidgrobogan.belajarspringapi.dto.SupplierData;
import com.rosyidgrobogan.belajarspringapi.helpers.ModelMapperHelper;
import com.rosyidgrobogan.belajarspringapi.models.enities.Supplier;
import com.rosyidgrobogan.belajarspringapi.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    private final ModelMapper modelMapper;

    @Autowired
    public SupplierController(
            SupplierService supplierService,
            ModelMapper modelMapper)
    {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@RequestBody  @Valid SupplierData supplierData, Errors errors) {
        ResponseData<Supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError err : errors.getAllErrors()){
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // cara Mapper manual
//        Supplier supplier = new Supplier();
//        supplier.setName(supplierData.getName());
//        supplier.setAddress(supplierData.getAddress());
//        supplier.setEmail(supplierData.getEmail());

        // cara menggunakan ModelMapper (supplierData => Supplier)
        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id") Long id){
        return supplierService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Supplier>> update(@RequestBody SupplierData supplierData, Errors errors) {
        ResponseData<Supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError err : errors.getAllErrors()){
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // cara Mapper manual
//        Supplier supplier = new Supplier();
//        supplier.setName(supplierData.getName());
//        supplier.setAddress(supplierData.getAddress());
//        supplier.setEmail(supplierData.getEmail());

        // cara menggunakan ModelMapper (supplierData => Supplier)
        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/search/byemail")
    public Supplier findByEmail(@RequestBody SearchData searchData){
        return supplierService.findByEmail(searchData.getSearchKey());
    }

    @PostMapping("/search/byname")
    public List<Supplier> findByName(@RequestBody SearchData searchData){
        return supplierService.findByName(searchData.getSearchKey());
    }

    @PostMapping("/search/namestartwith")
    public List<Supplier> findByNameStartWith(@RequestBody SearchData searchData){
        return supplierService.findByNameStartWith(searchData.getSearchKey());
    }

    @PostMapping("/search/nameoremail")
    public List<Supplier> findByNameOrEmail(@RequestBody SearchData searchData){
        return supplierService.findByNameOrEmail(searchData.getSearchKey(), searchData.getOtherSearchKey());
    }

    @PostMapping("/search/bynamedesc")
    public List<Supplier> findByNameDesc(@RequestBody SearchData searchData){
        return supplierService.findByNameOrderByDesc(searchData.getSearchKey());
    }
}
