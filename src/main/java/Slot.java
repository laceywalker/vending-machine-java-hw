public enum Slot {

    A1("A1", 1),
    A2("A2", 1),
    A3("A3", 1),
    B1("B1", 2),
    B2("B2", 2),
    B3("B3", 2),
    C1("C1", 3),
    C2("C2", 3),
    C3("C3", 3),
    D1("D1", 4),
    D2("D2", 4),
    D3("D3", 4),
    E1("E1", 5),
    E2("E2", 5),
    E3("E3", 5);

    final String position;
    final int capacity;

     Slot(String position, int capacity){
        this.position = position;
        this.capacity = capacity;
    }

    public String getPosition(){
         return this.position;
    }

    public int getCapacity(){
         return this.capacity;
    }
}


