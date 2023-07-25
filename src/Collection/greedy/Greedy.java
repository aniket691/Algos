package Collection.greedy;

import java.util.Arrays;

public class Greedy {

    //https://practice.geeksforgeeks.org/problems/maximize-toys0331/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    /**
     * Intuition:
     * The `toyCount` function takes in an integer `n`, an integer `k`, and an integer array `arr`. The goal of the function is to determine the maximum number of toys that can be bought with `k` units of money. The function first sorts the array in ascending order, then initializes a `sum` variable and a `count` variable to 0. It then uses a `while` loop to iterate through the array, adding each element to the `sum` variable until the `sum` variable is greater than `k` or the end of the array is reached. For each element added to `sum`, the `count` variable is incremented. The function then returns the final `count` variable.
     * <p>
     * Algorithm:
     * 1. Sort the input array `arr` in ascending order using `Arrays.sort(arr)`
     * 2. Initialize variables `sum` and `count` to 0
     * 3. Initialize variable `i` to 0
     * 4. While `true`, do the following:
     * a. If `i` is equal to `n`, break out of the loop
     * b. Add the value of `arr[i]` to `sum`
     * c. If `sum` is greater than `k`, break out of the loop
     * d. Increment `count` by 1
     * e. Increment `i` by 1
     * 5. Return the final value of `count`
     *
     * @param n
     * @param k
     * @param arr
     * @return
     */
    static int toyCount(int n, int k, int arr[]) {
        // code here
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;

        int i = 0;
        while (true) {
            if (i == n) break;
            sum += arr[i];
            if (sum > k) break;
            count++;
            i++;
            //System.out.println(sum+" "+count);
        }

        return count;
    }


    //https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1?category=

    /**
     * Intuition:
     * The `minOperation` function takes in an integer `n` and determines the minimum number of operations required to reduce the value of `n` to zero. The function initializes two variables `op` and `num` to 0 and `n` respectively. It then uses a `while` loop to repeatedly perform operations on `num` until `num` is reduced to 0. If `num` is even, it is divided by 2 and `op` is incremented by 1. If `num` is odd, it is reduced by 1 and `op` is incremented by 1. The function then returns the final value of `op`.
     * <p>
     * Algorithm:
     * 1. Initialize variable `op` to 0
     * 2. Initialize variable `num` to `n`
     * 3. While `num` is greater than 0, do the following:
     * a. If `num` is even, divide `num` by 2 and increment `op` by 1
     * b. If `num` is odd, reduce `num` by 1 and increment `op` by 1
     * 4. Return the final value of `op`
     *
     * @param n
     * @return
     */
    public int minOperation(int n) {
        //code here.
        int op = 0;
        int num = n;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
                op++;
            } else {
                num = num - 1;
                op++;
            }
        }

        return op;
    }

    //https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1

    /**
     * Intuition:
     * The `majorityElement` function takes in an integer array `a` and an integer `size` and returns the majority element in the array. The majority element is defined as an element that appears more than `size/2` times in the array. The function initializes two variables `ele` and `count` to -1 and 0 respectively. It then uses a `for` loop to iterate through the array. For the first element in the array, `ele` is set to that element and `count` is incremented. For subsequent elements, if the current element is not equal to `ele`, `count` is decremented. If `count` reaches 0, `ele` is set to the current element. If the current element is equal to `ele`, `count` is incremented. After the loop, the function checks if the `ele` variable appears more than `size/2` times in the array. If it does, `ele` is returned as the majority element. Otherwise, the function returns -1.
     * <p>
     * Algorithm:
     * 1. Initialize variable `ele` to -1
     * 2. Initialize variable `count` to 0
     * 3. Use a `for` loop to iterate through the array `a` from index 0 to index `size-1`
     * 4. For the first element in the array, set `ele` to that element and increment `count` by 1
     * 5. For subsequent elements, do the following:
     * a. If the current element is not equal to `ele`, decrement `count` by 1
     * b. If `count` reaches 0, set `ele` to the current element
     * c. If the current element is equal to `ele`, increment `count` by 1
     * 6. After the loop, initialize variable `check` to 0
     * 7. Use another `for` loop to iterate through the array `a` from index 0 to index `size-1`
     * 8. If the current element is equal to `ele`, increment `check` by 1
     * 9. If `check` is greater than `size/2`, return `ele` as the majority element
     * 10. Otherwise, return -1
     *
     * @param a
     * @param size
     * @return
     */
    static int majorityElement(int a[], int size) {
        // your code here
        int ele = -1;
        int count = 0;


        for (int i = 0; i < size; i++) {

            if (i == 0) {
                ele = a[i];
                count++;
                continue;
            }


            if (a[i] != ele) {
                count--;
                if (count == 0) {
                    ele = a[i];
                }
            }

            if (a[i] == ele) count++;
        }

        //it is necessary tocheck that if the ele thtwe have found appears really greater than n/2 times
        int check = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == ele) check++;
        }

        if (check > size / 2) return ele;

        return -1;
    }
}
