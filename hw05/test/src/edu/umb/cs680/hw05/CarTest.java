package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {
    private String[] carToStringArray(Car a){
        String [] carInfo = {a.getMake(), a.getModel(), Integer.toString(a.getYear())};
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear1(){
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 40000,2018, 2000000);
        assertArrayEquals(carToStringArray(actual), expected);
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear2(){
        String[] expected = {"Honda", "Civic", "2019"};
        Car actual = new Car("Honda", "Civic", 40000,2019, 2000000);
        assertArrayEquals(carToStringArray(actual), expected);
    }
}