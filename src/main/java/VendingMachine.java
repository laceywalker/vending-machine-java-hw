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

    public String getSlotName(String slotNameToCheck) {
        String slotName = new String();
        for (Slot key : this.slots.keySet()) {
            if (key.position == slotNameToCheck) {
                slotName = key.position;
            }
        }
            return slotName;
    }

    public int getSlotCapacity(String slotToCheck){
        int slotCapacity = 0;
        for (Slot key : this.slots.keySet()) {
            if (key.position == slotToCheck) {
                slotCapacity = key.capacity;
            }
        }
        return slotCapacity;

    }

    public int getSlotCount(){
        int keyCount =  this.slots.keySet().size();
        return keyCount;
    }

    public int getSlotStockQuantity(Slot slotToCheck){
        return this.slots.get(slotToCheck).size();
    }


    public ArrayList addToSlot(Slot slot, ArrayList<Stock> stockList){
        ArrayList remainingStock = new ArrayList<Stock>();
        int capacity = this.getSlotCapacity(slot.position);
        int quantity = this.slots.get(slot).size();

        for (Stock stock : stockList){
            if (capacity > quantity) {
                this.slots.get(slot).add(stock);
                quantity += 1;
            }
            else{
                remainingStock.add(stock);
            }
        }
       return remainingStock;
    }


    public void vendToCustomer(Slot selectedSlot, Customer customer) {
        ArrayList<Stock> stock = this.slots.get(selectedSlot);

        if (stock.size() <= 0) {
            return;
        }

        else {
            Double itemPrice = stock.get(0).getStockPrice();

            if (customer.getWalletAmount() >= itemPrice) {
                Stock purchasedItem = this.slots.get(selectedSlot).remove(0);
                customer.getPurchasedSnacks().add(purchasedItem);
                customer.payForItem(purchasedItem);
            }
        }
    }

    public String checkSlotIsEmpty(Slot slotToCheck) {
        ArrayList<Stock> stock = this.slots.get(slotToCheck);
        if (stock.size() == 0) {
            return "Sold Out!";
        }
        else {
            return "Enjoy!";
        }
    }
}
