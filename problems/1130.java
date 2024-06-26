class Solution {
    public int mctFromLeafValues(int[] arr) {
      int[][] memo = new int[arr.length][arr.length];
      return dfs(0, arr.length - 1, arr, memo);
    }

    private int dfs(int l, int r, int[] arr, int[][] memo) {
      if (l == r) return 0;
      if (memo[l][r] != 0) return memo[l][r];
      int ans = Integer.MAX_VALUE;
      for (int i=l; i<r; i++) {
        int left = dfs(l, i, arr, memo);
        int right = dfs(i+1, r, arr, memo);
        int maxLeft = 0;
        int maxRight = 0;
        for (int j=l; j<=i; j++) maxLeft = Math.max(maxLeft, arr[j]);
        for (int j=i+1; j<=r; j++) maxRight = Math.max(maxRight, arr[j]);
        ans = Math.min(ans, left + right + maxLeft * maxRight);
      }
      memo[l][r] = ans;
      return ans;
    }
}
