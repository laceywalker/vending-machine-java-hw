import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private HashMap<Slot, ArrayList<Stock>> slots;

    public VendingMachine(){
        ArrayList<Stock> stock = new ArrayList<>();
        this.slots = new <Slot, ArrayList<Stock>> HashMap();
        this.slots.put(Slot.ONE, stock);
        this.slots.put(Slot.TWO, stock);
        this.slots.put(Slot.THREE, stock);
        this.slots.put(Slot.FOUR, stock);
        this.slots.put(Slot.FIVE, stock);
        this.slots.put(Slot.SIX, stock);
        this.slots.put(Slot.SEVEN, stock);
        this.slots.put(Slot.EIGHT, stock);
        this.slots.put(Slot.NINE, stock);
        this.slots.put(Slot.TEN, stock);
        this.slots.put(Slot.ELEVEN, stock);
        this.slots.put(Slot.TWELVE, stock);
        this.slots.put(Slot.THIRTEEN, stock);
        this.slots.put(Slot.FOURTEEN, stock);
        this.slots.put(Slot.FIFTEEN, stock);
    }



}
