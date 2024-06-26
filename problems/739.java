class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<int[]> s = new Stack();
        s.push(new int[]{temperatures[size - 1], size - 1});
        for (int i = size - 2; i >= 0; i--) {
          int cur = temperatures[i];
          while (!s.isEmpty() && s.peek()[0] <= cur) {
            s.pop();
          }
          if (!s.isEmpty()) {
            res[i] = s.peek()[1] - i;
          }
          s.push(new int[]{cur, i});
        }
        return res;
    }
}
