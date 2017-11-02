package arrays;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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
