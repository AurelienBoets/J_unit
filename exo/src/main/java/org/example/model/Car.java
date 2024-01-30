package org.example.model;

public class Car {
    private int rentDueIn;
    private int condition;
    private CarEnum type;
    private int increment;

    public Car(int rentDueIn, int condition) {
        this.rentDueIn = rentDueIn;
        this.condition = condition;
        this.type = CarEnum.OTHER;
    }

    public Car(int rentDueIn, int condition, CarEnum type) {
        this(rentDueIn, condition);
        this.type = type;
    }

    public int getCondition() {
        return condition;
    }

    private void defineIncrement() {
        switch (this.type) {
            case LUXURY -> increment = 1;
            case OLD -> increment = -2;
            default -> increment = -1;
        }
        if (rentDueIn <= 0 && type != CarEnum.LUXURY)
            increment *= 2;
    }

    public void dailyRoutine() {
        defineIncrement();
        rentDueIn--;
        condition += increment;
        if (condition < 0)
            condition = 0;
        if (condition > 100)
            condition = 100;
    }
}
