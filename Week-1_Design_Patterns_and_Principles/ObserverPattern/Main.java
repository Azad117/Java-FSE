public class Main {

    public static void main(String[] args)
    {
        StockMarket stockMarket = new StockMarket();

        Observer webApp = new WebApp();
        Observer mobileApp = new MobileApp();

        stockMarket.register(webApp);
        stockMarket.register(mobileApp);

        stockMarket.setStockData("AAPL", 150.0);
        stockMarket.deregister(webApp);

        stockMarket.setStockData("GOOGL", 2800.0);


    }
    
}
