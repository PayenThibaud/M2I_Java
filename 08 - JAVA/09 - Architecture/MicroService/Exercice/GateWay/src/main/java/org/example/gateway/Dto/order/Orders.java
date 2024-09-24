package org.example.gateway.Dto.order;

import lombok.Data;

@Data
public class Orders {
    private long id;
    private long userId;
    private String product;
}
