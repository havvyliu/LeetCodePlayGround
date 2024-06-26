class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long time = 0;
        for (int i=0; i<tasks.length; i++) {
          if (!map.containsKey(tasks[i])) {
            map.put(tasks[i], time);
          } else {
            long prev = map.get(tasks[i]);
            time += Math.max(0,space - (time - prev - 1));
            map.put(tasks[i], time);
          }
          time++;
        }
        return time;
    }
}
