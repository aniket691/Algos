package Collection.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stacks {

    //https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * The given code evaluates a postfix expression (also known as reverse polish notation).
     * <p>
     * Intuition:
     * The algorithm uses a stack data structure to evaluate the postfix expression.
     * The postfix expression consists of operands and operators, and the algorithm iterates through each character in the expression.
     * If the character is an operand (i.e., a digit), it is pushed onto the stack.
     * If the character is an operator (i.e., '+', '-', '*', or '/'), two operands are popped from the stack,
     * the operator is applied to them, and the result is pushed back onto the stack.
     * This process is repeated until the end of the expression is reached, and the final result is obtained from the stack.
     * <p>
     * Algorithm:
     * 1. Create an empty stack of integers.
     * 2. If the input string is empty, return 0.
     * 3. Iterate through each character in the input string:
     * a. If the character is a digit, convert it to an integer and push it onto the stack.
     * b. If the character is an operator ('+', '-', '*', or '/'), pop two integers from the stack,
     * apply the operator to them, and push the result back onto the stack.
     * 4. After iterating through the entire input string, there should be only one element left on the stack,
     * which is the final result. Pop it from the stack and return it.
     *
     * @param str
     * @return
     */
    public static int evaluatePostFix(String str) {
        // Your code here
        Stack<Integer> stk = new Stack<>();

        if (str.length() == 0) return 0;

        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {

                int ele = str.charAt(i) - '0';
                //System.out.println(ele);
                stk.push(ele);
            } else {

                switch (str.charAt(i)) {

                    case '*':
                        int f = stk.pop();
                        int s = stk.pop();
                        //System.out.println(f+" "+s);
                        stk.push(s * f);
                        break;

                    case '+':
                        f = stk.pop();
                        s = stk.pop();
                        //System.out.println(f+" "+s);
                        stk.push(s + f);
                        break;

                    case '/':
                        f = stk.pop();
                        s = stk.pop();
                        //System.out.println(f+" "+s);
                        stk.push(s / f);
                        break;

                    case '-':
                        f = stk.pop();
                        s = stk.pop();
                        //System.out.println(f+" "+s);
                        stk.push(s - f);
                        break;
                }
            }
        }

        return stk.pop();
    }

    //https://leetcode.com/problems/implement-stack-using-queues/submissions/

    /**
     * Algorithm:
     * - We have two queues `q1` and `q2` initialized in the constructor.
     * - Whenever we push an element, we add it to the `q1` queue.
     * - When we pop an element, we move all elements except the last one from `q1` to `q2` queue.
     * We then remove and return the last element from `q1` and move all elements from `q2` back to `q1`.
     * - When we want to get the top element, we move all elements except the last one from `q1` to `q2` queue.
     * We then remove and return the last element from `q1`, move all elements from `q2` back to `q1`,
     * and finally add the last element back to `q1`.
     * - We determine if the stack is empty by checking if both `q1` and `q2` are empty.
     * <p>
     * Intuition:
     * - We are implementing a stack using two queues, `q1` and `q2`.
     * - We add elements to the `q1` queue when we push.
     * - When we want to pop an element, we need to remove the last element from the stack. To do this,
     * we first move all elements except the last one from `q1` to `q2`. We then remove and return the last element from `q1`.
     * Finally, we move all elements from `q2` back to `q1`.
     * - When we want to get the top element, we also need to remove the last element from the stack. To do this,
     * we follow the same process as in the pop() method, but we also add the last element back to `q1`.
     * - We determine if the stack is empty by checking if both `q1` and `q2` are empty.
     */
    class MyStack {

        Queue<Object> q1 = new LinkedList<>();
        Queue<Object> q2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            while (q1.size() != 1) {
                q2.add(q1.remove());
            }
            int toReturn = (int) q1.remove();
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
            return toReturn;
        }

        public int top() {
            while (q1.size() != 1) {
                q2.add(q1.remove());
            }
            int toReturn = (int) q1.remove();
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
            q1.add(toReturn);
            return toReturn;
        }

        public boolean empty() {
            return q1.size() == 0 && q2.size() == 0;
        }
    }

}

class twoStacks {
    int arr[];
    int size;
    int top1, top2;

    twoStacks() {
        size = 100;
        arr = new int[100];
        top1 = -1;
        top2 = size;
    }

    //Function to push an integer into the stack1.
    void push1(int x) {
        if (top1 == arr.length) return;
        arr[++top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x) {
        if (top2 == -1) return;
        arr[--top2] = x;
    }

    //Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 == -1) return -1;
        return arr[top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 == arr.length) return -1;
        return arr[top2++];
    }
}
