import java.util.ArrayList;

public class Customer {

    private double wallet;
    private ArrayList<Stock> purchasedSnacks;

    public Customer(double wallet){
        this.wallet = wallet;
        this.purchasedSnacks = new ArrayList<>();
    }

    public double getWalletAmount(){
        return this.wallet;
    }

    public ArrayList<Stock> getPurchasedSnacks() {
        return this.purchasedSnacks;
    }

    public void payForItem(Stock stock){
       this.wallet -= stock.getStockPrice();
    }
}
