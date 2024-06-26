class Solution {
    public double minimumAverage(int[] nums) {
      double res = 50.;
      Arrays.sort(nums);
      int i=0;
      int j=nums.length -1;
      for (; i<j && i< nums.length / 2; i++) {
        double cur = ((double) (nums[i] + nums[j])) / 2.0;
        if (cur < res) {
          res = cur;
        }
        j--;
      }
      return res;
    }
}
