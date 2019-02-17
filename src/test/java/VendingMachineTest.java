import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest{

    VendingMachine vendingMachine;
    Slot slot;

    @Before
    public void before(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public void hasSlots(){
        assertEquals(15, vendingMachine.getSlotCount());
    }

    @Test
    public void stockListStartsEmpty(){
        assertEquals(0, vendingMachine.getStockQuanity());
    }




}