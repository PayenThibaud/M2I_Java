package org.example.userservice.service;

import org.example.userservice.Dto.UserDtoReceive;
import org.example.userservice.Repository.UserRepository;
import org.example.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User save (UserDtoReceive userDtoReceive){
        User user = User.builder()
                .name(userDtoReceive.getName())
                .email(userDtoReceive.getEmail())
                .build();

        return repository.save(user);
    }

    public User getById (long id){
        return repository.findById(id).orElseThrow();
    }

    public List<User> findAll (){
        return repository.findAll();
    }

    public User update (long id, UserDtoReceive userDtoReceive){
        User user = getById(id);
        user.setName(userDtoReceive.getName());
        user.setEmail(userDtoReceive.getEmail());

        return repository.save(user);
    }

    public void delete (long id){
        repository.delete(getById(id));
    }
}
