package com.rosyidgrobogan.belajarspringapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserData {

    @NotEmpty(message = "Isi Full Namenya dulu")
    private String fullName;

    @NotEmpty(message = "Isi emailnya dulu")
    private String email;

    @NotEmpty(message = "Isi passwordnya dulu")
    private String password;

    private String userRole;

}
