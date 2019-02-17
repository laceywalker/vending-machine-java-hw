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
    public void stockListStartsEmpty(){
        assertEquals(0, vendingMachine.getStockQuanity());
    }




}