package Collection;

//1 2 3 4 5 6
//0 1 2 3 4 5

import java.util.Arrays;

public class Temp1 {

    private static int partition1(int[] a, int si, int ei) {

        int pivot = a[si];

        int smallCount = 0;

        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivot) {
                smallCount++;
            }
        }

        //swap
        int temp = a[si + smallCount];
        a[si + smallCount] = pivot;
        a[si] = temp;

        int i = si;
        int j = ei;

        while (i < j) {
            if (a[i] < pivot) {
                i++;
            } else if (a[j] >= pivot) {
                j--;
            } else {
                int temp1 = a[i];
                a[i] = a[j];
                a[j] = temp1;
                i++;
                j--;
            }
        }

        return si + smallCount;
    }


    public static void quickSort1(int[] input, int i, int j) {
        if (i >= j) {
            return;
        }

        int p = partition1(input, i, j);
        quickSort1(input, i, p - 1);
        quickSort1(input, p + 1, j);
    }

    private static void mergeArr1(int[] arr1, int[] arr2, int[] c) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                c[k] = arr1[i];
                i++;
            } else {
                c[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            c[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            c[k] = arr2[j];
            j++;
            k++;
        }

    }


    public static void mergeSort(int[] arr) {

        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int[] s1 = new int[mid];
        int[] s2 = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            s1[i] = arr[i];
        }

        for (int j = mid; j < arr.length; j++) {
            s2[j - mid] = arr[j];
        }

        mergeSort(s1);
        mergeSort(s2);

        mergeArr1(s1, s2, arr);

    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 4, 1, 3};
        quickSort1(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);

    }

}
