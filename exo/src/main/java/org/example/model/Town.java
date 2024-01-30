package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Town {
    private final List<String> towns = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    public List<String> search(String text){
        if(text.equals("*"))
            return this.towns;
        List<String> res=new ArrayList<>();
        if(text.length()<2)
            return res;
        for(String town:towns){
            if(town.contains(text.trim())){
                res.add(town);
            }
        }
        return res;
    }
}
