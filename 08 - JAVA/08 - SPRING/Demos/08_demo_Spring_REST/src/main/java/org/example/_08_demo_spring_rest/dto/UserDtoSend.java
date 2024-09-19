package org.example._08_demo_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoSend {
    private long id;
    private String firstname;
    private String lastname;
}
