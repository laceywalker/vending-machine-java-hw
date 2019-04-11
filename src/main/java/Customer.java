import java.lang.reflect.Array;
import java.util.ArrayList;

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
        double walletTotal = getWalletAmount();
        walletTotal -= stock.getStockPrice();
    }


}
