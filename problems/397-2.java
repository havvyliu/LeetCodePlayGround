class Solution {
    public int maximumEnergy(int[] e, int k) {
      int max = Integer.MIN_VALUE;
      for (int i=0; i<k; i++) {
        int local = 0;
        for (int j=e.length - 1 - i; j >=0; j -= k) {
          if (j == e.length - 1 - i) {
            local = e[j];
          } else {
            local += e[j];
          }
          max = Math.max(local, max);
        }
      }
      return max;
    }
}
