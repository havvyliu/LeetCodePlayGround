class MyCalendar {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
      if (map.containsKey(start)) return false;
      Integer lowerKey = map.lowerKey(end);
      if (lowerKey == null) {
        map.put(start, end);
        return true;
      } else {
        int prev = map.get(lowerKey);
        if (prev <= start) {
          map.put(start, end);
          return true;
        }
        return false;
      }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
