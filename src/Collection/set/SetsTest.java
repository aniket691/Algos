package Collection.set;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetsTest {

    @Test
    public void linkedHashSetTest() {

        /**
         * LinkedHashSet maintains insertion orders for
         * characters and string
         * TODO: not sure for integers
         */
        Set<Character> set = new LinkedHashSet<>();
        set.add('a');
        set.add('z');
        set.add('e');

        for (Character ele : set) System.out.println(ele);
    }
}
