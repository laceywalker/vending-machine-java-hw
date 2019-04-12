import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin;
    Coin fiftyPence;

    @Before
    public void before(){
        coin = new Coin("pence", 0.01);
    }

    @Test
    public void coinHasType(){
        assertEquals("pence", coin.getType());
    }

    @Test
    public void coinHasValue(){
        assertEquals(0.01, coin.getValue(), 0.01);
    }

//    @Test
//    public void canCompareCoinValues(){
//        int result = coin.compareTo(fiftyPence);
//        System.out.print(result);
////        assertEquals(-1, result);
//    }

}
