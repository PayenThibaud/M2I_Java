package org.example.gateway.Dto.order;

import lombok.Builder;
import lombok.Data;
import org.example.gateway.Dto.user.UserDtoSend;

@Data
@Builder
public class OrderDtoSend {
    private long id;
    private UserDtoSend user;
    private String product;
}
