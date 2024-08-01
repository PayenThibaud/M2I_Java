package org.example.DemoEnum;

public class Main {
    public static void main(String[] args) {

        Language language = Language.JAVA;

//        Language language1 = Language.valueOf("PYTHON");
//
//        System.out.println(language1.ordinal());

        Language[] languages = Language.values();

        for (Language l : languages){
            System.out.println(l);
        }

        Language language1 = Language.valueOf("");

    }
}
