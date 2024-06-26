class Solution {
    public String clearStars(String s) {
      Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
      for (int i=0; i<26; i++) {
        char c = (char) (i + 'a');
        map.put(c, new PriorityQueue<>((a, b) -> b - a));
      }
      Set<Integer> set = new HashSet<>();
      for (int i=0; i< s.length(); i++) {
        char c = s.charAt(i);
        if (c == '*') {
          remove(map, i, set);
        } else {
          map.get(c).add(i);
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<s.length(); i++) {
        if (set.contains(i) || s.charAt(i) == '*') continue;
        sb.append(s.charAt(i));
      }
      return sb.toString();
    }


    private void remove(Map<Character, PriorityQueue<Integer>> map, int i, Set<Integer> set) {
      for (int j=0; j<26; j++) {
        char c = (char) (j + 'a');
        if (!map.get(c).isEmpty()) {
          set.add(map.get(c).poll());
          return;
        }
      }
    }
}
