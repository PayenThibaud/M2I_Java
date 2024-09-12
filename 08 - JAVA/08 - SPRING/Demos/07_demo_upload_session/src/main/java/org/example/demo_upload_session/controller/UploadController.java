package org.example.demo_upload_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UploadController {
    private String location = "src/main/resources/static/image";

    @RequestMapping("/upload")
    public String form(){
        return "upload-form";
    }

    @PostMapping("/upload")
    // IOException est souvent utilisé pour signaler les erreurs lors de la lecture ou l'écriture de fichier externe.
    public String postForm(@RequestParam("image")MultipartFile image) throws IOException {
        // Cette ligne construit le chemin absolu où le fichier téléchargé sera enregistré.
        Path destinationFile = Paths.get(location).resolve(image.getOriginalFilename()).toAbsolutePath();
        // Récupère un flux d'entrée du fichier téléchargé
        InputStream inputStream = image.getInputStream();
        // Copie le contenu du flux vers la destination
        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        return "redirect:/upload";
    }
}
