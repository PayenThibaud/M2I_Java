package org.example.strategy.exo.ihm.menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuUtils {

    public static void printMenu(Menu menu) {
        int barSize = menu.getName().length() + 4;
        StringBuilder str = new StringBuilder();
        str.append("=".repeat(barSize)).append("\n  ").append(menu.getName()).append("\n").append("=".repeat(barSize));
        str.append("\n\n");
        if (menu.getDescription() != null) {
            str.append(menu.getDescription());
        } else {
            str.append("Veuillez choisir une option :");
        }
        str.append("\n");

        for (int i = 0; i < menu.getOptions().size(); i++) {
            str.append(i + 1).append(". ").append(menu.getOptions().get(i).getName()).append("\n");
        }
        str.append("0. ").append(menu.BackOption().getName()).append("\n\nVotre choix: ");

        while (true) {
            System.out.print(str);

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                menu.BackOption().execute();
                return;
            }

            try {
                menu.getOptions().get(Integer.parseInt(choice) - 1).execute();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Votre choix est incorrect");
            } finally {
                scanner.close();
            }
        }
    }
}
