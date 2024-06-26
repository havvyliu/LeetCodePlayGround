class Solution {
    public int countDays(int days, int[][] meetings) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      for (int[] arr : meetings) {
        pq.add(arr);
      }
      int res = 0;
      int start = 1;
      while (!pq.isEmpty()) {
        int[] next = pq.poll();
        res += (next[0] - start);
        start = next[1] + 1;
        while (!pq.isEmpty() && pq.peek()[0] <= start) {
          start = Math.max(start, pq.peek()[1] + 1);
          pq.poll();
        }

      }
      res += Math.max(days - start + 1, 0);
      return res;
    }
}
