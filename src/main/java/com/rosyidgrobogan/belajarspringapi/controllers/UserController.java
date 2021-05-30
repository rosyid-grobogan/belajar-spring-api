package com.rosyidgrobogan.belajarspringapi.controllers;

import com.rosyidgrobogan.belajarspringapi.dto.ResponseData;
import com.rosyidgrobogan.belajarspringapi.dto.UserData;
import com.rosyidgrobogan.belajarspringapi.models.enities.User;
import com.rosyidgrobogan.belajarspringapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ResponseData<User>> register(
            @RequestBody UserData userData,
            Errors errors)
    {
        ResponseData<User> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError err: errors.getAllErrors()) {
                responseData.getMessage().add(err.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseData);
        }

        User user = modelMapper.map(userData, User.class);
        // bisa ditambahkan proses validasi sendiri
        responseData.setPayload(userService.registerUser(user));
        responseData.setStatus(true);
        responseData.getMessage().add("User saved");

        return ResponseEntity.ok(responseData);
    }
}
