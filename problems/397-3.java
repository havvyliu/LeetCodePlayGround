class Solution {
    int res = Integer.MIN_VALUE;
    int[][] memo;
    boolean[][] visited;
    public int maxScore(List<List<Integer>> grid) {
      memo = new int[grid.size()][grid.get(0).size()];
      visited = new boolean[grid.size()][grid.get(0).size()];
      int local = 0;
      int x = 0;
      int y = 0;
      for (int i=0; i<grid.size(); i++) {
        for (int j=0; j<grid.get(0).size(); j++) {
          int val = grid.get(i).get(j);
          if (val >= local) {
            x = i;
            y = j;
            local = val;
          }
        }
      }
      dfs(x, y, grid, 0, 0);
      return res;
    }

    private void dfs(int i, int j, List<List<Integer>> grid, int step, int cur) {
      if (step >= 1) {
        res = Math.max(res, cur);
      }
      int ans = Integer.MIN_VALUE;
      for (int x=i; x>=0; x--) {
        for (int y=j; y>=0; y--) {
          if (x == i && y == j) continue;
          int c1 = grid.get(i).get(j);
          int c2 = grid.get(x).get(y);
          step++;
          dfs(x, y, grid, step, cur + c1 - c2);
          step--;
        }
      }
    }
}
