class Solution {
    public boolean isArraySpecial(int[] nums) {
      boolean b = nums[0] % 2 == 0;
      for (int i=1; i<nums.length; i++) {
        if (b == (nums[i] % 2 == 0)) return false;
        b = !b;
      }
      return true;
    }
}
