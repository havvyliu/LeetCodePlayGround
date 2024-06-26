class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      int l = 1;
      int r = (int) 1e9;
      int n = bloomDay.length;
      if ((long) m * k > (long) n) return -1;
      while (l < r) {
        int mid = (r - l) / 2 + l;
        int bouq = 0;
        int cur = 0;
        for (int i=0; i<n; i++) {
          if (bloomDay[i] <= mid) {
            cur++;
          } else {
            bouq += cur / k;
            cur = 0;
          }
        }
        bouq += cur / k;
        if (bouq < m) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      return r;
    }
}
