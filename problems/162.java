class Solution {
    public int findPeakElement(int[] nums) {
      if (nums.length == 1) return 0;
      if (nums[0] > nums[1]) return 0;
      if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
      int l = 1;
      int r = nums.length - 2;
      while (l <= r) {
        int m = (l + r) / 2;
        int val = nums[m];
        int left = nums[m - 1];
        int right = nums[m + 1];
        if (val > left && val > right) {
          return m;
        } else if (left >= val) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      return -1;
    }

}
