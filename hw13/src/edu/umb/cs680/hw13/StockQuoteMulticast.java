package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.LinkedList;

public class StockQuoteMulticast {
    private HashMap<String, Float> stockQuotes;
    private LinkedList<StockQuoteObserver> observers;
    public StockQuoteMulticast(){
        this.observers = new LinkedList<StockQuoteObserver>();
        this.stockQuotes = new HashMap<String, Float>();
    }

    public HashMap<String, Float> getStockQuotes(){
        return this.stockQuotes;
    }

    public void notifyObservers(StockEvent e){
        for (StockQuoteObserver o : observers){
            o.updateStock(e);
        }
    }

    public void changeQuote(String t, float q){
        stockQuotes.put(t, q);
        notifyObservers(new StockEvent(t,q));
    }

    public void addObserver(StockQuoteObserver o){
        this.observers.add(o);
    }
}
