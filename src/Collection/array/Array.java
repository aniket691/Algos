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
            curr += nums[i];
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

        //TODO: try slow fast pointer
    }

    //https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

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
     * @param arr
     * @param target
     * @return
     */
    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1; //<---step 1
        while (low <= high) { //<--- step 2
            int mid = (low + high) / 2; //<----step 3
            if (arr[mid] == target)
                return mid; // <---step 4
            if (arr[low] <= arr[mid]) { //<---step 5
                if (arr[low] <= target && arr[mid] >= target)
                    high = mid - 1; //<---step 6
                else
                    low = mid + 1; //<---step 7
            } else { //<---step 7
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1; //<---step 8
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
    //https://www.notion.so/Images-DSA-e319f659179d4ef790f8266dc86404c2?pvs=4#8b5d284d84144bf090df9bf856b0cf50

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

    /**
     * use prefix sum and suffix sum(product in this case) concept but instead of doing it in separate array
     * calculate it in the array only without using extra space
     * main curr variable
     * every time do ans[i]*curr and the insert nums[i] into curr
     * from i to n
     * after that do it in reverse order this will mimic prefix and suffix sum logic
     * without using extra space
     *
     * @param arr
     * @return
     */
    //https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int ans[] = new int[arr.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] *= curr;
            curr *= arr[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= arr[i];
        }
        return ans;
    }

    //https://leetcode.com/problems/trapping-rain-water/
    //TODO: trapping rainwater problem - hard


    //https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/?ref=lbp
    //TODO: Find if there is a pair with a given sum in the rotated sorted Array

    // https://leetcode.com/problems/maximum-product-subarray

    /**
     * Case1 :- All the elements are positive : Then your answer will be product of all the elements in the array.
     * Case2 :- Array have positive and negative elements both :
     * If the number of negative elements is even then again your answer will
     * be complete array because on multiplying all the negative numbers it will become positive.
     * If the number of negative elements is odd then you have to remove just one
     * negative element and for that u need to check your subarrays to get the max product.
     * Case3 :- Array also contains 0 : Then there will be not much difference...its
     * just that your array will be divided into subarray around that 0. What u have to so is just as soon as your product becomes 0 make it 1 for the next iteration, now u will be searching new subarray and previous max will already be updated.
     * *(These cases are much clear in approach 3)
     * explanation link below
     */
    //https://www.notion.so/Images-DSA-e319f659179d4ef790f8266dc86404c2?pvs=4#ee8ae7611ad74a69957067c0ee773824
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int l = 1, r = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of l or r become 0 then update it to 1
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[n - 1 - i];    //suffix product

            ans = Math.max(ans, Math.max(l, r));

        }

        return ans;

    }
}




