package org.example.entity;


import java.util.Arrays;

public class Game {

    private final Word word;
    private final String[] proposeWord;

    public Game(Word word) {
        this.word = word;
        this.proposeWord = new String[word.getValue().length()];
        Arrays.fill(proposeWord, "-");
    }

    public boolean attempt(char charPropose) {
        int index = this.word.getValue().indexOf(charPropose);

        if (index == -1) {
            return false;
        }

        while (index != -1) {
            proposeWord[index] = String.valueOf(charPropose);
            index = this.word.getValue().indexOf(charPropose, index + 1);
        }

        return true;
    }


    public boolean isWin() {
        return getMask().equals(word.getValue());
    }

    public String[] getProposeWord() {
        return proposeWord;
    }

    public String getMask(){
        StringBuilder proposeWordToString = new StringBuilder();
        for (String c : this.proposeWord) {
            proposeWordToString.append(c);
        }
        return proposeWordToString.toString();
    }
}
