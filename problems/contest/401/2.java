class Solution {
    public int valueAfterKSeconds(int n, int k) {
      int res = 0;
      int mod = 1000000007;
      int[] arr = new int[n];
      for (int i=0; i<n; i++) {
        arr[i] = 1;
      }
      for (int i=0; i<k; i++) {
        for (int j=1; j<n; j++) {
          arr[j] = arr[j] + arr[j - 1];
          arr[j] %= mod;
        }
      }

      return arr[n-1];
    }
}
