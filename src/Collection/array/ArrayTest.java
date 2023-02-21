package Collection.array;

import org.junit.Test;

import java.util.ArrayList;

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

    }

    @Test
    public void arrayListMethods() {

    }
}
