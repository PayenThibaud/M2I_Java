package org.example.exo4;

import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private List<String> villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");


    public List<String> rechercher(String mot)  {
        if(mot.length() < 2){
            throw new NotFoundException();
        }

        List<String> villesRecherche = villes.stream().filter(v);
    return null;
    }
}