package org.example._08_demo_spring_rest.controller;

import org.example._08_demo_spring_rest.dto.UserDtoReceive;
import org.example._08_demo_spring_rest.dto.UserDtoSend;
import org.example._08_demo_spring_rest.entity.User;
import org.example._08_demo_spring_rest.exception.NotFoundException;
import org.example._08_demo_spring_rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/user/")
public class UserController {

    private UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDtoSend>> getData (){
        List<User> users = userService.getALl();
        List<UserDtoSend> userDtoSends = new ArrayList<>();
        for (User user : users){
            userDtoSends.add(new UserDtoSend(user.getId(),user.getFirstname(),user.getLastname()));
        }

        return ResponseEntity.ok(userDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDtoSend> getDataById(@PathVariable("id") long id){
        User user = userService.getById(id);
        UserDtoSend userDtoSend = new UserDtoSend(user.getId(),user.getFirstname(),user.getLastname());
        return ResponseEntity.ok(userDtoSend);
    }

    @PostMapping
    public ResponseEntity<UserDtoSend> registerUser (@Validated @RequestBody UserDtoReceive userDtoReceive){
        User user = userService.create(userDtoReceive);
        UserDtoSend userDtoSend = new UserDtoSend(user.getId(),user.getFirstname(),user.getLastname());
        return new ResponseEntity<>(userDtoSend,HttpStatus.CREATED);
    }



}
