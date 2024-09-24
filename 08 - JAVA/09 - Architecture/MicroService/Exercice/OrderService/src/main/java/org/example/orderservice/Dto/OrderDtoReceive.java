package org.example.orderservice.Dto;

import lombok.Data;

@Data
public class OrderDtoReceive {
    private long userId;
    private String product;
}
