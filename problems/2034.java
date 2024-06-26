class StockPrice {
  PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);
  PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[1] - a[1]);
  Map<Integer, Integer> map = new HashMap<>();
  int[] cur = new int[2];
  public StockPrice() {

  }
  
  public void update(int timestamp, int price) {
    map.put(timestamp, price);
    min.add(new int[]{timestamp, price});
    max.add(new int[]{timestamp, price});
    if (timestamp >= cur[0]) {
      cur[0] = timestamp;
      cur[1] = price;
    }
  }
  
  public int current() {
    return cur[1]; 
  }
  
  public int maximum() {
    int[] next = max.peek();
    while (map.get(next[0]) != next[1]) {
      max.poll();
      next = max.peek();
    }
    return next[1];
  }
  
  public int minimum() {
    int[] next = min.peek();
    while (map.get(next[0]) != next[1]) {
      min.poll();
      next = min.peek();
    }
    return next[1];
  }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
