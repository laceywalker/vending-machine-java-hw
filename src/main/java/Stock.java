public class Stock {

    private String name;
    private double price;

    public Stock(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getStockName(){
        return this.name;
    }

    public double getStockPrice(){
        return this.price;
    }
}
