package edu.umb.cs680.hw13;

public class TableMulticast implements StockQuoteObserver, DJIAQuoteObserver{
    public void updateDJIA(DJIAEvent e) {
        System.out.println("Table update for Stock event" + e.getQuote());
    }
    public void updateStock(StockEvent e){
        System.out.println("Table update for Stock event" + e.getQuote());
    }
}
