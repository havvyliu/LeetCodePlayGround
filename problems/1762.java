class Solution {
    public int[] findBuildings(int[] heights) {
        int[] max = new int[heights.length];
        int size = heights.length;
        List<Integer> res = new LinkedList();
        int max = heights[size - 1];
        for (int i=size - 2; i >=0; i--) {
          max = Math.max(max, heights[i + 1]);
          if (heights[i] > max) {
            res.add(i);
          }
        }
        Collections.reverse(res);
        res.add(size - 1);
        int[] r = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
          r[i] = res.get(i);
        }
        return r;
    }
}
