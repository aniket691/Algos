package Collection.array;


import java.util.*;


public class Array {

    //TODO:max min in an array
    //https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

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
     * <p>
     * left or right half one of them should be sorted(and will be sorted
     * therefore we are checking on the both the side we don't know left or right which is sorted
     * so we have to find it
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
     * repeating and missing
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

    /**
     * use kadane's algorihtm from both side
     *
     * @param nums
     * @return
     */
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


    public boolean isPalindrome(String s) {

        //String str = preprocess(s);
        //System.out.print(str);
        //return  isStringPalindrome(str);

        //String s1 = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        //String s2 = new StringBuilder(s1).reverse().toString();
        //return s2.equals(s1);

        // s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        //         int i = 0;
        //         int j = s.length() - 1;
        //         while(i <= j) {
        //             if (s.charAt(i) != s.charAt(j)) {
        //                 return false;
        //             }
        //             i++;
        //             j--;
        //         }
        //         return true;

        s = s.toLowerCase();

        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {

            if (s.length() == 1) return true;

            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;

            if (i == s.length()) return true;

            while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (s.charAt(i) != s.charAt(j)) return false;

        }

        return true;

    }

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

    //merge sort
    public static void mergeSort(int[] arr) {

        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int s1[] = new int[mid];
        int s2[] = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            s1[i] = arr[i];
        }

        for (int j = mid; j < arr.length; j++) {
            s2[j - mid] = arr[j];
        }

        mergeSort(s1);
        mergeSort(s2);

        mergeArr(s1, s2, arr);
    }

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

    //quick sort
    public static void quickSort(int[] input, int i, int j) {
        // your code goes here
        if (i >= j) {
            return;
        }
        int p = partition(input, i, j);
        quickSort(input, i, p - 1);
        quickSort(input, p + 1, j);
    }

    //https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/

    /**
     * sort the array
     * divide it into two parts
     * compare first part with the second part
     * to mark indices as visited just increment the pointer mentioned below
     *
     * @param nums
     * @return
     */
    public int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length / 2;

        int ans = 0;
        while (i < nums.length / 2 && j < nums.length) {
            if (nums[i] * 2 <= nums[j]) {
                ans += 2;
                i++;
                j++;
                continue;
            }
            j++;
        }
        return ans;
    }

    //https://leetcode.com/problems/maximum-product-subarray/
    //    int maxProduct(vector<int>&nums) {
    //        int n = nums.size();
    //        int l = 1, r = 1;
    //        int ans = nums[0];
    //
    //        for (int i = 0; i < n; i++) {
    //            //if any of l or r become 0 then update it to 1
    //            l = l == 0 ? 1 : l;
    //            r = r == 0 ? 1 : r;
    //
    //            l *= nums[i];   //prefix product
    //            r *= nums[n - 1 - i];   //suffix product
    //
    //            ans = max(ans, max(l, r));
    //        }
    //        return ans;
    //}

    //https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

    /**
     * int digit = word.charAt(i) - '0'; this method takes O(1)
     * use this method to convert a string to int
     * dont use Integer.parseInt because it takes O(n) time
     *
     * @param word
     * @param m
     * @return
     */
    public int[] divisibilityArray(String word, int m) {
        // int[] ans = new int[word.length()];
        // long val = 0;
        // for (int i = 0; i < word.length(); i++) {
        //         char c = word.charAt(i);
        //         val = (10 * val + (c - '0')) % m;
        //         if (val == 0) ans[i] = 1;
        //         else ans[i] = 0;
        // }
        // return ans;

        int n = word.length();
        int[] div = new int[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            int digit = word.charAt(i) - '0';
            num = (num * 10 + digit) % m;
            if (num == 0) {
                div[i] = 1;
            }
        }
        int prefix = 0;
        for (int i = 0; i < n - 1; i++) {
            prefix = (prefix * 10 + word.charAt(i) - '0') % m;
            if (prefix == 0) {
                div[i] = 1;
            }
        }
        return div;
    }

    //https://leetcode.com/problems/container-with-most-water/submissions/

    /**
     * how we found width
     * index j minus index i is the width
     * why because it is mentioned in the question
     * that Find two lines that together with the x-axis form a container,
     * such that the container contains the most water.
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                //if your left height is smaller then find larger height from left
                ans = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(ans, max);
                i++;
            } else {
                //if your right height is smaller then find larger height from right
                ans = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(ans, max);
                j--;
            }
        }
        return max;
    }

    /**
     * to make a array palindrome take two pointer i and j
     * if arr[i] == arr[j] move i++ j--
     * if(arr[i] <= arr[j]) merge from left
     * if(arr[j] <= arr[i]) merge from right
     * TODO: learn why this works
     *
     * @param arr
     * @param n
     * @return
     */
    //https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
    static int findMinOps(int[] arr, int n) {
        int ans = 0; // Initialize result

        // Start from two corners
        for (int i = 0, j = n - 1; i <= j; ) {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }

            // If left element is greater, then
            // we merge right two elements
            else if (arr[i] > arr[j]) {
                // need to merge from tail.
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }

            // Else we merge left two elements
            else {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }

    /**
     * We can also compare numbers which are in the form of strings
     * for ex, "10".comparedTo("20")
     * if  i < j = -1
     * if i == j = 0
     * if i > j = 1
     * this concept can be used to solve below problem
     *
     * @param arr
     * @return
     */
    //https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
    String printLargest(String[] arr) {

        StringBuilder ans = new StringBuilder();

        Arrays.sort(arr, new Comparator<String>() {
            // A comparison function which is used by
            // sort() in printLargest()
            @Override
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        for (String s : arr) ans.append(s);

        return ans.toString();
    }


}




