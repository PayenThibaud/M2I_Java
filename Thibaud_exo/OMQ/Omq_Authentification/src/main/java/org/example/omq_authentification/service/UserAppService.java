package org.example.omq_authentification.service;

import org.example.omq_authentification.dto.RegisterRequestDto;
import org.example.omq_authentification.entity.UserApp;
import org.example.omq_authentification.exception.UserAlreadyExistException;
import org.example.omq_authentification.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {

    private final UserAppRepository userRepository;

    public UserAppService(UserAppRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserApp enregistrerUtilisateur(RegisterRequestDto registerRequestDto) throws UserAlreadyExistException {
        Optional<UserApp> userAppOptional = userRepository.findByEmail(registerRequestDto.getEmail());
        if(userAppOptional.isEmpty()){
            UserApp user = new UserApp(registerRequestDto.getEmail(), registerRequestDto.getLastname(), registerRequestDto.getFirstname(), registerRequestDto.getPhone(), registerRequestDto.getPassword(),0);
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException();
    }
}
