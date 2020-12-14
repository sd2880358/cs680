package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof StockEvent){
            StockEvent se = (StockEvent)arg;
            System.out.println("Table update for Stock event" + se.getQuote());
        }
        else if(arg instanceof DJIAEvent){
            DJIAEvent de = (DJIAEvent)arg;
            System.out.println("Table update for Stock event" + de.getQuote());
        }
    }
}
