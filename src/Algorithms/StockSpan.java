package Algorithms;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    public static int[] stockSpan(int[] arr) {
        int[] stkSpan = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        //we are playing with index
        stk.push(0);
        stkSpan[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            //till array size is not empty and arr[i] > arr[stk.peek()]
            // main tere se bada hu condition checking
            while (stk.size() > 0 && arr[i] > arr[stk.peek()]) {
                stk.pop();
            }
            //curr is max
            if (stk.size() == 0) {
                stkSpan[i] = i + 1;
            } else {
                //calculate span with index
                stkSpan[i] = i - stk.peek();
            }
            //push curr
            stk.push(i);
        }
        return stkSpan;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            //take input for the array
            int[] inArr = new int[n];
            for (int i = 0; i < inArr.length; i++) {
                inArr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            ans = stockSpan(inArr);
            for (int an : ans) {
                System.out.println(an);
            }
        }
    }
}
