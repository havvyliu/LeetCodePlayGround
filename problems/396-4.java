class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int max = 0;
        for (int n : nums) {
          max = Math.max(n, max);
        }
        List<Integer> list = new ArrayList();
        for (int n : nums) {
          if (n != max) {
            list.add(max - n);
          }
        }
        if (cost1 * 2 <= cost2) {
          return list.stream().mapToInt(Integer::intValue).sum() * cost1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
        pq.addAll(list);
        int cost = 0;
        int cur = pq.poll();
        while (!pq.isEmpty()) {
          int next = pq.poll();
          if (cur >= next) {
            cost += next * cost2;
            cur -= next;
          } else {
            cost += cur * cost2;
            cur = next - cur;
          }
        }
        if (cur == 0) return cost;
        cur = max - cur;
        System.out.println(cur);
        int x = fn(max, nums.length - 1, cur);
        System.out.println(x);
        cost += (x - cur) * cost2;
        return cost;
    }

    public int fn(int max, int n, int cur) {
      return (n * max - cur) / (n - 1);
    }
}
