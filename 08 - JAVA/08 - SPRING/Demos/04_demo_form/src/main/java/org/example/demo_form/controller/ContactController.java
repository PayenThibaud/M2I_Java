package org.example.demo_form.controller;

import org.example.demo_form.model.Contact;
import org.example.demo_form.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller()
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/")
    public String homePage(){
        return "pagea";
    }

    @RequestMapping("/detail/{contactId}")
    public String detailPage(@PathVariable("contactId")UUID id, Model model){
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "pagec";
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("contacts", contactService.getAllContacts());
        return "pageb";
    }

    @RequestMapping("/search") // /search?contactName=Toto
    public String searchContact(@RequestParam(name = "contactName", required = false) String name, Model model){
        Contact contact = contactService.getContactByName(name);

        if (contact != null) {
            model.addAttribute("contact", contact);
            return "pagec";
        } else {
            return "pagea";
        }
    }

    @RequestMapping("/formulaire")
    public String formulaire(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/add")
    public String submitContact(@ModelAttribute("contact") Contact contact){
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getAge());
        // Modification du post pour vérifier s'il y a un contact
        return "redirect:/list";
    }

    // Suite du crud
    @RequestMapping("/delete")
    public String delete(@RequestParam("contactId") UUID id){
        System.out.println("delete");
        return "redirect:/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("contactId") UUID id, Model model){
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "form";
    }
}
