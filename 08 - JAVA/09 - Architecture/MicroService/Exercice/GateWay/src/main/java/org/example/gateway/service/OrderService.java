package org.example.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.order.OrderDtoReceive;
import org.example.gateway.Dto.order.OrderDtoSend;
import org.example.gateway.Dto.order.Orders;
import org.example.gateway.Dto.user.UserDtoReceive;
import org.example.gateway.Dto.user.UserDtoSend;
import org.example.gateway.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private ObjectMapper om;

    @Autowired
    private UserSercice userSercice;

    public OrderService() {
        this.om =  new ObjectMapper();
    }

    public OrderDtoSend save(OrderDtoReceive order) throws JsonProcessingException {
        RestClient<Orders> userClient = new RestClient<>("http://localhost:8082/api/order");
        Orders orderReceive = userClient.postRequest(om.writeValueAsString(order),Orders.class);
        return orderToOrderDtoSend(orderReceive);
    }

    public OrderDtoSend getById (long id){
        RestClient<Orders> orderClient = new RestClient<>("http://localhost:8082/api/order/"+id);
        Orders order = orderClient.getRequest(Orders.class);
        return orderToOrderDtoSend(order);
    }

    public List<OrderDtoSend> getAll (){
        RestClient<Orders[]> orderClient = new RestClient<>("http://localhost:8081/api/user");
        List<Orders> orders = Arrays.stream(orderClient.getRequest(Orders[].class)).toList();
        return orders.stream().map(this::orderToOrderDtoSend).toList();
    }

    public boolean delete (long id){
        RestClient<Orders> orderClient = new RestClient<>("http://localhost:8082/api/order/"+id);
        String response = orderClient.deleteRequest();
        if(response != null){
            return true;
        }
        return false;
    }

    public OrderDtoSend update (long id , OrderDtoReceive orderDtoReceive) throws JsonProcessingException {
        RestClient<Orders> userClient = new RestClient<>("http://localhost:8082/api/order/"+id);
        Orders orderReceive = userClient.putRequest(om.writeValueAsString(orderDtoReceive),Orders.class);
        return orderToOrderDtoSend(orderReceive);
    }

    private OrderDtoSend orderToOrderDtoSend (Orders orders){
        return OrderDtoSend.builder()
                .id(orders.getId())
                .user(userSercice.getById(orders.getUserId()))
                .product(orders.getProduct())
                .build();
    }

}
