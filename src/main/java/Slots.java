public enum Slots {

    ONE("A", 1),
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

    private final String row;
    private final int column;

    Slots(String row, int column){
        this.row = row;
        this.column = column;
    }
}
