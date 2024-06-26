class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
      int res = 0;
      for (int n : nums1) {
        for (int m : nums2) {
          if (n % (m * k) == 0) res++;
        }
      }
      return res;
    }
}
