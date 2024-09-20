package org.example.correctionexercice2rest.service;

import org.example.correctionexercice2rest.Exception.NotFoundException;
import org.example.correctionexercice2rest.dto.director.DirectorDtoReceive;
import org.example.correctionexercice2rest.dto.director.DirectorDtoSend;
import org.example.correctionexercice2rest.entity.Director;
import org.example.correctionexercice2rest.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService implements BaseService<DirectorDtoReceive, DirectorDtoSend> {

    @Autowired
    private DirectorRepository repository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public DirectorDtoSend create(DirectorDtoReceive received) {
        Director director = Director.builder()
                .firstname(received.getFirstname())
                .lastname(received.getLastname())
                .nationality(received.getNationality())
                .birthDate(LocalDate.parse(received.getBirthDateStr(),dateFormatter))
                .build();

        repository.save(director);
        return directorToDirectorDtoSend(director);
    }

    @Override
    public DirectorDtoSend update(long id, DirectorDtoReceive received) {
        Director director = getDirectorById(id);
        director.setFirstname(received.getFirstname());
        director.setLastname(received.getLastname());
        director.setNationality(received.getNationality());
        director.setBirthDate(LocalDate.parse(received.getBirthDateStr(),dateFormatter));

        repository.save(director);
        return directorToDirectorDtoSend(director);
    }

    @Override
    public boolean delete(long id) {
        Director director = getDirectorById(id);
        repository.delete(director);
        return true;
    }

    @Override
    public DirectorDtoSend findById(long id) {
        return directorToDirectorDtoSend(getDirectorById(id));
    }

    @Override
    public List<DirectorDtoSend> getAll() {
        return directorsToDirectorDtoSends((List<Director>) repository.findAll());
    }

    public Director getDirectorById (long id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("director not found at id :"+id));
    }

    public DirectorDtoSend directorToDirectorDtoSend (Director director){
        return DirectorDtoSend.builder()
                .id(director.getId())
                .firstname(director.getFirstname())
                .lastname(director.getLastname())
                .birthDate(director.getBirthDate())
                .nationality(director.getNationality())
                .films(director.getFilms())
                .build();
    }

    public List<DirectorDtoSend> directorsToDirectorDtoSends (List<Director> directors){
        return directors.stream().map(this::directorToDirectorDtoSend).collect(Collectors.toList());
    }
}
