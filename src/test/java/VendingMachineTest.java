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
        customer = new Customer(4.50);
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
        assertEquals(2, vendingMachine.getSlotStockQuantity(Slot.C1));

    }

    @Test
    public void cantBuyFromEmptySlot(){

        vendingMachine.vendToCustomer(Slot.C1, customer);
        assertEquals(4.50, customer.getWalletAmount(), 0.01);
    }





}