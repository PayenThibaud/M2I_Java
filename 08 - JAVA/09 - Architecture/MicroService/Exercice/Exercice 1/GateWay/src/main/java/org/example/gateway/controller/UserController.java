package org.example.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.example.gateway.Dto.user.UserDtoReceive;
import org.example.gateway.Dto.user.UserDtoSend;
import org.example.gateway.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserSercice sercice;

    @GetMapping
    public ResponseEntity<List<UserDtoSend>> getAll (){
        return ResponseEntity.ok(sercice.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoSend> getById (@PathVariable long id){
        return ResponseEntity.ok(sercice.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserDtoSend> add (@RequestBody UserDtoReceive userDtoReceive) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(sercice.saveUser(userDtoReceive));
    }
}
