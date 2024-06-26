class Solution {
    int min = Integer.MAX_VALUE;
    public int minAnagramLength(String s) {

      for (int i=1; i<=(s.length() / 2); i++) {
        dfs(s.substring(0, i), s, 0);
        if (min != Integer.MAX_VALUE) return min;
      }
      return s.length();
    }

    public void dfs(String cur, String s, int index) {
      if (s.length() % cur.length() != 0) return;
      if (s.length() == index) {
        min = cur.length();
        return;
      }
      if (same(cur, s.substring(index, index + cur.length()))) {
        dfs(cur, s, index + cur.length());
      }
    }
    
    public boolean same(String a, String b) {
      String sortedA = sort(a);
      String sortedB = sort(b);
      return sortedA.equals(sortedB);
    }

    public String sort(String a) {
      char[] ar = a.toCharArray();
      Arrays.sort(ar);
      return String.valueOf(ar);
    }
}
