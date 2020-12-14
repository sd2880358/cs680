package edu.umb.cs680.hw13;

public class StockEvent {

    private String ticker;
    private float quote;

    public StockEvent(String ticket, float quote){
        this.ticker = ticket;
        this.quote = quote;
    }

    public float getQuote() {
        return quote;
    }

    public String getTicket() {
        return ticker;
    }
}
