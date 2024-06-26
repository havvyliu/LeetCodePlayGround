class Solution {
    public int findPermutationDifference(String s, String t) {
        int res = 0;
        for (int i=0; i<s.length(); i++) {
          res += (int) Math.abs(i - t.indexOf(s.charAt(i)));
        }
        return res;
    }
}
