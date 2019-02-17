import java.util.ArrayList;
import java.util.HashMap;

public class Vendor {

    private ArrayList<Stock> stockList;

    public Vendor(Slot slot){
        this.stockList = new ArrayList<>();

    }

    public int getStockListCount(){
        return this.stockList.size();
    }

    public void addToStockList(Stock stock){
        this.stockList.add(stock);
    }

    public void removeStock(){
        this.stockList.remove(0);
    }


}