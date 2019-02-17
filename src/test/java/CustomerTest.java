import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Stock pretzels;
    VendingMachine vendingMachine;
    Slot slot;
    ArrayList<Stock> stockList;

    @Before
    public void before(){
        customer = new Customer(2.50);
        pretzels = new Stock("pretzels", 0.50);
        vendingMachine = new VendingMachine();
        stockList = new ArrayList<Stock>();
        stockList.add(pretzels);
    }

    @Test
    public void customerHasWallet(){
        assertEquals(2.50, customer.getWalletAmount(), 0.01);
    }

    @Test
    public void customerCanPayForItem(){
        customer.payForItem(pretzels);
        assertEquals(2.00, customer.getWalletAmount(), 0.01);
    }

    @Test
    public void canUpdateSnacksList(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        vendingMachine.vendToCustomer(slot.A1, customer);
        assertEquals(1, customer.purchasedSnackListCount());
    }
}
