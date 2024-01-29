package entity;

import org.example.model.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibTest {
    @Test
    void fibSeriesTest1(){
        Fib fib=new Fib(1);
        List<Integer> list=fib.getFibSeries();
        List<Integer> attempt=new ArrayList<>();
        attempt.add(0);
        Assertions.assertEquals(attempt,list);
    }

    @Test
    void fibSeriesTest2(){
        Fib fib=new Fib(6);
        List<Integer> list=fib.getFibSeries();
        List<Integer> attempt= Arrays.asList(0, 1, 1, 2, 3,5);
        Assertions.assertEquals(attempt,list);
    }
}
