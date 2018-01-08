import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CTCI_8_4_PowerSet {

    Set<Set<String>> powerSet(Set input) {
        Set<Set<String>> cont = new HashSet<>();

        power(input, cont);
        return cont;
    }

    private void power(Set<String> input, Set<Set<String>> cont) {
        if (input.size() == 0) {
            return;
        }

        cont.add(input);

        input.forEach(i -> {
            Set<String> nextSet = new HashSet<>();
            nextSet.addAll(input);
            nextSet.remove(i);

            //makes it dynamic
            if (cont.contains(nextSet)) {
                return;
            }
            power(nextSet, cont);
        });
    }

    @Test
    public void testSet(){
        Set<String> s1,s2,s3,s4,s5,s6,s7;
        s1 = new HashSet<>();
        s2 = new HashSet<>();
        s3 = new HashSet<>();
        s4 = new HashSet<>();
        s5 = new HashSet<>();
        s6 = new HashSet<>();
        s7 = new HashSet<>();
        Set<Set<String>> expected = new HashSet<>();

        s1.add("a"); s1.add("b"); s1.add("c");
        s2.add("a"); s2.add("b");
        s3.add("a"); s3.add("c");
        s4.add("b"); s4.add("c");
        s5.add("a");
        s6.add("b");
        s7.add("c");
        expected.add(s1);expected.add(s2);expected.add(s3);expected.add(s4);
        expected.add(s5);expected.add(s6);expected.add(s7);

        assertEquals(expected, powerSet(s1));

    }
}
