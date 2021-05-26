package com.rosyidgrobogan.belajarspringapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryData {

    @NotEmpty(message = "Name is required")
    private String name;
}
