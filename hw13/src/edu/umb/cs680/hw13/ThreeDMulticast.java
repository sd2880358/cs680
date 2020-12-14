package edu.umb.cs680.hw13;

public class ThreeDMulticast implements StockQuoteObserver, DJIAQuoteObserver{
    @Override
    public void updateDJIA(DJIAEvent e) {
        System.out.println("3D update for Stock event" + e.getQuote());
    }

    @Override
    public void updateStock(StockEvent e){
        System.out.println("3D update for Stock event" + e.getQuote());
    }
}
