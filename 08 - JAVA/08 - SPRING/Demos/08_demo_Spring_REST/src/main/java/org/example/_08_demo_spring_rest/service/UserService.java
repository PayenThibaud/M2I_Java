package org.example._08_demo_spring_rest.service;

import org.example._08_demo_spring_rest.dto.UserDtoReceive;
import org.example._08_demo_spring_rest.entity.User;
import org.example._08_demo_spring_rest.exception.NotFoundException;
import org.example._08_demo_spring_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById (long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User create (UserDtoReceive userDtoReceive){
        User userCreated = User.builder()
                .firstname(userDtoReceive.getFirstname())
                .lastname(userDtoReceive.getLastname())
                .password(userDtoReceive.getPassword())
                .build();

        return userRepository.save(userCreated);
    }

    public List<User> getALl (){
        return (List<User>) userRepository.findAll();
    }
}
