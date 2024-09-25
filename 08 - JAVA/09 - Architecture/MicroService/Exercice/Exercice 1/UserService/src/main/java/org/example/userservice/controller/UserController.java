package org.example.userservice.controller;

import org.example.userservice.Dto.UserDtoReceive;
import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById (@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<User> save (@RequestBody UserDtoReceive user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update (@PathVariable long id,@RequestBody UserDtoReceive user){
        return ResponseEntity.ok(service.update(id,user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok("User supprimé");
    }
}
