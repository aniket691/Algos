package Collection.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    public void qTest() {
        int[] arr = {1, 2, 3};
        Queues.kthLargest(arr, 2);

    }

    @Test
    public void reverseQTest() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        Queue<Integer> ans = Queues.revRecur(q);
        while (!ans.isEmpty()) System.out.println(ans.remove());
    }

}
