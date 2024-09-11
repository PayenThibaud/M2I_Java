package org.example.spring_exo_etudient.controller;

import org.example.spring_exo_etudient.model.Etudient;
import org.example.spring_exo_etudient.service.EtudientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtudientController {

    private final EtudientService etudientService;

    public EtudientController(EtudientService etudientService) {
        this.etudientService = etudientService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("EtudientsNom",etudientService.getEtudients());
        return "index";
    }

    @RequestMapping("/recherche")
    public String search(@RequestParam("nom") String nom, Model model) {
        List<Etudient> resultatsRecherche = etudientService.getEtudientsByName(nom);
        model.addAttribute("EtudientsNom", resultatsRecherche);
        return "index";
    }

    @RequestMapping ("/list-etudient")
    public String list(Model model){
        model.addAttribute("Etudients", etudientService.getEtudients());
        return "list-etudient";
    }

    @RequestMapping("/etudient/{name}")
    public String etudient(@PathVariable String name, Model model){
        model.addAttribute("Name",name);
        model.addAttribute("Etudients", etudientService.getEtudientsByName(name));
        return "etudient";
    }

    @RequestMapping("/inscription")
    public String inscription() {
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscription(
            @RequestParam String prenom,
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam int age,
            Model model) {

        Etudient etudient = Etudient.builder()
                .prenom(prenom)
                .nom(nom)
                .email(email)
                .agee(age)
                .build();
        etudientService.setEtudients(etudient);
        return "redirect:/";
    }

    @RequestMapping("/Supprime/{id}")
    public String Supprime(@PathVariable int id) {
        etudientService.deleteEtudientByID(id);
        return "redirect:/list-etudient";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Etudient etudient = etudientService.getEtudientById(id);
        model.addAttribute("Etudient", etudient);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("etudient") Etudient etudient, Model model) {
        etudientService.updateEtudient(etudient);
        return "redirect:/list-etudient";
    }


}
