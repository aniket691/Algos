package Collection.dp;

public class Dp {

    //https://leetcode.com/problems/house-robber/description/
    public int rob(int[] nums) {

        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //exclude current house --> dp[i];
            //include current house --> dp[i-1]+ nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];
    }

    //https://leetcode.com/problems/count-different-palindromic-subsequences/
    //code is for All subseq
    //not for Different subseq

    /**
     * The given code aims to count the number of palindromic subsequences in a given string. A palindromic subsequence is a subsequence that reads the same forward and backward. For example, in the string "aab", the palindromic subsequences are "a", "a", and "aa".
     * <p>
     * The algorithm uses dynamic programming to compute the number of palindromic subsequences. The approach used is bottom-up, where the solutions to smaller subproblems are used to compute solutions to larger subproblems. The approach is as follows:
     * <p>
     * 1. Create a 2D array dp with dimensions equal to the length of the input string str.
     * 2. Initialize the diagonal elements of the dp array to 1, since each character in the string is a palindrome of length 1.
     * 3. For each subsequence length g, starting from 2 up to the length of the input string:
     * 1. Loop over all pairs of indices i and j, where i is the starting index and j is the ending index of the subsequence.
     * 2. If the subsequence length g is equal to 2, assign dp[i][j] a value of 2 if the characters at indices i and j are equal, otherwise, assign it a value of 1.
     * 3. If the subsequence length g is greater than 2, compute dp[i][j] using the following recurrence relation:
     * If the first and last characters of the subsequence are equal, then the number of palindromic subsequences is the sum of the number of palindromic subsequences of length g-1 that exclude the last character, the number of palindromic subsequences of length g-1 that exclude the first character, and 1 (which represents the palindromic subsequence consisting of just the first and last characters).
     * If the first and last characters of the subsequence are not equal, then the number of palindromic subsequences is the sum of the number of palindromic subsequences of length g-1 that exclude the last character and the number of palindromic subsequences of length g-1 that exclude the first character, minus the number of palindromic subsequences of length g-2 that exclude both the first and last characters.
     * 4. The final answer is the value in dp[0][str.length()-1], which represents the number of palindromic subsequences of the entire input string.
     * <p>
     * The intuition behind this algorithm is to break down the problem of finding the number of palindromic subsequences of a string into smaller subproblems of finding the number of palindromic subsequences of substrings of the input string. By computing and storing solutions to smaller subproblems, we can use them to efficiently compute the solution to the larger problem.
     *
     * @param str
     * @return
     */
    public int countPalindromicSubsequences(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }
}
