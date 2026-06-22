import java.util.*;

public class StockMarket implements Stock
{
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private Double price;
    
    @Override
    public void register(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers()
    {
        for(Observer observer : observers)
        {
            observer.update(stockName, price);
        }
    }

    public void setStockData(String stockName, double price)
    {
        this.stockName = stockName;
        this.price = price;

        System.out.println("StockMarket: " + stockName + " price updated to " + price);
        notifyObservers();
    }
}
