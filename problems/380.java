class RandomizedSet {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();
    
    public RandomizedSet() {
    }
    
    public boolean insert(int val) {
      if (map.containsKey(val)) return false;
      list.add(val);
      map.put(val, list.size() - 1);
      return true;
    }
    
    public boolean remove(int val) {
      if (!map.containsKey(val)) return false;
      int index = map.get(val);
      if (index == list.size() - 1) list.remove(index);
      else {
        int lastElement = list.get(list.size() - 1);
        list.set(map.get(val), lastElement);
        list.remove(list.size() - 1);
        map.put(lastElement, index);
      }
      map.remove(val);
      return true;
    }
    
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
