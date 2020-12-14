package edu.umb.cs680.hw13;

public class PieChartMulticast implements DJIAQuoteObserver, StockQuoteObserver{
    public void updateDJIA(DJIAEvent e) {
        System.out.println("Pie Chart update for Stock event" + e.getQuote());
    }
    public void updateStock(StockEvent e){
        System.out.println("PieChart update for Stock event" + e.getQuote());
    }
}
