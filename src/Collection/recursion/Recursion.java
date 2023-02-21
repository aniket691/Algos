package Collection.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void towerOfHanoi(int n, char s, char h, char d) {
        if (n == 0) return;
        // Write your code here
        if (n == 1) {
            System.out.println(s + " " + d);
            return;
        }

        towerOfHanoi(n - 1, s, d, h);
        System.out.println(s + " " + d);
        towerOfHanoi(n - 1, h, s, d);

    }

    public static boolean checkSequence(String a, String b) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (b.length() == 0) return true;

        if (a.length() == 0) return false;

        if (a.charAt(0) == b.charAt(0)) {
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            return checkSequence(a.substring(1), b);
        }

    }

    // Function to print all the permutations of str
    static void allStringUsingChars(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            allStringUsingChars(ros, ans + ch);
        }
    }

//    public static void subsetsSumK(int arr[], int k) {
//        int count = 5;
//
//        helper(arr, k, 0, arr.length, new ArrayList<>());
//    }

//    public static void helper(int[] arr, int k, int i, int n, List<Integer> smallAns) {
//
//        if (n == 0) {
//            if (k == 0) System.out.println(smallAns);
//            return;
//        }
//
//        //not include
//        helper(arr, k, i + 1, n - 1, smallAns);
//
//        smallAns.add(arr[i]);
//
//        //include
//        helper(arr, k - arr[i], i + 1, n - 1, smallAns);
//
//    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        seq(nums, ans, 0, main);
        return main;
    }

    static void seq(int[] nums, ArrayList<Integer> ans, int i, List<List<Integer>> main) {
        if (i == nums.length) {
            main.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
        seq(nums, ans, i + 1, main);
        ans.remove(ans.size()-1);
        seq(nums, ans, i + 1, main);
    }


}
