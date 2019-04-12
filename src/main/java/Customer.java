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
//        collections sort is in-built method to sort arrays, this sorts from lowest to highest by default //
//        can provide a second argument to call it in reverse order - this sorts by highest to lowests //
//        in order to make coin sortable, need to implement Comparable interface and implement compareTo method //
//        this is implemented in the object class - in this case, Coin

        ListIterator<Coin> iter = this.wallet.listIterator();
//        use an iterator because you cannot loop through an array and remove items from it at the same time - error
        while(iter.hasNext()) {
//            this is the loop - while (used for iterators, not for loop) and hasNext makes sure it does the logic for the current thing
            if (stockCost >= iter.next().getValue()) {
//                ** MYSTERY if this was 50p on line 50, when it passed to line 51 (when using .next it became 20p for some reason, had to use previous to keep the value the same)
                stockCost -= iter.previous().getValue();
//               previous makes sure it checks that the current item is less than the stock cost, otherwise it would keep going
//               go on to the next item - would then
                stockCost = stockCost*100;
                stockCost = Math.round(stockCost);
                stockCost = stockCost/100;
//                rounding because I used doubles
                iter.remove();
//                removes the coin from the array
            }
        }

    }


}
