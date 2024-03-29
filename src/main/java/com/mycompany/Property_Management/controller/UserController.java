package com.mycompany.Property_Management.controller;

import com.mycompany.Property_Management.dto.UserDTO;
import com.mycompany.Property_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.register(userDTO);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO)
    {
        userDTO=userService.login(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
