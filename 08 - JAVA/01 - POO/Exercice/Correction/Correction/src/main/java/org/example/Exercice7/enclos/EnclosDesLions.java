package org.example.Exercice7.enclos;

import org.example.Exercice7.animaux.Lion;
import org.example.Exercice7.animaux.Animal;
import org.example.Exercice7.interfaces.Enclos;

import java.util.ArrayList;
import java.util.List;

public class EnclosDesLions implements Enclos {
    private final List<Lion> lions;

    public EnclosDesLions() {
        lions = new ArrayList<>();
    }

    public EnclosDesLions(List<Lion> lions) {
        this.lions = lions;
    }


    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof Lion lion) {
            lions.add(lion);
            System.out.printf(
                "%s à été ajouter à l'enclos des lions qui compte maintenant %d membre%s!\n",
                animal.getNom(), lions.size(), (lions.size()>1? "s" : "")
            );
        } else {
            System.out.println("l'animal n'est pas un Lion ! Il n'a pas été ajouté à l'enclos!");
        }
    }

    @Override
    public void afficherAnimaux() {
        StringBuilder str = new StringBuilder();
        str.append("l'enclos possède ").append(lions.size()).append(" membre").append((lions.size()>1? "s": "")).append(":\n");
        for (Lion l : lions) {
            str.append(l).append("\n");
        }
        str.append("""
                
                                                                              .oOOOOo.
                              ...oO                                 .oOOOo.oOOOOOOOOOOOo
                                                          .oOOOo.oOOOOOOOOOOOOOOOOOOOOOOO
                                                 .oOOOo.oOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
                                                ""\"""\"""\"""\"""\"""\"""\"""\"""\"""\"""\"""\"""\"""
                    ...oO
                                 ...oO                ...o                             __
                                            \\|\\||             |\\          __      _.--"  "-.
                                            -- |||/         -' | \\    _.-"  ""-.-"
                                           /7   |||/    __./7     \\.-"
                             __..--._  _.-/    |||||/.-"  /        `-_
                ..--""--.--'"        ""   \\-' |||||||/`-._\\-'_        `-._____________
                ___________________________-|||||||||      -- \\                   /   \\_____
                               V     v       |/||||           /                  /     \\
                 V    \\|/             _______/    /_  _______/    /_       _____|_____  |-,
                                     /,__________/  `/,__________/__`-.___/,__(____________)
                         \\|/   v           |\\      _,,,---,,_           v
                  \\/                       /,`.-'`'    -.  ;-;;,_             \\|/       V
                            \\/       v    |,4-  ) )-,_..;\\ (  `'-'   \\/
                      V         \\|/      '---''(_/--'  `-'\\_)  v          v       \\/      v
                \\|/       \\/          v            \\|/            \\/          V       \\|/
                """);

        System.out.print(str);
    }

    @Override
    public String toString() {
        return String.format("Enclos(%d lion%s)", lions.size(), (lions.size()>1? "s" : ""));
    }
}
