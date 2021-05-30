package com.rosyidgrobogan.belajarspringapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryData {

    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;
}
