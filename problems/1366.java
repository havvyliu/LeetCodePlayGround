class Solution {
    public String rankTeams(String[] votes) {
      Map<Character, int[]> map = new HashMap<>();
      int size = votes[0].length();
      for (String vote : votes) {
        for (int i=0; i<vote.length(); i++) {
          char c = vote.charAt(i);
          map.putIfAbsent(c, new int[size]);
          map.get(c)[i]++;
        }
      }
      PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
        for (int i=0; i<size; i++) {
          if (map.get(a)[i] == map.get(b)[i]) continue;
          return map.get(b)[i] - map.get(a)[i];
        }
        return (char) a - (char) b;
      });
      for (char c : votes[0].toCharArray()) {
        pq.add(c);
      }
      StringBuilder sb = new StringBuilder();
      while (!pq.isEmpty()) {
        sb.append(pq.poll());
      }
      return sb.toString();
    }
}
