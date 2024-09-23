package org.example.authorapi.controller;

import org.example.authorapi.dto.AuthorDtoReceive;
import org.example.authorapi.entity.Author;
import org.example.authorapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById (@PathVariable("id")long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Author> save (@RequestBody AuthorDtoReceive authorDtoReceive){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(authorDtoReceive));
    }
}
