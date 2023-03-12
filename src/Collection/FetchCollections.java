package Collection;

import org.junit.Test;

import java.util.*;

public class FetchCollections {

    @Test
    public void arrayTest() {

        //array implementation of list
        List<Integer> arrayList = new ArrayList<>();

        //linked list implementation of list
        List<Integer> arrayList2 = new LinkedList<>();

        //vector implementation of list
        List<Integer> arrayList3 = new Vector<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add((i));
            arrayList2.add((i));
            arrayList3.add((i));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        //using lamda
        arrayList.forEach(System.out::println);
    }

    @Test
    public void queueTest() {

        //queue with linked list implementation
        Queue<Integer> q1 = new LinkedList<>();

        //queue array doubly ended queue insert and remove from both side
        Queue<Integer> q2 = new ArrayDeque<>();

        //priority queue max and min heap
        Queue<Integer> q3 = new PriorityQueue<>();


        for (int i = 0; i < 10; i++) {

            q1.add(i);
            q1.offer(i);

            q2.add(i);
            q2.offer(i);

            q3.add(i);
            q3.offer(i);
        }

        //just get the ele does not remove
        Integer ele = q1.element();

        //removes throws exception
        //poll returns null if q is empty
        for (int i = 0; i < q1.size(); i++) System.out.println(q3.remove() + " " + q1.poll());
    }

    @Test
    public void setTest() {

        // no order
        Set<Integer> set = new HashSet<>();

        //maintains insertion order
        Set<Integer> set2 = new LinkedHashSet<>();

        //maintains sorting order
        Set<Integer> set3 = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        Iterator i = set.iterator();
        while (i.hasNext()) System.out.println(i.next());
    }

    @Test
    public void mapTest() {
        /**
         * Hashmap does not maintain any order
         */
        Map<Integer, String> map = new HashMap<>();
        /**
         * Linked Hashmap maintains insertion order
         */
        Map<Integer, String> map2 = new LinkedHashMap<>();
        /**
         * Treemap sorts the map in ascending order
         */
        Map<Integer, String> map3 = new TreeMap<>();


        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }

        for (Map.Entry ele : map.entrySet()) {
            System.out.println(ele.getKey() + " word: " + ele.getValue());
        }


    }
}
