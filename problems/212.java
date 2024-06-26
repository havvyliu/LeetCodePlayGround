class Solution {
    public int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    class Trie {
        String word;
        Map<Character, Trie> map = new HashMap();
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            Trie tmp = root;
            for (char c : w.toCharArray()) {
                tmp.map.putIfAbsent(c, new Trie());
                tmp = tmp.map.get(c);
            }
            tmp.word = w;
        }
        List<String> ret = new ArrayList();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
          for (int j=0; j<board[0].length; j++) {
            visited[i][j] = true;
            dfs(i, j, board, root, ret, visited);
            visited[i][j] = false;
          }
        }
        return ret;
    }

    public void dfs(int x, int y, char[][] board, Trie t, List<String> list, boolean[][] visited) {
      char c = board[x][y];
      if (t.map.containsKey(c)) {
        Trie next = t.map.get(c);
        if (next.word != null && !list.contains(next.word)) list.add(next.word);
        for (int[] dir : dirs) {
          int xx = x + dir[0];
          int yy = y + dir[1];
          if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && !visited[xx][yy]){
            visited[xx][yy] = true;
            dfs(xx, yy, board, next, list, visited);
            visited[xx][yy] = false;
          }
        }
      }
    }
}
