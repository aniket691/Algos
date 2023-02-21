package Collection.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {

    public static void kthLargest(int[] arr, int k){
        Queue<Integer> q= new LinkedList<>();
        q.add(3);
        q.add(3);
        q.add(1);
        System.out.println(q.poll());
    }
}
