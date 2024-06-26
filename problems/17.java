class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList<>();
      if (digits.length() == 0) return res;
      dfs(0, digits, res, "");
      return res;
    }

    private void dfs(int index, String digits, List<String> res, String cur) {
      if (index == digits.length()) {
        res.add(cur);
        return;
      }
      int digit = digits.charAt(index) - '0';
      char[] arr;
      if (digit == 7){
        arr = new char[4];
        for (int i=0; i<4; i++) {
          arr[i] = (char)('p' + i);
        }
      } else if (digit == 9) {
        arr = new char[4];
        for (int i=0; i<4; i++) {
          arr[i] = (char)('w' + i);
        }
      } else if (digit == 8) {
        arr = new char[3];
        for (int i=0; i<3; i++) {
          arr[i] = (char)('t' + i);
        }
      } else {
        arr = new char[3];
        for (int i=0; i<3; i++) {
          arr[i] = (char)('a' + i + (digit - 2) * 3);
        }
      }
      for (char c : arr) {
        dfs(index + 1, digits, res, cur + c);
      }
    }
}
