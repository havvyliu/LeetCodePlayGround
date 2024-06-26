class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList();
        q.add(1);
        visited[0] = true;
        int step = 0;
        while (!q.isEmpty()) {
          int size = q.size();
          for (int j=0; j<size; j++) {
              int cur = q.poll();
              if (visited[cur]) continue;
              visited[cur] = true;
              if (cur == n * n) return step;
              for (int i=cur + 1; i<=Math.min(cur + 6, n * n); i++) {
                  boolean even =  ((i - 1) / n ) % 2 == 0; 
                  int x = (n - 1) - (i - 1) / n;
                  int y = !even ? (n - 1) - ((i - 1) % n) : (i - 1) % n;
                  int val = board[x][y];
                  if (val == -1) {
                    q.add(i);
                  } else {
                    q.add(val);
                  }
              }
          }
          step++;
        }
        return -1;
    }
}

