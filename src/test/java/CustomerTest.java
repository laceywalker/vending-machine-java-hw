import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Stock pretzels;
    Stock kitkat;
    VendingMachine vendingMachine;
    Slot slot;
    ArrayList<Stock> stockList;
    Coin fiftyPence;
    Coin pence;
    Coin twentyPence;
    Coin tenPence;
    Stock mints;

    @Before
    public void before(){
        customer = new Customer();
        pretzels = new Stock("pretzels", 0.50);
        kitkat = new Stock("kitkat", 1.00);
        mints = new Stock("mints", 0.30);
        vendingMachine = new VendingMachine();
        stockList = new ArrayList<Stock>();
        stockList.add(pretzels);
        fiftyPence = new Coin("fifty pence", 0.50);
        twentyPence = new Coin("twenty pence", 0.20);
        tenPence = new Coin("ten pence", 0.10);
        pence = new Coin("pence", 0.01);
    }


    @Test
    public void canAddToWallet(){
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(pence);
        assertEquals(0.51, customer.getWalletAmount(), 0.01);

    }

    @Test
    public void customerHasWallet(){
        assertEquals(0, customer.getWalletAmount(), 0.01);
    }

    @Test
    public void customerCanPayForItem(){
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(twentyPence);
        customer.addCoinToWallet(tenPence);
        customer.addCoinToWallet(tenPence);
        customer.addCoinToWallet(tenPence);
        assertEquals(3.00, customer.getWalletAmount(), 0.01);
        customer.payForItem(pretzels);
        assertEquals(2.50, customer.getWalletAmount(), 0.01);
        customer.payForItem(mints);
        assertEquals(2.20, customer.getWalletAmount(), 0.01);
        customer.payForItem(kitkat);
        assertEquals(1.20, customer.getWalletAmount(), 0.01);
    }

    @Test
    public void canUpdateSnacksList(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        vendingMachine.vendToCustomer(slot.A1, customer);
        assertEquals(1, customer.purchasedSnackListCount());
    }
}
