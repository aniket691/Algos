package Collection.array;


import java.util.*;


public class Array {

    //https://www.google.com/url?q=https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/&sa=D&source=editors&ust=1676984418030299&usg=AOvVaw2iYp2cXzvC76Y1HUKXVKog

    /**
     * reverse an array
     * start with i and j
     * compare with arr[i] and arr[j]
     * i++
     * j--
     *
     * @param arr
     * @param start
     * @param end
     */
    static void reverseArray(int arr[],
                             int start, int end) {
        int temp;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //https://www.google.com/url?q=https://leetcode.com/problems/maximum-subarray/&sa=D&source=editors&ust=1676984418030415&usg=AOvVaw11kcBhJcrek7ploXzdslKP

    /**
     * Use kadane's algorithm
     * track max variable
     * if sum < 0  the sum will become 0
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(curr, max);
            if (curr < 0) curr = 0;
        }
        return max;
    }

    //https://www.google.com/url?q=https://leetcode.com/problems/contains-duplicate/&sa=D&source=editors&ust=1676984418030551&usg=AOvVaw2KSOxUwWBRYg7Qu22O_A56

    /**
     * Check arr[i] and arr[i-1]
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) flag = true;
        }
        return flag;
    }

    //https://www.google.com/url?q=https://www.geeksforgeeks.org/chocolate-distribution-problem/&sa=D&source=editors&ust=1676984418030662&usg=AOvVaw0CxYbEsyCp97SaPcjX_sHh

    /**
     * Choclate distribution problem
     * trick:
     * sort
     * check arr[i+m-1] and - arr[i] < min
     *
     * @param a
     * @param n
     * @param m
     * @return
     */
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // your code here
        Collections.sort(a);
        long min = Long.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            if (a.get(i + m - 1) - a.get(i) < min) min = (long) a.get(i + m - 1) - a.get(i);
        }
        return min;
    }

    //https://www.google.com/url?q=https://leetcode.com/problems/search-in-rotated-sorted-array/&sa=D&source=editors&ust=1676984418030770&usg=AOvVaw31wmBEjUraK3zx_d2I073X

    /**
     * search in a sorted rotated array
     * use pivot point concept
     * find pivot
     * check where our target lies in the left or right
     * and use quick sort concept to search the target
     *
     * @param A
     * @param target
     * @return
     */
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }

    //https://leetcode.com/problems/next-permutation/

    /**
     * 1 4 2 3
     * ans = a[i] < ar[i+1]
     * ans-1
     * 4
     * 3
     * <p>
     * trick :
     * from reverse a[i] < a[i+1]  = pivot
     * from reverse find greater pivot
     * swap(pivot,greater)
     * reverse(pivot+1,arr,length-1)
     * <p>
     * 1 2 3 4
     * 1 2 4 3
     * 1 3 2 4
     * 1 3 4 2
     * 1 4 2 3
     * 1 4 3 2
     * 2 1 3 4
     * 2 1 4 3
     **/


    void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

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

    /**
     * best time to buy and sell stocks
     * take mini = a[0]
     * profit  = 0
     * track max profit
     * and track mini cost of stock
     *
     * @param a
     * @return
     */

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] a) {
        int mini = a[0];
        int profit = 0;
        int cost = 0;


        for (int i = 0; i < a.length; i++) {
            cost = a[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, a[i]);
        }

        return profit;
    }

    //https://leetcode.com/problems/kth-largest-element-in-an-array/

    /**
     * find kth largest and smallest
     * use priority queue max heap
     * alternative approach quick select
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for (int i = 1; i <= k - 1; i++) {
            q.poll();
        }
        return q.poll();
    }

    //https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

    /**
     * first do xor of all elements in array
     * then do xor to 1 to n
     * then find right most bit
     * then differentiate elements on the basis of right most bit set or unset
     * then check x is present or y is present and mark it as repeating or missing
     *
     * @param arr
     * @param n
     * @return
     */
    int[] findTwoElement(int arr[], int n) {
        int ans[] = new int[2];
        // code here
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }
        int rsb = xor & -xor;
        int x = 0;
        int y = 0;
        for (int val : arr) {
            if ((val & rsb) == 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if ((i & rsb) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        for (int val : arr) {
            if (val == x) {
                ans[0] = x;
                ans[1] = y;
                break;
            } else if (val == y) {
                ans[0] = y;
                ans[1] = x;
                break;
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/trapping-rain-water/
    //TODO: trapping rainwater problem - hard


}




