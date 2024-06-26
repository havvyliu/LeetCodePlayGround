class Solution {

  public int minTransfers(int[][] transactions) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] t : transactions) {
      map.putIfAbsent(t[0], 0);
      map.putIfAbsent(t[1], 0);
      map.put(t[0], map.get(t[0]) - t[2]);
      map.put(t[1], map.get(t[1]) + t[2]);
    }
    List<Integer> accounts = new ArrayList<>(map.keySet());
    return dfs(0, map, accounts);
  }

  private int dfs(int start, Map<Integer, Integer> map, List<Integer> accounts) {
    int res = Integer.MAX_VALUE;
    if (start == accounts.size()) return 0;
    int index = accounts.get(start);
    int cur = map.get(index);
    if (cur == 0) return dfs(start + 1, map, accounts);
    for (int i=start + 1; i<map.size(); i++) {
      int j = accounts.get(i);
      if (cur * map.get(j) < 0) {
        map.put(j, map.get(j) + cur);
        res = Math.min(res, 1 + dfs(start + 1, map, accounts));
        map.put(j, map.get(j) - cur);
      }
    }
    return res;
  }
}
