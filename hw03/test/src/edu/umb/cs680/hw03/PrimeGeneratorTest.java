package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PrimeGeneratorTest {
    @Test
    public void primeGenerateFrom1to12(){
        PrimeGenerator cut = new PrimeGenerator(1,12);
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L};
        cut.generatePrimes();
        Long[] actualPrimes = cut.getPrimes().toArray(new Long[0]);
        assertArrayEquals(expectedPrimes, actualPrimes);
    }
    @Test
    public void primeGenerateFromN1To1TryCatch(){
        try{
            PrimeGenerator cut = new PrimeGenerator(-1,1);
            fail("Wrong input values: from=-1 to=1");
        }
        catch (RuntimeException ex){
            assertEquals("Wrong input values: from=-1 to=1", ex.getMessage());
        }
    }
}
