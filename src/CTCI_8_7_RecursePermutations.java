import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CTCI_8_7_RecursePermutations {

    Set<String> perms(String s) {
        Set<String> lst = new HashSet<>();
        perm(lst, new StringBuilder(s), new StringBuilder());
        return lst;
    }

    private void perm(Set<String> lst, StringBuilder s, StringBuilder res) {
        if (s.length() == 0) {
            lst.add(res.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder nextRes = new StringBuilder(res);
            StringBuilder nextS = new StringBuilder(s);
            String curChar = "" + nextS.charAt(i);

            nextRes.append(curChar);
            nextS.deleteCharAt(i);

            perm(lst, nextS, nextRes);
        }
    }


    @Test
    public void getTest() {
        List<String> ans = new ArrayList<>();
        ans.add("abc");
        ans.add("acb");
        ans.add("bac");
        ans.add("bca");
        ans.add("cab");
        ans.add("cba");

        Set<String> real = perms("acb");

        //good way to test equality of sets... either contains all both ways, or size and one containsall
        assertTrue(ans.size() == real.size());
        assertTrue(real.containsAll(ans));
    }

    @Test
    public void withDups8_8() {
        Set<String> ans = new HashSet<>();
        ans.add("aac");
        ans.add("aca");
        ans.add("aac");
        ans.add("aca");
        ans.add("caa");
        ans.add("caa");

        Set<String> real = perms("aca");

        assertEquals(ans, real);
    }


}
