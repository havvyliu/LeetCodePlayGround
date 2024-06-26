class Solution {
    public int leastInterval(char[] tasks, int n) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : tasks) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
      for (char c : map.keySet()) {
        pq.add(new int[]{c - 'a', map.get(c)});
      }
      int max = pq.poll()[1];
      if (max == 1) return tasks.length;
      int gaps = (max - 1) * n;
      int filled = 0;
      while (pq.size() != 0) {
        filled += Math.min(pq.poll()[1], max -1);
      }
      int actualGaps = Math.max(0, gaps - filled);
      return tasks.length + actualGaps;
    }
}
