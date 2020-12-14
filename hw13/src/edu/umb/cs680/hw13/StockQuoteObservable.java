package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Observable;


public class StockQuoteObservable extends Observable {

    private HashMap<String, Float> stockQuotes;
    public HashMap<String, Float> getStockQuote(){
        return stockQuotes;
    }
    public StockQuoteObservable() {
        this.stockQuotes = new HashMap<String, Float>();
    }

    public void changeQuote(String t, Float q){
        stockQuotes.put(t, q);
        setChanged();
        notifyObservers(new StockEvent(t, q));
    }
}
