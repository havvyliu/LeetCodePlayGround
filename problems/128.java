class Solution {
    public int longestConsecutive(int[] nums) {
      UF uf = new UF(nums.length);
      Map<Integer, Integer> map = new HashMap<>();
      for (int i=0; i<nums.length; i++) {
        int val = nums[i];
        if (map.containsKey(val)) {
          continue;
        }
        if (map.containsKey(val - 1)) {
          uf.union(map.get(val - 1), i);
        }
        if (map.containsKey(val + 1)) {
          uf.union(map.get(val + 1), i);
        }
        map.put(val, i);
      }
      return uf.findMax();
    }

    private class UF {
      int[] parent;
      int[] size;

      public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
          parent[i] = i;
          size[i] = 1;
        }
      }

      public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
      }

      public void union(int x, int y) {
        int rX = find(x);
        int rY = find(y);
        if (rX != rY) {
          parent[rX] = rY;
          size[rY] += size[rX];
        }
      }

      public int findMax() {
        int max = 0;
        for (int s : size) {
          max = Math.max(s, max);
        }
        return max;
      }
    }
}
