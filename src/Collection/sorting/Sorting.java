package Collection.sorting;

public class Sorting {
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


}
