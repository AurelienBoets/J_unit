package org.example.model;

public class Year {
    private Integer value;

    public Year(Integer value){
        this.value=value;
    }

    public boolean isLeapYear(){
        if(value%400==0)
            return true;
        return value%4==0 && value%100!=0;
    }
}
