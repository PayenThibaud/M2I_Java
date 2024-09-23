package org.example.authorapi.service;

import org.example.authorapi.dto.AuthorDtoReceive;
import org.example.authorapi.entity.Author;
import org.example.authorapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public Author save (AuthorDtoReceive authorDtoReceive){
        Author author = Author.builder()
                .firstName(authorDtoReceive.getFirstName())
                .lastName(authorDtoReceive.getLastName())
                .nationality(authorDtoReceive.getNationality())
                .build();

        return repository.save(author);
    }

    public Author getById (long id){
        return repository.findById(id).orElseThrow();
    }
}
