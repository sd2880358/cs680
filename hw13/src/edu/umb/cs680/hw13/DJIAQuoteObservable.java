package edu.umb.cs680.hw13;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable{
    private float quote;
    public void changeQuote(float q){
        this.quote = q;
        setChanged();
        notifyObservers(new DJIAEvent(q));
    }

    public float getQuote(){
        return this.quote;
    }
}
