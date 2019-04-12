public class Coin implements Comparable<Coin> {

  private String type;
  private double value;

  public Coin (String type, double value){
      this.type = type;
      this.value = value;
    }


  public String getType() {
    return this.type;
  }

  public double getValue(){
    return this.value;
  }

//  implements built-in interface Comparable -- if the object being compared to the object passed in is less than,
//  the function returns int -1 // for greater than, returns int 1;
  @Override
  public int compareTo(Coin coin) {
    if(this.getValue()<coin.getValue())
      return -1;
    else if(coin.getValue()<this.getValue())
      return 1;
    return 0;
  }


}
