import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {

    Stock stock;

    @Before
    public void before(){
        stock = new Stock("pretzels", 0.85);
    }

    @Test
    public void canGetStockName(){
        assertEquals("pretzels", stock.getStockName());
    }

    @Test
    public void canGetStockPrice(){
        assertEquals(0.85, stock.getStockPrice(), 0.01);
    }
}
