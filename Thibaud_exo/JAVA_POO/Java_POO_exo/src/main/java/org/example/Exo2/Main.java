package org.example.Exo2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("Titi", 0, 0);

        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.validerLaQuete();
        joueur1.monterDeNiveau();
        joueur1.validerLaQuete();
        joueur1.monterDeNiveau();
    }
}