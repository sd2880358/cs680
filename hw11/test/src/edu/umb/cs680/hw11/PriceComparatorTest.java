package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {
    private static Car honda = new Car("honda", "civic", 10000, 2019, 5000);
    private static Car audi1 = new Car("audi", "A4", 136636, 2000, 4880);
    private static Car audi2 = new Car("audi", "A4", 84297, 2001, 7995);
    private static Car audi3 = new Car("audi", "A6", 78321, 2003, 10697);

    @Test
    public void priceComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(honda);
        cars.add(audi1);
        cars.add(audi2);
        cars.add(audi3);
        Car[] expected = {audi1, honda, audi2, audi3};
        Collections.sort(cars, new PriceComparator());
        Car[] actual = cars.toArray(new Car[cars.size()]);
        assertArrayEquals(expected, actual);
    }


}