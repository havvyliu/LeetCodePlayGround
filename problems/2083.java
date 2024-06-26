class Solution {
    public long numberOfSubstrings(String s) {
      long ct = 0;
      long[] prefixSum = new long[26];
      for (char c : s.toCharArray()) {
        int i = (int) (c - 'a');
        prefixSum[i]++;
        ct += prefixSum[i];
      }
      return ct;
    }
}
