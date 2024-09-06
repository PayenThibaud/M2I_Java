package org.example.exo4;

import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private List<String> villes = Arrays.asList("Paris","Lille", "Lyon", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");


    public List<String> rechercher(String mot)  {

        if(mot.equals("*")){
            return villes;
        }


        if(mot.length() < 2){
            throw new NotFoundException();
        }

        List<String> villesRecherche = villes.stream().filter(v -> v.toUpperCase().contains(mot.toUpperCase())).toList();
    return villesRecherche;
    }
}