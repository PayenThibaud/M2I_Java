package org.example.omq_user.service;

import org.apache.catalina.User;
import org.example.omq_user.dto.UserDtoResponse;
import org.example.omq_user.entity.UserApp;
import org.example.omq_user.exception.NotFoundException;
import org.example.omq_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceClass implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceClass(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDtoResponse findById(int id) {
        Optional<UserApp> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            UserApp userApp = userOptional.get();
            return new UserDtoResponse(userApp.getId_user(),userApp.getEmail(),userApp.getLastname(),userApp.getFirstname(),userApp.getPhone(),userApp.getRole().ordinal());
        }
        throw new NotFoundException();
    }

    @Override
    public UserDtoResponse findByEmail(String email) {
        UserApp userApp = userRepository.findByEmail(email);
        if(userApp != null){
            return new UserDtoResponse(userApp.getId_user(),userApp.getEmail(), userApp.getLastname(), userApp.getFirstname(), userApp.getPhone(), userApp.getRole().ordinal());
        }
        return null;
    }
}
