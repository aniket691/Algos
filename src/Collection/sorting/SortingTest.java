package Collection.sorting;

import org.junit.Test;

public class SortingTest {

    @Test
    public void quickSortTest() {
        int arr[] = {3, 1, 4, 2, 5};
        Sorting.quickSort(arr, 0, arr.length - 1);

    }

    @Test
    public void testMerge() {
        int[] l1 = {1, 3, 5, 6, 7};
        int[] l2 = {5, 6, 7, 8, 9, 10};
        int[] ans = new int[l1.length + l2.length];
        Sorting.mergeArr(l1, l2, ans);
        for (int i : ans) System.out.print(i + " ");

    }

    @Test
    public void testCount() {
        int[] arr = {151, 89, 876, 232};
        Sorting.radixSort(arr);
        //for (int i : arr) System.out.print(i + " ");
    }
}
