class Solution {
  public long subArrayRanges(int[] nums) {
    Stack<int[]> min = new Stack<>();
    min.add(new int[]{0, -1});
    min.add(new int[]{nums[0], 0});
    long res = 0;
    for (int i=1; i<=nums.length; i++) {
      int next = i == nums.length ? Integer.MIN_VALUE : nums[i];
      while (min.peek()[1] != -1 && next < min.peek()[0]) {
        int[] cur = min.pop();
        int contribution = cur[0];
        int mid = cur[1];
        int left = mid - min.peek()[1];
        int right = i - mid;
        res -= ((long) left * right * contribution);
      }
      min.add(new int[]{next, i});
    }

    Stack<int[]> max = new Stack<>();
    max.add(new int[]{0, -1});
    max.add(new int[]{nums[0], 0});
    long maxSum = 0;
    for (int i=1; i<=nums.length; i++) {
      int next = i == nums.length ? Integer.MAX_VALUE : nums[i];
      while (max.peek()[1] != -1 && next > max.peek()[0]) {
        int[] cur = max.pop();
        int contribution = cur[0];
        int mid = cur[1];
        int left = mid - max.peek()[1];
        int right = i - mid;
        res += ((long) left * right * contribution);
      }
      max.add(new int[]{next, i});
    }

    return res;
  }
}
