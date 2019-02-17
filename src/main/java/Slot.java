public enum Slot {

    ONE("A1", 1),
    TWO("A", 2),
    THREE("A", 3),
    FOUR("B", 1),
    FIVE("B", 2),
    SIX("B", 3),
    SEVEN("C", 1),
    EIGHT("C", 2),
    NINE("C", 3),
    TEN("D", 1),
    ELEVEN("D", 2),
    TWELVE("D", 3),
    THIRTEEN("E", 1),
    FOURTEEN("E", 2),
    FIFTEEN("E", 3);

    final String row;
    final int column;

     Slot(String row, int column){
        this.row = row;
        this.column = column;
    }

    public String getRow(){
         return this.row;
    }

    public int getColumn(){
         return this.column;
    }
}


