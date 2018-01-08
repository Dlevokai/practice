package arrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueCharacters {
    public boolean hasUniqueCharacters(String str){
        char[] chars = new char[256];

        for(char s: str.toCharArray()){
            if (chars[s] == s) {
                return false;
            } else {
                chars[s] = s;
            }
        }
        return true;
    }

    @Test
    public void testUniqueChars(){
        assertTrue(hasUniqueCharacters("1234a"));
    }

    @Test
    public void testUniqueCharsFalse(){
        assertFalse(hasUniqueCharacters("1a234a"));
    }
}
