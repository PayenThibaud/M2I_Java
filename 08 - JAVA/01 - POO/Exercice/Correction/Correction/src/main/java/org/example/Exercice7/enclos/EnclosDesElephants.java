package org.example.Exercice7.enclos;

import org.example.Exercice7.animaux.Elephant;
import org.example.Exercice7.animaux.Animal;
import org.example.Exercice7.interfaces.Enclos;

import java.util.ArrayList;
import java.util.List;

public class EnclosDesElephants implements Enclos {

    private final List<Elephant> elephants;

    public EnclosDesElephants() {
        elephants = new ArrayList<>();
    }

    public EnclosDesElephants(List<Elephant> elephants) {
        this.elephants = elephants;
    }


    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof Elephant elephant) {
            elephants.add(elephant);
            System.out.printf(
                    "%s à été ajouter à l'enclos des elephants qui compte maintenant %d membre%s!\n",
                    animal.getNom(), elephants.size(), (elephants.size()>1? "s" : "")
            );
        } else {
            System.out.println("l'animal n'est pas un Elephant ! Il n'a pas été ajouté à l'enclos!");
        }
    }

    @Override
    public void afficherAnimaux() {
        StringBuilder str = new StringBuilder();
        str.append("l'enclos possède ").append(elephants.size()).append(" membre").append((elephants.size()>1? "s": "")).append(":\n");
        for (Elephant l : elephants) {
            str.append(l).append("\n");
        }
        str.append("""
                                       .--.
                                   __{c.  .o}
                                 ~(    (\\ !_c)
                                  | |__| `--'
                                  |_|| |_|_|
                       _______.--,                _
                     ~(       {c .`     )/,\\//,, ;c) ,--.______
                      |  |__|   ,= | ,,'         .`-'. o}      )~
                      /_/_| |_|\\_\\ J        .-.   `- =,  |__|  |
                              ,,           !   :'  ~/ /|_| |_\\_\\
                            ,'    _______.!!,_,':  ~~~,
                           ;    ~(      !{c!. ,'      ;     ,--._______
                           ;     |  |__| ! ,=          ;   '.  o}      )~
                            ;  ~~'~~~~~'~'`~`~~        ;(_/,=,   |___| |
                             ,                     ,,)'     /_/|_| |_|_|
                     .--.     ',ejm,,//((,,\\\\(///,'
                   {c.  .o}___
                     ,! !)    )~
                     | !!___| |
                     |_|J_\\|_\\_\\
                """);

        System.out.print(str);
    }


    @Override
    public String toString() {
        return String.format("Enclos(%d elephant%s)", elephants.size(), (elephants.size()>1? "s" : ""));
    }
}
