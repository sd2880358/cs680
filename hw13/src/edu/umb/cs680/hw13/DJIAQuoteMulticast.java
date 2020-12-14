package edu.umb.cs680.hw13;

import java.util.LinkedList;

public class DJIAQuoteMulticast {
    private float quote;
    private LinkedList<DJIAQuoteObserver> observers;
    public DJIAQuoteMulticast(){
        this.observers = new LinkedList<DJIAQuoteObserver>();
    }
    public void notifyObserver(DJIAEvent e){
        for (DJIAQuoteObserver o: observers){
            o.updateDJIA(e);
        }
    }
    public void changeQuote(float q){
        this.quote = q;
        notifyObserver(new DJIAEvent(q));
    }
    public void addObserver(DJIAQuoteObserver o){
        this.observers.add(o);
    }

    public float getQuote(){
        return this.quote;
    }
}
