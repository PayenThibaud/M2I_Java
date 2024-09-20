package org.example.correctionexercice2rest.controller;

import org.example.correctionexercice2rest.dto.director.DirectorDtoReceive;
import org.example.correctionexercice2rest.dto.director.DirectorDtoSend;
import org.example.correctionexercice2rest.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorDtoSend>> getAllDirector (){
        return ResponseEntity.ok(directorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDtoSend> getDirectorById (@PathVariable("id") long id){
        return ResponseEntity.ok(directorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DirectorDtoSend> createDirector (@Validated @RequestBody DirectorDtoReceive directorDtoReceive){
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.create(directorDtoReceive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDtoSend> updateDirector (@PathVariable("id")long id,@Validated @RequestBody DirectorDtoReceive directorDtoReceive){
        return ResponseEntity.ok(directorService.update(id,directorDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirector (@PathVariable("id")long id){
        directorService.delete(id);
        return ResponseEntity.ok("director with id :"+id+" is deleted");
    }
}
