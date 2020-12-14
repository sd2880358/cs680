package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    private static StockQuoteObservable stockQuote;
    private static DJIAQuoteObservable djiaQuote;
    private static PieChartObserver pieChart;
    private static TableObserver tableObserver;
    private static ThreeDObserver threeDObserver;

    @BeforeAll
    public static void initialized(){
        stockQuote = new StockQuoteObservable();
        djiaQuote = new DJIAQuoteObservable();
        pieChart = new PieChartObserver();
        tableObserver = new TableObserver();
        threeDObserver = new ThreeDObserver();
    }

    @Test
    public void stTest(){
        Random rand = new Random();
        Float test = rand.nextFloat();
        stockQuote.changeQuote("first", rand.nextFloat());
        stockQuote.changeQuote("first", test);
        String expected = "{first="+ String.valueOf(test)+"}";
        String actual = stockQuote.getStockQuote().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void djiaTest(){
        Random rand = new Random();
        Float test = rand.nextFloat();
        djiaQuote.changeQuote(rand.nextFloat());
        djiaQuote.changeQuote(test);
        String expected = String.valueOf(test);
        String actual = String.valueOf(djiaQuote.getQuote());
        assertEquals(expected, actual);
    }
}