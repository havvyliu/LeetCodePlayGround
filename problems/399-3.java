class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
      TreeMap<Integer, Integer> m1 = new TreeMap<>();
      TreeMap<Integer, Integer> m2 = new TreeMap<>();
      Map<Integer, Integer> cache = new HashMap<>();
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      for (int n : nums1) {
        m1.putIfAbsent(n, 0);
        m1.put(n, m1.get(n) + 1);
      }
      long res = 0;
      for (int n : nums2) {
        int i = 1;
        int next = i * k * n;
        while (m1.containsKey(next) || m1.higherKey(next) != null) {
          if (m1.containsKey(next)) {
            res += m1.get(next);
          }
          Integer higherKey = m1.higherKey(next);
          if (higherKey != null) {
            i = Math.max(i + 1, higherKey / (k * n));
            next = i * k * n;
          } else {
            break;
          }
        }
      }
      return res;
    }
}
