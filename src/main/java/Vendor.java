import java.util.ArrayList;
import java.util.HashMap;

public class Vendor {

    private ArrayList<Stock> stockList;

    public Vendor(){
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

//    public int insertStockIntoVendingMachine(){
//        Stock stock = this.stockList.remove(0);



}
