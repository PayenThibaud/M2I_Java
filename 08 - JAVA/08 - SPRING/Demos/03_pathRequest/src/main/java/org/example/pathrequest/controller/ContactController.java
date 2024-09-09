package org.example.pathrequest.controller;

import org.example.pathrequest.model.Contact;
import org.example.pathrequest.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
