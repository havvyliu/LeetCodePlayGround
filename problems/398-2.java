class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
      int n = nums.length;
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int i=0; i<n-1; i++) {
        boolean first = nums[i] % 2 == 0;
        boolean second = nums[i+1] % 2 == 0;
        if (first == second) map.put(i, 0);
      } 
      boolean[] ans = new boolean[queries.length];
      for (int i=0; i<queries.length; i++) {
        int[] arr = queries[i];
        if (arr[0] == arr[1]) ans[i] = true;
        else {
          if (map.containsKey(arr[0])) {
            ans[i] = false;
            continue;
          }
          Integer higherKey = map.higherKey(arr[0]);
          if (higherKey == null || higherKey >= arr[1]) ans[i] = true;
          else ans[i] = false;
        }
      }
      return ans;
    }

}

