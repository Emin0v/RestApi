package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserRepositoryCustom userRepositoryCustom;

    @PostMapping
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userRepositoryCustom.save(userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(userRepositoryCustom.getAll());
    }
}
