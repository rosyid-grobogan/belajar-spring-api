package com.rosyidgrobogan.belajarspringapi.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class SupplierData {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;
}
