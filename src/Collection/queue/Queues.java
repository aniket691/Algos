package Collection.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Queues {

    public static void kthLargest(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(3);
        q.add(1);
        System.out.println(q.poll());
    }

    //https://practice.geeksforgeeks.org/problems/queue-reversal/1

    /**
     * Intuition:
     * The given code is for reversing a queue using a stack.
     * We create an empty stack and push all the elements from the queue into the stack.
     * Then we pop all the elements from the stack and push them back into the queue.
     * The resulting queue will be a reversed version of the original queue.
     * <p>
     * Algorithm:
     * 1. Start the function rev(Queue q).
     * 2. Create an empty stack stk.
     * 3. While the queue q is not empty do the following:
     * a. Remove the element from the front of the queue using q.remove() and push it onto the stack using stk.push().
     * 4. While the stack stk is not empty do the following:
     * a. Pop the element from the top of the stack using stk.pop() and add it to the back of the queue using q.add().
     * 5. Return the reversed queue q.
     * tc O(n)
     * sc O(n)
     *
     * @param q
     * @return
     */
    public Queue<Integer> rev(Queue<Integer> q) {


        //add code here.
        Stack<Integer> stk = new Stack<>();

        while (!q.isEmpty()) {
            stk.push(q.remove());
        }

        while (!stk.isEmpty()) {
            q.add(stk.pop());
        }

        return q;
    }

    /**
     * Intuition:
     * The above code snippet represents a recursive implementation of reversing a queue. In this implementation,
     * the function takes a queue as input and recursively reverses the order of the elements in the queue using a temporary variable.
     * <p>
     * Algorithm:
     * 1. Define a recursive function revRecur(Queue<Integer> q) that takes a queue as input and returns a queue.
     * 2. Check if the queue is empty. If it is empty, return the queue.
     * 3. If the queue is not empty, remove the front element from the queue and store it in a temporary variable ele.
     * 4. Recursively call the function revRecur() with the remaining queue.
     * 5. Add the element ele to the queue.
     * 6. Return the queue.
     * <p>
     * Time Complexity: The time complexity of this implementation is O(n) because it uses recursion to traverse the queue n times,
     * where n is the number of elements in the queue.
     *
     * @param q
     * @return
     */
    public static Queue<Integer> revRecur(Queue<Integer> q) {

        if (q.isEmpty()) return q;

        int ele = q.remove();

        revRecur(q);

        q.add(ele);

        return q;
    }


}
