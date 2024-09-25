package org.example.omq_user.controller;

import org.example.omq_user.dto.UserDtoRequest;
import org.example.omq_user.dto.UserDtoResponse;
import org.example.omq_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findById (@PathVariable int id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/findbyemail")
    public ResponseEntity<UserDtoResponse> findByEmail (@RequestBody UserDtoRequest userDtoRequest){
        return new ResponseEntity<>(userService.findByEmail(userDtoRequest.getEmail()),HttpStatus.OK);
    }
}
