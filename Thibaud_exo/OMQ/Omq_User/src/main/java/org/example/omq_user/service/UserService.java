package org.example.omq_user.service;

import org.example.omq_user.dto.UserDtoResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDtoResponse findById (int id);

    UserDtoResponse findByEmail (String email);
}
