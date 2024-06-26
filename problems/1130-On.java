class Solution {
    public int mctFromLeafValues(int[] arr) {
      Stack<Integer> stack = new Stack<>();
      int cost = 0;
      stack.push(Integer.MAX_VALUE);
      for (int a : arr) {
        while (stack.peek() <= a) {
          int next = stack.pop();
          cost += next * Math.min(stack.peek(), a);
        }
        stack.push(a);
      }
      while (stack.size()>2) {
        cost += stack.pop() * stack.peek();
      }
      return cost;
    }
}
