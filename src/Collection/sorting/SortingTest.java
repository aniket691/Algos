package Collection.sorting;

import org.junit.Test;

public class SortingTest {

    @Test
    public void quickSortTest(){
        int arr[] = {3,1,4,2,5};
        Sorting.quickSort(arr,0,arr.length-1);

    }
}
