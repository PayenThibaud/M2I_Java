package org.example.micro_exo_1suite.controller;

import org.example.micro_exo_1suite.dto.CommandeDtoReceive;
import org.example.micro_exo_1suite.dto.CommandeDtoSend;
import org.example.micro_exo_1suite.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping("/{id}")
    public ResponseEntity<CommandeDtoSend> getById(@PathVariable("id")int id){
        return ResponseEntity.ok(commandeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CommandeDtoSend>> getAll (){
        return ResponseEntity.ok(commandeService.getAll());
    }

    @PostMapping
    public ResponseEntity<CommandeDtoSend> create (@RequestBody CommandeDtoReceive commandeDtoReceive){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.save(commandeDtoReceive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable("id")int id){
        commandeService.delete(id);
        return ResponseEntity.ok("Livre supprimé");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeDtoSend> update (@PathVariable int id,@RequestBody CommandeDtoReceive commandeDtoReceive){
        return ResponseEntity.ok(commandeService.update(id,commandeDtoReceive));
    }
}
