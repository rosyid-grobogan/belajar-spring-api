package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.dto.CategoryData;
import com.rosyidgrobogan.belajarspringapi.dto.ResponseData;
import com.rosyidgrobogan.belajarspringapi.models.enities.Category;
import com.rosyidgrobogan.belajarspringapi.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<ResponseData<Category>> create(
            @RequestBody @Valid CategoryData categoryData,
            Errors errors)
    {
        ResponseData<Category> responseData = new ResponseData<>();

        if (errors.hasErrors()){
            for (ObjectError err: errors.getAllErrors()) {
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(responseData);
        }

        Category category = modelMapper.map(categoryData, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") Long id){
        return categoryService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(
            @RequestBody @Valid CategoryData categoryData,
            Errors errors)
    {
        ResponseData<Category> responseData = new ResponseData<>();

        if (errors.hasErrors()){
            for (ObjectError err: errors.getAllErrors()) {
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(responseData);
        }

        Category category = modelMapper.map(categoryData, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));

        return ResponseEntity.ok(responseData);
    }
}