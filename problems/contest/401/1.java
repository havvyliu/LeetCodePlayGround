class Solution {
    public int numberOfChild(int n, int k) {
      k = k % (2 * n - 2);
      if (n > k) {
        return k;
      } else {
        return (2 * n - 2) - k;
      }
    }
}
