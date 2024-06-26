class Solution {
    public String compressedString(String word) {
      char s = word.charAt(0);
      int count = 1;
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<word.length(); i++) {
        char c = word.charAt(i);
        if (s != c) {
          int nines = count / 9;
          for (int j=0; j<nines; j++) {
            sb.append("9");
            sb.append(s);
          }
          int remain = count % 9;
          if (remain != 0) {
            sb.append(remain);
            sb.append(s);
          }
          s = c;
          count = 1;
        } else {
          count++;
        }
      }
      int nines = count / 9;
      for (int j=0; j<nines; j++) {
        sb.append("9");
        sb.append(s);
      }
      int remain = count % 9;
      if (remain != 0) {
        sb.append(remain);
        sb.append(s);
      }
      return sb.toString();
    }
}
