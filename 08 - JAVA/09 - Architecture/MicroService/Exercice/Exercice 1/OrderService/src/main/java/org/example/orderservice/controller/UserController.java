package org.example.orderservice.controller;

import org.example.orderservice.Dto.OrderDtoReceive;
import org.example.orderservice.entity.Orders;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class UserController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Orders>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getById (@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Orders>> getByUserId (@PathVariable long userId){
        return ResponseEntity.ok(service.getOrderByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Orders> save (@RequestBody OrderDtoReceive order){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> update (@PathVariable long id,@RequestBody OrderDtoReceive order){
        return ResponseEntity.ok(service.update(id,order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok("User supprimé");
    }
}
