package org.example.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.gateway.Dto.order.OrderDtoReceive;
import org.example.gateway.Dto.order.OrderDtoSend;
import org.example.gateway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService service;


    @GetMapping("{id}")
    public ResponseEntity<OrderDtoSend> getById (@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderDtoSend>> getById (){
        return ResponseEntity.ok(service.getAll());
    }


    @PostMapping
    public ResponseEntity<OrderDtoSend> save (@RequestBody OrderDtoReceive orderDtoReceive) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(orderDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        if(service.delete(id)){
            return ResponseEntity.ok( "order deleted" );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order not delete");
    }

    @PutMapping("/{id}")
    public  ResponseEntity<OrderDtoSend> update (@PathVariable long id,@RequestBody OrderDtoReceive orderDtoReceive) throws JsonProcessingException {
        return ResponseEntity.ok(service.update(id,orderDtoReceive));
    }
}
