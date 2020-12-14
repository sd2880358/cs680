package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MulticastTest {
    private static StockQuoteMulticast sqml;
    private static DJIAQuoteMulticast djiaml;
    private static PieChartMulticast pieChart;
    private static TableMulticast tableObserver;
    private static ThreeDMulticast threeDObserver;

    @BeforeAll
    private static void initi(){
        sqml = new StockQuoteMulticast();
        djiaml = new DJIAQuoteMulticast();

        pieChart = new PieChartMulticast();
        tableObserver = new TableMulticast();
        threeDObserver = new ThreeDMulticast();
        sqml.addObserver(pieChart);
        djiaml.addObserver(pieChart);

        sqml.addObserver(threeDObserver);
        djiaml.addObserver(threeDObserver);

        sqml.addObserver(tableObserver);
        djiaml.addObserver(tableObserver);
    }

    @Test
    public void stTest(){
        Random rand = new Random();
        Float test = rand.nextFloat();
        sqml.changeQuote("first", rand.nextFloat());
        sqml.changeQuote("first", test);
        String expected = "{first="+ String.valueOf(test)+"}";
        String actual = sqml.getStockQuotes().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void djiaTest(){
        Random rand = new Random();
        Float test = rand.nextFloat();
        djiaml.changeQuote(rand.nextFloat());
        djiaml.changeQuote(test);
        String expected = String.valueOf(test);
        String actual = String.valueOf(djiaml.getQuote());
        assertEquals(expected, actual);
    }
}