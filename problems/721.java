class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      parent = new int[accounts.size()];
      Map<String, Integer> map = new HashMap<>();
      for (int i=0; i<accounts.size(); i++) {
        parent[i] = i;
      }
      int j=0;
      for (List<String> a : accounts) {
        String name = a.get(0);
        for (int i=1; i<a.size(); i++) {
          if (!map.containsKey(a.get(i))) {
            map.put(a.get(i), j);
          } else {
            int exist = map.get(a.get(i));
            union(exist, j);
          }
        }
        j++;
      }
      Map<Integer, Set<String>> ret = new HashMap<>();
      for (int i=0; i<accounts.size(); i++) {
        int parent = find(i);
        ret.putIfAbsent(parent, new HashSet<>());
        ret.get(parent).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
      }
      List<List<String>> list = new ArrayList<>();
      for (int key : ret.keySet()){
        List<String> tmp = new ArrayList<>();
        tmp.addAll(ret.get(key));
        Collections.sort(tmp);
        tmp.add(0, accounts.get(key).get(0));
        list.add(tmp);
      }
      return list;
    }

    public void union(int x, int y) {
      int rx = find(x);
      int ry = find(y);
      parent[rx] = ry;
    }


    public int find(int x) {
      if (parent[x] == x) return x;
      return parent[x] = find(parent[x]);
    }
}
