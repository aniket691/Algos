package test;

import org.junit.Test;

import java.util.*;

public class Main {

    static int[] minmax = new int[2];

    static int[] getMinMax(int arr[], int n) {
        int i;
        /* If array has even number of elements then
    initialize the first two elements as minimum and
    maximum */
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax[1] = arr[0];
                minmax[0] = arr[1];
            } else {
                minmax[0] = arr[0];
                minmax[1] = arr[1];
            }
            i = 2;
            /* set the starting index for loop */
        } /* If array has odd number of elements then
    initialize the first element as minimum and
    maximum */ else {
            minmax[0] = arr[0];
            minmax[1] = arr[0];
            i = 1;
            /* set the starting index for loop */
        }

        /* In the while loop, pick elements in pair and
     compare the pair with max and min so far */
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax[1]) {
                    minmax[1] = arr[i];
                }
                if (arr[i + 1] < minmax[0]) {
                    minmax[0] = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax[1]) {
                    minmax[1] = arr[i + 1];
                }
                if (arr[i] < minmax[0]) {
                    minmax[0] = arr[i];
                }
            }
            i += 2;
            /* Increment the index by 2 as two
               elements are processed in loop */
        }

        return minmax;
    }

//    public static void main(String[] args) {
//        Set<Integer> set  = new HashSet<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        40, 30, 20, 10, 15, 16, 17, 8, 4
//        priorityQueue.add(40);
//        priorityQueue.add(30);
//        priorityQueue.add(20);
//        priorityQueue.add(10);
//        priorityQueue.add(15);
//        priorityQueue.add(16);
//        priorityQueue.add(17);
//        priorityQueue.add(8);
//        priorityQueue.add(4);
//        priorityQueue.add(35);
//        System.out.println(priorityQueue);
//
//        System.out.println("aniket");
//
//        List<Integer> list= new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list);
//    }

    public void nextPermutation(int[] A) {
        if (A == null || A.length <= 1) return;
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) i--;
        if (i >= 0) {
            int j = A.length - 1;
            while (A[j] <= A[i]) j--;
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }

    @Test
    public void mainTest() {
        int a[] = {1, 2, 3};
        nextPermutation(a);
    }
}
