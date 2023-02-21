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
}
