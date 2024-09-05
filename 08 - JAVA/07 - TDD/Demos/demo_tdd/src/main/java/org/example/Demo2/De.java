package org.example.Demo2;

import java.util.Random;

public class De implements Ide{
    @Override
    public int lancer() {
        Random random = new Random();
        return random.nextInt(20);
    }
}
