package Collection.array;

import org.junit.Test;

import java.util.*;

public class ArrayTest {
    @Test
    public void dummyTest() {

    }

    @Test
    public void arrayListTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        for (int i : arrayList) System.out.println(i);

        //add all
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList.addAll(arrayList);

        //add at specific index
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList.addAll(0, arrayList);

        //arrayList.clear();

        arrayList.ensureCapacity(6);

        arrayList.lastIndexOf(3);
        Object[] arr = arrayList.toArray();
        for (Object i : arr) {
            System.out.println(i + "");

        }


    }

    @Test
    public void arrayTestMap() {

        String str = "aacc";
        String str1 = "ccac";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) - 1);
            }
        }

        for (Character c : map.keySet()) {
            System.out.println(map.toString());
        }

    }


    @Test
    public void arrayTestFetch() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add((i));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        //using lamda
        arrayList.forEach(System.out::println);

    }


    @Test
    public void testHash() {
        Set set = new HashSet();
        set.add("5");

        System.out.println(set.add("5"));
    }


}
