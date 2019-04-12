import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest{

    VendingMachine vendingMachine;
    Slot slot;
    ArrayList<Stock> stockList;
    Stock pretzels;
    Stock twix;
    Stock chips;
    Customer customer;
    Customer customer2;
    Coin fiftyPence;
    Coin twentyPence;
    Coin tenPence;
    Coin fivePence;

    @Before
    public void before(){
        vendingMachine = new VendingMachine();
        stockList = new ArrayList<>();
        pretzels = new Stock("pretzels", 0.50);
        twix = new Stock("twix", 0.75);
        chips = new Stock("chips", 0.85);
        stockList.add(pretzels);
        stockList.add(twix);
        stockList.add(chips);
        customer = new Customer();
        customer2 = new Customer();
        fiftyPence = new Coin("fifty pence", 0.50);
        twentyPence = new Coin("twenty pence", 0.20);
        tenPence = new Coin("twenty pence", 0.10);
        fivePence = new Coin("five pence", 0.05);


    }

    @Test
    public void hasSlots(){
        assertEquals(15, vendingMachine.getSlotCount());
    }

    @Test
    public void checkSlotPosition(){
        assertEquals("A1", slot.A1.getPosition());
    }

    @Test
    public void checkSlotCapacity(){
        assertEquals(1, slot.A1.getCapacity());
    }

    @Test
    public void checkCanGetSlotName(){
        String toCheck = vendingMachine.getSlotName("A1");
        assertEquals("A1", toCheck);
    }

    @Test
    public void checkCanGetSlotCapacity(){
        int toCheck = vendingMachine.getSlotCapacity("A1");
        assertEquals(1, toCheck);

    }
    @Test
    public void stockListStartsEmpty(){
        assertEquals(0, vendingMachine.getSlotStockQuantity(slot.A1));
    }

    @Test
    public void canAddToVendingMachine(){
        ArrayList returnedStock = vendingMachine.addToSlot(Slot.A1, stockList);
        assertEquals(2, returnedStock.size());

    }

    @Test
    public void customerCanBuyStock(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        vendingMachine.vendToCustomer(Slot.C1, customer);
        assertEquals(3, vendingMachine.getSlotStockQuantity(Slot.C1));
    }

    @Test
    public void cantBuyFromEmptySlot(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        customer.addCoinToWallet(twentyPence);
        vendingMachine.vendToCustomer(Slot.C1, customer);
        assertEquals(0.20, customer.getWalletAmount(), 0.01);
    }

    @Test
    public void cantBuyInsufficientFunds(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        vendingMachine.vendToCustomer(Slot.C1, customer2);
        assertEquals(0, customer.getPurchasedSnacks().size());
    }

    @Test
    public void cantBuyIfSoldOut(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        customer.addCoinToWallet(fiftyPence);
        vendingMachine.vendToCustomer(Slot.C1, customer);
        vendingMachine.vendToCustomer(Slot.C1, customer);
        vendingMachine.vendToCustomer(Slot.C1, customer);
        assertEquals("Sold Out!", vendingMachine.checkSlotIsEmpty(Slot.C1));

    }

    @Test
    public void slotIsEmpty(){
        vendingMachine.addToSlot(Slot.C1, stockList);
        assertEquals("Enjoy!", vendingMachine.checkSlotIsEmpty(Slot.C1));
    }

    @Test
    public void canAddCoinToVendingMachine(){
        vendingMachine.addCoinToVendingMachine(fiftyPence);
        assertEquals(1,vendingMachine.getChangeAvailable().size());
    }

    @Test
    public void canSortChange(){
        vendingMachine.addCoinToVendingMachine(twentyPence);
        vendingMachine.addCoinToVendingMachine(twentyPence);
        vendingMachine.addCoinToVendingMachine(twentyPence);
        vendingMachine.addCoinToVendingMachine(tenPence);
        vendingMachine.addCoinToVendingMachine(fiftyPence);
        vendingMachine.addCoinToVendingMachine(fiftyPence);
        assertEquals(fiftyPence, vendingMachine.getChangeAvailable().get(0));
        assertEquals(tenPence, vendingMachine.getChangeAvailable().get(vendingMachine.getChangeAvailable().size() -1));
    }


    @Test
    public void canCheckTotalofChangeinVendingMachine(){
        vendingMachine.addCoinToVendingMachine(fiftyPence);
        vendingMachine.addCoinToVendingMachine(fiftyPence);
        vendingMachine.addCoinToVendingMachine(twentyPence);
        assertEquals(1.20, vendingMachine.checkTotalChange(), 0.01);
    }

    @Test
    public void canGiveCorrectChange(){
        ArrayList<Coin> coinsInserted = new ArrayList<>();
        coinsInserted.add(fiftyPence);
        coinsInserted.add(fiftyPence);
        vendingMachine.addCoinToVendingMachine(twentyPence);
        vendingMachine.addCoinToVendingMachine(twentyPence);
        vendingMachine.addCoinToVendingMachine(fivePence);
        vendingMachine.addCoinToVendingMachine(fivePence);
        vendingMachine.addCoinToVendingMachine(fivePence);
        vendingMachine.addCoinToVendingMachine(tenPence);
        ArrayList<Coin> change = vendingMachine.giveExactChange(pretzels, coinsInserted);
        assertEquals(3, change.size());
        assertEquals(0.2, change.get(0).getValue(), 0.1);
        assertEquals(0.2, change.get(1).getValue(), 0.1);
        assertEquals(0.1, change.get(2).getValue(), 0.1);
    }
//makes sure the sorted array never gets 5p because only returns higher value coins



}