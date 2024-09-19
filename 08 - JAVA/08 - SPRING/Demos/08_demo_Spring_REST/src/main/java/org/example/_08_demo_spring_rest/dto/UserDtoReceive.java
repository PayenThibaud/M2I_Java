package org.example._08_demo_spring_rest.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoReceive {
    @Size(min=3,max=20)
    private String firstname;
    @Size(min=3,max=20)
    private String lastname;
    private String password;
}
