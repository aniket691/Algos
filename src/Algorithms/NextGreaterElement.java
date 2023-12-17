package Algorithms;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i = 1; i < arr.length; i++) {
            //till array size is not empty and arr[i] > arr[stk.peek()]
            while (stk.size() > 0 && arr[i] > arr[stk.peek()]) {
                //tracking the greater ele than curr and pop
                int pos = stk.peek();
                nge[pos] = arr[i];
                stk.pop();
            }
            //push curr
            stk.push(i);
        }

        //for those who does not have any greater
        while (stk.size() > 0) {
            int pos = stk.peek();
            arr[pos] = -1;
        }
        return nge;
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
            ans = nextGreater(inArr);
            for (int an : ans) {
                System.out.println(an);
            }
        }
    }
}
