package Collection.string;

import org.junit.Test;

import java.util.Arrays;

public class StringTest {

    @Test
    public void stringTest() {
        String str = "aniket";
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(i-1))
                str = str.replace(String.valueOf(str.charAt(i)), "");
        }
        System.out.println(str);

    }

    @Test
    public void testString() {
        String[] myArray = {"orange", "apple", "banana"};
        Arrays.sort(myArray);
        for (String ele : myArray) System.out.println(ele + " ");
    }
}
