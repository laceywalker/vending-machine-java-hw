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

  @Override
  public int compareTo(Coin coin) {
    if(this.getValue()<coin.getValue())
      return -1;
    else if(this.getValue()<this.getValue())
      return 1;
    return 0;
  }


}
