import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Customer {


    private ArrayList<Coin> wallet;
    private ArrayList<Stock> purchasedSnacks;

    public Customer(){
        this.wallet = new ArrayList<>();
        this.purchasedSnacks = new ArrayList<>();
    }

    public void addCoinToWallet(Coin coin){
        this.wallet.add(coin);
    }

    public double getWalletAmount(){
        double walletTotal = 0;
        for (Coin item : this.wallet) {
            walletTotal += item.getValue();
        }

        return walletTotal;
    }

    public ArrayList<Stock> getPurchasedSnacks() {
        return this.purchasedSnacks;
    }

    public int purchasedSnackListCount(){
        return this.purchasedSnacks.size();
    }

    public void payForItem(Stock stock){

        double stockCost = stock.getStockPrice();
        Collections.sort(this.wallet, Collections.reverseOrder());
//        collections - sort is in-built method to sort arrays, sorted lowest to highest by default - must reverse //

        ListIterator<Coin> iter = this.wallet.listIterator();
//        iterator  to loop through array and remove items from it at the same time
        while(iter.hasNext()) {
//            this is the loop - while (used for iterators, not for loop)
            if (stockCost >= iter.next().getValue()) {
//                ** MYSTERY if this was 50p on line 50, when it passed to line 51 (when using .next it became 20p for some reason, had to use previous to keep the value the same)
                stockCost -= iter.previous().getValue();
                stockCost = stockCost*100;
                stockCost = Math.round(stockCost);
                stockCost = stockCost/100;
//                never use doubles for money again
                iter.remove();
//               removes coin from array
            }
        }

    }


}
