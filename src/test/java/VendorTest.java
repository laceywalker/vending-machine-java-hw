import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendorTest {
    Vendor vendor;
    Stock pretzels;


    @Before
    public void before(){
        vendor = new Vendor();
        pretzels = new Stock("pretzels", 0.50);
    }

    @Test
    public void canCheckStock(){
        assertEquals("pretzels", vendor.getStockListCount());
    }

    @Test
    public void canAddToStock(){
        vendor.addToStockList(pretzels);
        assertEquals(1, vendor.getStockListCount());
    }

    @Test
    public void canRemoveFromStock(){
        vendor.addToStockList(pretzels);
        vendor.removeStock();
        assertEquals(0, vendor.getStockListCount());

    }
}
