package Collection;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainCheatSheet {

    public static void main(String[] args) {
        int a;
        double d;
        float f;
        String s;
        char c;

        System.out.println(3.141 + 2.0);
    }

    @Test
    public void parsingCommands() {
        //converts into integer
        Integer.parseInt("5");
        //string to double
        Double.parseDouble("5.0");
        //string to long
        Long.parseLong("5L");
    }

    @Test
    public void mathFunc() {
        //returns absolute value
        Math.abs(5);
        //returns max
        Math.max(1, 2);
        //sine of a theta
        Math.sin(1.0);
        //similarly we can have cos tan cot sec cosec

        //converts into degrees
        Math.toDegrees(1.0);
        //converts into radians
        Math.toRadians(1.0);

        //tells the exponent
        Math.exp(1.0);

        //tells the logarithm
        Math.log(1.0);

        //round a number to  nearest integer which ever is near if 5.5 them 6 else less then 5 like that
        System.out.println(Math.round(5.4));

        //return random number between 0 and 1
        System.out.println(Math.random());

        //value of exponent
        System.out.println(Math.E);

        //avlue of PI
        System.out.println(Math.PI);

    }

    @Test
    public void testOutput() {
        System.out.print("");
        System.out.println();
        //formatted old c style
        //d (digit) f e (float and double) s (String) b (boolean)
        System.out.printf("%s", "string");
    }

    @Test
    public void stdInput() {
        new String("").isEmpty();
        new BufferedReader(new InputStreamReader(System.in));
        new Scanner(System.in).next();
    }

    //TODO: learn random class
    public void randomTest() {
        Random random = new Random();
        random.setSeed(5L);
    }

    @Test
    public void stringTest() {

        String dummy = "Dummy";
        //01234

        //create a string with same value
        new String(dummy);
        char[] arr = new char[5];
        arr[0] = 'a';
        arr[1] = 'b';
        arr[2] = 'c';
        arr[3] = 'd';

        //make a string from characters
        System.out.println(new String(arr));

        //length

        //charAt

        //substring(int i, int j)
        //i inclusive j exclusive
        System.out.println(dummy.substring(1, 3));

        //contains()

        System.out.println(dummy.startsWith("d"));

        //index of

        //last index of

        //concat

        //-1 0 1 lexicogrally less equal or greater
        System.out.println(dummy.compareTo("dummu"));

        //tolowercae

        //touppercase

        //replace() used instead of remove

        //removes leading and trailing both white spaces
        System.out.println(dummy.trim());

        //for regular expressions
        //use matches(String regex)  function

        //split()

        //equal

        //hashcode()


    }

    @Test
    public void queueTest() {
        Queue<Integer> q = new ArrayDeque<>();
        q.isEmpty();
        System.out.println('G' - 'A');
    }


}

