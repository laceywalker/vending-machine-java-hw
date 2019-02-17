import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private HashMap<Slot, ArrayList<Stock>> slots;

    public VendingMachine(){
        ArrayList<Stock> stock = new ArrayList<>();
        this.slots = new <Slot, ArrayList<Stock>> HashMap();
        this.slots.put(Slot.A1, stock);
        this.slots.put(Slot.A2, stock);
        this.slots.put(Slot.A3, stock);
        this.slots.put(Slot.B1, stock);
        this.slots.put(Slot.B2, stock);
        this.slots.put(Slot.B3, stock);
        this.slots.put(Slot.C1, stock);
        this.slots.put(Slot.C2, stock);
        this.slots.put(Slot.C3, stock);
        this.slots.put(Slot.D1, stock);
        this.slots.put(Slot.D2, stock);
        this.slots.put(Slot.D3, stock);
        this.slots.put(Slot.E1, stock);
        this.slots.put(Slot.E2, stock);
        this.slots.put(Slot.E3, stock);
    }

//    public String getSlotPosition(){
//        return this.slots.get(Slot.name);
//    }

    public int getSlotCount(){
        int keyCount =  this.slots.keySet().size();
        return keyCount;
    }

    public int getStockQuanity(){
        return this.slots.get(Slot.A1).size();
    }


}
