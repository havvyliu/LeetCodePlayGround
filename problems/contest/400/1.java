class Solution {
    public int minimumChairs(String s) {
      int e = 0;
      int res = 0;
      for (char c : s.toCharArray()) {
        if (c == 'E') {
          e++;
          res = Math.max(res, e);
        } else {
          e--;
        }
      }
      return res;
    }
}
