class Solution {
    int max = 0;
    Map<String, Integer> memo = new HashMap<>();
    public int maxTotalReward(int[] rewardValues) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      Arrays.sort(rewardValues);
      int n = rewardValues.length;
      int[] temp = new int[rewardValues.length];
      for (int i=0; i<n; i++) {
        temp[i] = rewardValues[n - 1 - i];
      }
      for (int r : rewardValues) {
        map.put(r, 1);
      }
      dfs(map, 0, rewardValues);
      return max;
    }

    private String formKey(TreeMap<Integer, Integer> map, int cur) {
      StringBuilder sb = new StringBuilder();
      for (int key : map.keySet()) {
        sb.append(String.valueOf(key));
        sb.append('-');
      }
      sb.append(cur);
      return sb.toString();
    }


    private int dfs(TreeMap<Integer, Integer> map, int cur, int[] rewards) {
      max = Math.max(max, cur);
      String str = formKey(map, cur);
      if (memo.containsKey(str)) return memo.get(str);
      if (map.higherKey(cur) == null) {
        return max;
      }
      Set<Integer> temp = new HashSet<>();
      int local = cur;
      while (map.higherKey(cur) != null) {
        int key = map.higherKey(cur);
        temp.add(key);
        map.remove(key);
        local = Math.max(local, dfs(map, cur + key, rewards));
      }
      for (int key : temp) {
        map.put(key, 1);
      }
      memo.put(str, local);
      return local;
    }
}
