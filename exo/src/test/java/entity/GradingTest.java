package entity;

import org.example.model.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingTest {
    @Test
    void testGrade1(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(95);
        calculator.setAttendancePercentage(90);
        char grade= calculator.getGrade();
        Assertions.assertEquals('A',grade);
    }
    @Test
    void testGrade2(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(85);
        calculator.setAttendancePercentage(90);
        char grade= calculator.getGrade();
        Assertions.assertEquals('B',grade);
    }
    @Test
    void testGrade3(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(65);
        calculator.setAttendancePercentage(90);
        char grade= calculator.getGrade();
        Assertions.assertEquals('C',grade);
    }

    @Test
    void testGrade4(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(95);
        calculator.setAttendancePercentage(65);
        char grade= calculator.getGrade();
        Assertions.assertEquals('B',grade);
    }

    @Test
    void testGrade5(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(95);
        calculator.setAttendancePercentage(55);
        char grade= calculator.getGrade();
        Assertions.assertEquals('F',grade);
    }

    @Test
    void testGrade6(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(65);
        calculator.setAttendancePercentage(55);
        char grade= calculator.getGrade();
        Assertions.assertEquals('F',grade);
    }

    @Test
    void testGrade7(){
        GradingCalculator calculator=new GradingCalculator();
        calculator.setScore(50);
        calculator.setAttendancePercentage(90);
        char grade= calculator.getGrade();
        Assertions.assertEquals('F',grade);
    }
}
