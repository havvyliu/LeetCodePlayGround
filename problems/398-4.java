class Solution {
    Map<String, Integer> map = new HashMap();
    public int waysToReachStair(int k) {
      return dfs(false, k, 1, 0);
    }

    private int dfs(boolean down, int k, int cur, int jump) {
      int leap = (int) Math.pow(2, jump);
      int flag = down ? 0 : 1;
      int res = 0;
      String path = cur + "" + jump + "" + flag;
      System.out.println(path);
      if (cur == k) {
        res++;
      }
      if (cur > k + 1) {
        map.put(path, res);
        return res;
      }
      if (down == false && cur > 0) {
        res += dfs(true, k, cur - 1, jump);
      }
      res += dfs(false, k, cur + leap, jump+ 1);
      map.put(path, res);
      return res;
    }
}
