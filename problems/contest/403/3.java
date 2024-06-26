class Solution {
    public long maximumTotalCost(int[] nums) {
      int n = nums.length;
      long[] dp =  new long[n + 1];
      if (n == 1) return nums[0];
      dp[0] = nums[0];
      dp[1] = Math.max(dp[0] + nums[1], dp[0] - nums[1]);
      for (int i=2; i<n; i++) {
        dp[i] = Math.max(dp[i - 2] + nums[i - 1] - nums[i], dp[i - 1] + nums[i]);
      }
      dp[n] = Math.max(dp[n - 2] + nums[n - 1], dp[n - 1]);
      return dp[n];
    }
}
