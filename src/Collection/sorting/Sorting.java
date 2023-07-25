package Collection.sorting;

import java.util.*;


public class Sorting {

    //https://practice.geeksforgeeks.org/problems/permutations-in-array1747/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * @param a
     * @param b
     * @param n
     * @param k
     * @return
     */
    public boolean isPossible(long a[], long b[], int n, long k) {

        // Your code goes here
        boolean flag = false;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < b.length / 2; i++) {
            long temp = b[i];
            b[i] = b[b.length - 1 - i];
            b[b.length - 1 - i] = temp;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] + b[i] >= k) flag = true;
            else {
                flag = false;
            }
        }
        return flag;
    }

    /************************QUICK SORT START*********************************/
    public static int partition(int[] a, int si, int ei) {
        int pivot = a[si];

        int smallCount = 0;

        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivot) {
                smallCount++;
            }
        }

        int temp = a[si + smallCount];
        a[si + smallCount] = pivot;
        a[si] = temp;

        int i = si;
        int j = ei;

        while (i < j) {
            // findinf bigger ele
            if (a[i] < pivot) {
                i++;
            } else if (a[j] >= pivot) {
                //when we find smaller its better to check equal other wise if u check
                //bigger and equal to we might accidently change the pivot
                // finding smaller
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

    public static void quickSort(int[] input, int i, int j) {
        // your code goes here
        if (i >= j) {
            return;
        }
        int p = partition(input, i, j);
        quickSort(input, i, p - 1);
        quickSort(input, p + 1, j);

    }
    /************************QUICK SORT END*********************************/

    /*******************************MERGE SORT START******************************/
    public static void mergeArr(int[] arr1, int[] arr2, int[] c) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {

            if (arr1[i] <= arr2[j]) {
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

    public static void mergeSort(int arr[]) {

        int mid = arr.length / 2;
        //TODO : handle error here
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int j = mid; j < arr.length; j++) {
            right[j - mid] = arr[j];
        }

        mergeSort(left);
        mergeSort(right);

        mergeArr(left, right, arr);

    }
    /*******************************MERGE SORT END******************************/


    /**********************COUNT SORT START**************************************/
    //https://www.geeksforgeeks.org/counting-sort/

    /**
     * @param arr
     */
    public static void countSort(int arr[]) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int freq[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

//        for(int i : freq) System.out.print(i+" ");

        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int ind = --freq[arr[i]];
            ans[ind] = arr[i];
        }

//        for (int i : ans) System.out.print(i + " ");

    }
    /**********************COUNT SORT END**************************************/


    //https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

    /**
     * @param arr1
     * @param arr2
     * @param arr3
     * @param n1
     * @param n2
     * @param n3
     * @return
     */
    ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();
        // code here
        int i = 0;
        int j = 0;
        int k = 0;
        int prev1 = Integer.MIN_VALUE, prev2 = Integer.MIN_VALUE, prev3 = Integer.MIN_VALUE;
        while (i < n1 && j < n2 && k < n3) {
            while (i < n1 && arr1[i] == prev1)
                i++;
            while (j < n2 && arr2[j] == prev2)
                j++;
            while (k < n3 && arr3[k] == prev3)
                k++;
            if (i < n1 && j < n2 && k < n3) {
                if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                    ans.add(arr1[i]);
                    prev1 = arr1[i];
                    prev2 = arr2[j];
                    prev3 = arr3[k];
                    i++;
                    j++;
                    k++;
                } else if (arr1[i] < arr2[j]) {
                    prev1 = arr1[i];
                    i++;
                } else if (arr2[j] < arr3[k]) {
                    prev2 = arr2[j];
                    j++;
                } else {
                    prev3 = arr3[k];
                    k++;
                }
            }
        }
        return ans;
    }

    /*********************RADIX SORT START*************************************/
    public static void countForRadixSort(int[] arr, int exp) {

        int[] ans = new int[arr.length];

        //because no 0 to 9
        int[] freq = new int[10];

        //arr[i/exp%10]
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] / exp % 10]++;
        }

        System.out.println("freq array before: ");
        for (int i : freq) System.out.print(i + " ");

        System.out.println();

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        System.out.println("freq array after: ");
        for (int i : freq) System.out.print(i + " ");

        //stable sorting
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = freq[arr[i] / exp % 10] - 1;
            ans[pos] = arr[i];
            freq[arr[i] / exp % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }


    }

    //buckets should be square root of the range
    public static void radixSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) max = j;
        }

        int exp = 1;
        while (exp <= max) {
            System.out.println("exp: " + exp);
            countForRadixSort(arr, exp);
            System.out.println();
            exp = exp * 10;
        }
    }
    /*********************RADIX SORT END*************************************/


    //https://practice.geeksforgeeks.org/problems/common-elements1132/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    //approach 1 :

    /**
     * method-1
     * If x, y and z are same, we can simply print any of them as common
     * element and move ahead in all three arrays.
     * Else If x < y, we can move ahead in ar1[] as x cannot be a common element.
     * Else If x > z and y > z), we can simply move ahead in ar3[] as z cannot be a common element.
     * This approach is extension of merge methods.This teaches us if u want find
     * common just move find smaller elements and move ahead else
     * move remaining pointer
     * => This approach fails for duplicate values
     * <p>
     * method-2
     * If x = prev1, move ahead in ar1[] and repeat the procedure until x != prev1. Similarly, apply the same for the ar2[] and ar3[].
     * If x, y, and z are same, we can simply print any of them as common element, update prev1, prev2, and prev3 and move ahead in all three arrays.
     * Else If (x < y), we update prev1 and move ahead in ar1[] as x cannot be a common element.
     * Else If (y < z), we update prev2 and move ahead in ar2[] as y cannot be a common element.
     * Else If (x > z and y > z), we update prev3 and we move ahead in ar3[] as z cannot be a common element.
     * <p>
     * Corner cases =>
     * Handle duplicates
     *
     * @param ar1
     * @param ar2
     * @param ar3
     * @return
     */
    ArrayList<Integer> commonElements(int ar1[], int ar2[], int ar3[]) {

        // Initialize starting indexes for ar1[],
        // ar2[] and ar3[]
        int i = 0, j = 0, k = 0;
        int n1 = ar1.length;
        int n2 = ar2.length;
        int n3 = ar3.length;

        // Declare three variables prev1,
        // prev2, prev3 to track previous
        // element
        int prev1, prev2, prev3;

        // Initialize prev1, prev2,
        // prev3 with INT_MIN
        prev1 = prev2 = prev3 = Integer.MIN_VALUE;

        while (i < n1 && j < n2 && k < n3) {

            // If ar1[i] = prev1 and i < n1,
            // keep incrementing i
            while (i < n1 && ar1[i] == prev1)
                i++;

            // If ar2[j] = prev2 and j < n2,
            // keep incrementing j
            while (j < n2 && ar2[j] == prev2)
                j++;

            // If ar3[k] = prev3 and k < n3,
            // keep incrementing k
            while (k < n3 && ar3[k] == prev3)
                k++;

            if (i < n1 && j < n2 && k < n3) {

                // If x = y and y = z, print any of
                // them, update prev1 prev2, prev3
                // and move ahead in each array
                if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                    System.out.print(ar1[i] + " ");
                    prev1 = ar1[i];
                    prev2 = ar2[j];
                    prev3 = ar3[k];
                    i++;
                    j++;
                    k++;
                }

                // If x < y, update prev1
                // and increment i
                else if (ar1[i] < ar2[j]) {
                    prev1 = ar1[i];
                    i++;
                }

                // If y < z, update prev2
                // and increment j
                else if (ar2[j] < ar3[k]) {
                    prev2 = ar2[j];
                    j++;
                }

                // We reach here when x > y
                // and z < y, i.e., z is
                // smallest update prev3
                // and increment k
                else {
                    prev3 = ar3[k];
                    k++;
                }
            }
        }
        return new ArrayList<>();
    }

    //https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * @param arr
     * @param n
     * @param x
     * @param k
     * @return
     */
    public static int search(int arr[], int n, int x, int k) {
        //Complete the function

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }

        return -1;
    }

    //https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

    /**
     * @param arr
     * @param low
     * @param high
     * @param x
     * @return
     */
    static int ceilSearch(int arr[], int low, int high, int x) {
        int i;

      /* If x is smaller than or equal to first
         element,then return the first element */
        if (x <= arr[low])
            return low;

        /* Otherwise, linearly search for ceil value */
        for (i = low; i < high; i++) {
            if (arr[i] == x)
                return i;

        /* if x lies between arr[i] and arr[i+1]
        including arr[i+1], then return arr[i+1] */
            if (arr[i] < x && arr[i + 1] >= x)
                return i + 1;
        }

      /* If we reach here then x is greater than the
      last element of the array,  return -1 in this case */
        return -1;
    }

    //https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * @param arr
     * @param l
     * @param h
     * @param target
     * @return
     */
    public int binarySearch(int arr[], int l, int h, int target) {
        int i = l;
        int j = h;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else if (target > arr[mid]) {
                i = mid + 1;
            }
        }
        return -1;
    }

    public boolean findPair(int arr[], int size, int n) {
        //code here.
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            int ans = binarySearch(arr, 0, arr.length - 1, arr[i] + n);
            if (ans != -1) return true;
        }
        return false;
    }


}


