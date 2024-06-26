class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap();
        int max = 0;
        for (int i=0; i<word.length(); i += k) {
          String str = word.substring(i, i+k);
          map.put(str, map.getOrDefault(str, 0) + 1);
          if (max < map.get(str)) {
            max = map.get(str);
          }
        }
        return word.length() / k - max;
    }
}
