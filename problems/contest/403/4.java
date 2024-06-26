class Solution {
    public int minimumSum(int[][] grid) {
      int ans = (int) 1e5;
      int x = grid.length;
      int y = grid[0].length;
      int one, two, three;
      for (int i=0; i<x -1; i++) {
        one = minimumArea(grid, 0, i, 0, y - 1);
        for (int j=0; j<y-1; j++) {
          two = minimumArea(grid, i + 1, x - 1, 0, j);
          three = minimumArea(grid, i + 1, x - 1, j + 1, y -1);
          ans = Math.min(ans, one + two + three);
        }
      }
      for (int j=0; j<y-1; j++) {
        one = minimumArea(grid, 0, x - 1, 0, j);
        for (int i=0; i<x-1; i++) {
          two = minimumArea(grid, 0, i, j + 1, y - 1);
          three = minimumArea(grid, i + 1, x - 1, j + 1, y - 1);
          ans = Math.min(ans, one + two + three);
        }
      }
      for (int j=y-1; j>0; j--) {
        one = minimumArea(grid, 0, x - 1, j, y - 1);
        for (int i=0; i<x-1; i++) {
          two = minimumArea(grid, 0, i, 0, j - 1);
          three = minimumArea(grid, i + 1, x - 1, 0, j - 1);
          ans = Math.min(ans, one + two + three);
        }
      }
      for (int i=x-1; i>0; i--) {
        one = minimumArea(grid, i, x - 1, 0, y - 1);
        for (int j=0; j<y-1; j++) {
          two = minimumArea(grid, 0, i - 1, 0, j);
          three = minimumArea(grid, 0, i - 1, j + 1, y -1);
          ans = Math.min(ans, one + two + three);
        }
      }
      for (int i=0; i<x - 1; i++) {
        one = minimumArea(grid, 0, i, 0, y - 1);
        for (int ii=i + 1; ii<x; ii++) {
          two = minimumArea(grid, i + 1, ii, 0, y - 1);
          three = minimumArea(grid, ii + 1, x - 1, 0, y - 1);
          ans = Math.min(ans, one + two + three);
        }
      }
      for (int j=0; j<y - 1; j++) {
        one = minimumArea(grid, 0, x - 1, 0, j);
        for (int jj= j + 1; jj < y; jj++) {
          two = minimumArea(grid, 0, x -1, j + 1, jj);
          three = minimumArea(grid, 0, x - 1, jj + 1, y - 1);
          ans = Math.min(ans, one + two + three);
        }
      }

      return ans;
    }

    public int minimumArea(int[][] grid, int startI, int endI, int startJ, int endJ) {
      int leftTop = 30;
      int leftBot = 0;
      int rightTop = 30;
      int rightBot = 0;
      boolean found = false;
      for (int i=startI; i<=endI; i++) {
        for (int j=startJ; j<=endJ; j++) {
          if (grid[i][j] == 1) {
            found = true;
            leftTop = Math.min(leftTop, j);
            leftBot = Math.max(leftBot, j);
            rightTop = Math.min(rightTop, i);
            rightBot = Math.max(rightBot, i);
          }
        }
      }


      return found ? (leftBot - leftTop + 1) * (rightBot - rightTop  + 1) : 0;
    }
}
