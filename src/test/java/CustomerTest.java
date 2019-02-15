import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void before(){
        customer = new Customer(2.50);
    }

    @Test
    public void customerHasWallet(){
        assertEquals(2.50, customer.getWalletAmount(), 0.01);
    }
}
