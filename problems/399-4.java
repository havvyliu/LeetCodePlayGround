class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
      int res = 0;
      for (int[] q : queries) {
        nums[q[0]] = q[1];
        res += find(nums);
        res %= (1000000000 + 7);
      }
      return res;
    }


    private int find(int[] arr) {
      if (arr.length == 1) return Math.max(arr[0], 0);
      int[] dp = new int[arr.length + 1];
      dp[0] = Math.max(arr[0], 0);
      dp[1] = Math.max(arr[1], dp[0]);
      for (int i=2; i<arr.length; i++) {
        dp[i] = Math.max(dp[i- 2] + arr[i], dp[i - 1]);
        dp[i] = Math.max(0, dp[i]);
      }
      return dp[arr.length - 1];
    }
}
