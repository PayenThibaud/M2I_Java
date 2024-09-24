package org.example.orderservice.service;

import org.example.orderservice.Dto.OrderDtoReceive;
import org.example.orderservice.Repository.OrderRepository;

import org.example.orderservice.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Orders save (OrderDtoReceive OrderDtoReceive){
        Orders Order = Orders.builder()
                .userId(OrderDtoReceive.getUserId())
                .product(OrderDtoReceive.getProduct())
                .build();

        return repository.save(Order);
    }

    public Orders getById (long id){
        return repository.findById(id).orElseThrow();
    }

    public List<Orders> findAll (){
        return repository.findAll();
    }

    public Orders update (long id, OrderDtoReceive OrderDtoReceive){
        Orders Order = getById(id);
        Order.setProduct(OrderDtoReceive.getProduct());
        Order.setUserId(OrderDtoReceive.getUserId());

        return repository.save(Order);
    }

    public void delete (long id){
        repository.delete(getById(id));
    }

    public List<Orders> getOrderByUserId (long userId){
        return repository.findByUserId(userId);
    }
}
