class Solution {
    public int minimumArea(int[][] grid) {
      int leftTop = 1000;
      int leftBot = 0;
      int rightTop = 1000;
      int rightBot = 0;
      for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[0].length; j++) {
          if (grid[i][j] == 1) {
            leftTop = Math.min(leftTop, j);
            leftBot = Math.max(leftBot, j);
            rightTop = Math.min(rightTop, i);
            rightBot = Math.max(rightBot, i);
          }
        }
      }
      int x = grid.length;
      int y = grid[0].length;
      return (leftBot - leftTop + 1) * (rightBot - rightTop  + 1);
    }
}
