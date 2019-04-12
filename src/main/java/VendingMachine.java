import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class VendingMachine {

    private HashMap<Slot, ArrayList<Stock>> slots;
    private ArrayList<Coin> changeAvailable;

    public VendingMachine(){
        this.changeAvailable = new ArrayList<>();

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

    public ArrayList<Coin> getChangeAvailable() {
//        collections calls the comparable method in the coin class, sorts the array of coins in reverse order from
//        highest to lowest
        Collections.sort(changeAvailable, Collections.reverseOrder());
        return changeAvailable;
    }


    public void addCoinToVendingMachine(Coin coin) {
        changeAvailable.add(coin);
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

    public double checkTotalChange(){
        double total = 0;
        for (Coin coin : this.changeAvailable){
            total += coin.getValue();
        }
        return total;
    }

    public double getCoinsInsertedValue(ArrayList<Coin> coinsInserted){
        double counter = 0;
        for (Coin coin : coinsInserted){
            counter += coin.getValue();
        }
        return counter;
    }

    public ArrayList<Coin> giveExactChange(Stock stock, ArrayList<Coin> coinsInserted){
        ArrayList<Coin> coinsToReturn = new ArrayList<>();
        double coinsInsertedValue = this.getCoinsInsertedValue(coinsInserted);

        if(coinsInsertedValue < stock.getStockPrice()){
            return coinsInserted;
        }
        double stockPrice = stock.getStockPrice();
        double change = coinsInsertedValue - stockPrice;

        Collections.sort(this.changeAvailable, Collections.reverseOrder());
        for(Coin coin: this.changeAvailable){
            if(change >= coin.getValue()){
                change -= coin.getValue();
                coinsToReturn.add(coin);
            }
        }
        return coinsToReturn;
    }


}
