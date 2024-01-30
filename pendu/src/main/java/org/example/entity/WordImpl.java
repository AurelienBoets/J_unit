package org.example.entity;

import java.util.Random;

public class WordImpl implements Word {
    @Override
    public String getValue() {
        String[] wordTab = {"chat", "banane", "montagne", "livre", "ocean", "musique", "cinema", "voyage", "girafe", "voyage"};
        int randomNumber = new Random().nextInt(10);
        return wordTab[randomNumber];
    }
}
