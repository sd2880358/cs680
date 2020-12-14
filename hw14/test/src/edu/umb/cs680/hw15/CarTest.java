package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static Car honda = new Car("honda", "civic", 10000, 2019, 5000);
    private static Car audi1 = new Car("audi", "A4", 136636, 2000, 4880);
    private static Car audi2 = new Car("audi", "A4", 84297, 2001, 7995);
    private static Car audi3 = new Car("audi", "A6", 78321, 2003, 10697);
    private static ArrayList<Car> test = new ArrayList<Car>();

    @BeforeAll
    public static void initialized(){
        test.add(honda);
        test.add(audi1);
        test.add(audi2);
        test.add(audi3);
    }

    @Test
    public void mileageComparator(){
        Car[] expected = {honda, audi3, audi2, audi1};
        Collections.sort(test,
                Comparator.comparing(Car::getMileage));
        Car[] actual = test.toArray(new Car[test.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void priceComparator(){
        Car[] expected = {audi1, honda, audi2, audi3};
        Collections.sort(test,
                Comparator.comparing(Car::getPrice));
        Car[] actual = test.toArray(new Car[test.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void descYearComparator(){
        Car[] expeceted = {honda, audi3, audi2, audi1};
        Collections.sort(test,
                Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
        Car[] actual = test.toArray(new Car[test.size()]);
        assertArrayEquals(expeceted, actual);
    }

    @Test
    public void parmetorComparator(){
        for(Car car : test){
            car.setDominateCount(test);
        }
        Collections.sort(test,
                Comparator.comparing(Car::getDominateCount, Comparator.reverseOrder()));
        Car[] expected = {audi1, audi2, honda, audi3};
        Car[] actual = test.toArray(new Car[test.size()]);
        assertArrayEquals(expected, actual);
    }

}