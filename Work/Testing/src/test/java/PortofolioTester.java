import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class PortofolioTester {
    Portofolio portofolio;
    StockService stockService;

    public static void main(String[] args) {
        PortofolioTester test = new PortofolioTester();
        test.setUp();
        System.out.println(test.testMarketValue() ? "pass" : "fail");
    }

    public void setUp() {
        // Create a Portfolio Object which is to be tested.
        portofolio = new Portofolio();

        // Create the mock object of the stock service.
        stockService = mock(StockService.class);

        // set the stockService to the portfolio
        portofolio.setStockService(stockService);
    }

    public boolean testMarketValue() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("1", "Google", 10));
        stocks.add(new Stock("2", "Microsoft", 100));

        portofolio.setStocks(stocks);

        // mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(stocks.get(0))).thenReturn(50.00);
        when(stockService.getPrice(stocks.get(1))).thenReturn(1000.00);

        double marketValue = portofolio.getMarketValue();
        return marketValue == 100500.0;
    }
}