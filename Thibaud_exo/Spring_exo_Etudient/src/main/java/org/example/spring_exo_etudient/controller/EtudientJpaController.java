package org.example.spring_exo_etudient.controller;

import jakarta.validation.Valid;
import org.example.spring_exo_etudient.entity.Etudient;
import org.example.spring_exo_etudient.service.EtudientJpaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtudientJpaController {
    private final EtudientJpaService etudientJpaService;

    public EtudientJpaController(EtudientJpaService etudientJpaService) {
        this.etudientJpaService = etudientJpaService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("EtudientsNom", etudientJpaService.findAll());
        return "index";
    }

    @RequestMapping("/recherche")
    public String search(@RequestParam("nom") String nom, Model model) {
        List<Etudient> resultatsRecherche = etudientJpaService.findByNom(nom);
        model.addAttribute("EtudientsNom", resultatsRecherche);
        return "index";
    }

    @RequestMapping("/list-etudient")
    public String list(Model model) {
        model.addAttribute("Etudients", etudientJpaService.findAll());
        return "list-etudient";
    }

    @RequestMapping("/etudient/{name}")
    public String etudient(@PathVariable String name, Model model) {
        model.addAttribute("Name", name);
        model.addAttribute("Etudients", etudientJpaService.findByNom(name));
        return "etudient";
    }

    @RequestMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("etudient", new Etudient());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscription(
            @Valid @ModelAttribute("etudient") Etudient etudient,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inscription";
        } else {
            etudientJpaService.save(etudient);
            return "redirect:/";
        }
    }

    @RequestMapping("/Supprime/{id}")
    public String Supprime(@PathVariable int id) {
        etudientJpaService.delete(etudientJpaService.findById(id));
        return "redirect:/list-etudient";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Etudient etudient = etudientJpaService.findById(id);
        model.addAttribute("Etudient", etudient);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("Etudient") Etudient etudient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            etudientJpaService.save(etudient);
            return "redirect:/list-etudient";
        }
    }
}