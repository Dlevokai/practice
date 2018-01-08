
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class CTCI_8_1_Steps {
    int hop(int stepsLeft, int hopSize){
       if(hopSize>stepsLeft){
           return -1;
       }


        int hop1 = hop(stepsLeft-1, 1) +1;
        int hop2 = hop(stepsLeft-2, 2) +1;
        int hop3 = hop(stepsLeft-3, 3) +1;

        return hop1+hop2+hop3;
    }

    @Test
    public void stepsTest(){
        Map<Integer, Integer> map = new HashMap<>();
        assertEquals(2, hop(2,0 ));
    }
}
