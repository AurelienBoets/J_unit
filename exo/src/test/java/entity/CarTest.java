package entity;

import org.example.model.Car;
import org.example.model.CarEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @Test
    void carWithExpiredContract() {
        car = new Car(0, 25);
        car.dailyRoutine();
        Assertions.assertEquals(23, car.getCondition());
    }

    @Test
    void carWithCondition0() {
        car = new Car(0, 0);
        car.dailyRoutine();
        Assertions.assertEquals(0, car.getCondition());
    }

    @Test
    void luxuryCarWithCondition100() {
        car = new Car(40, 100, CarEnum.LUXURY);
        car.dailyRoutine();
        Assertions.assertEquals(100, car.getCondition());
    }

    @Test
    void luxuryCarWithIncrementCondition() {
        car = new Car(40, 25, CarEnum.LUXURY);
        car.dailyRoutine();
        Assertions.assertEquals(26, car.getCondition());
    }

    @Test
    void oldCar() {
        car = new Car(10, 25, CarEnum.OLD);
        car.dailyRoutine();
        Assertions.assertEquals(23, car.getCondition());
    }
}
