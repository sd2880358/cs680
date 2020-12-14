package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {
    private static Car honda = new Car("honda", "civic", 10000, 2019, 5000);
    private static Car audi1 = new Car("audi", "A4", 136636, 2000, 4880);
    private static Car audi2 = new Car("audi", "A4", 84297, 2001, 7995);
    private static Car audi3 = new Car("audi", "A6", 78321, 2003, 10697);

    @Test
    public void paratoComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(honda);
        cars.add(audi1);
        cars.add(audi2);
        cars.add(audi3);
        for (Car car : cars){
            car.setDominateCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        Car[] expected = {honda, audi3,audi2, audi1};
        Car[] actual = cars.toArray(new Car[cars.size()]);
        assertArrayEquals(expected, actual);
    }


}