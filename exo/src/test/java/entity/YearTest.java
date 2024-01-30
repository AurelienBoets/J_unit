package entity;

import org.example.model.Year;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {
    private Year year;

    @Test
    void yearDivisibleBy400() {
        year = new Year(1600);
        boolean res = year.isLeapYear();
        Assertions.assertTrue(res);
    }

    @Test
    void yearDivisibleBy4NotBy100() {
        year = new Year(64);
        boolean res = year.isLeapYear();
        Assertions.assertTrue(res);
    }

    @Test
    void yearDivisibleBy4000() {
        year = new Year(16000);
        boolean res = year.isLeapYear();
        Assertions.assertTrue(res);
    }

    @Test
    void yearDivisibleBy100ShouldBeReturnFalse() {
        year = new Year(200);
        boolean res = year.isLeapYear();
        Assertions.assertFalse(res);
    }
}
