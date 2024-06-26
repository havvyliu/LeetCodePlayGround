class Solution {
    public long sumDigitDifferences(int[] nums) {
      int[] arr = new int[10];
      Queue<Integer> q = new LinkedList<>();
      int digits = 0;
      int num = nums[0];
      while (num != 0) {
        num /= 10;
        digits++;
      }
      long res = 0;
      for (int i=0; i<digits; i++) {
        arr = new int[10];
        for (int j=0; j<nums.length; j++) {
          int n = nums[j];
          int cur = n % 10;
          arr[cur]++;
          nums[j] = n / 10;
        }
        int sum = 0;
        for (int j=0; j<10; j++) {
          if (arr[j] != 0) {
            q.add(arr[j]);
            sum += arr[j];
          }
        }
        while (!q.isEmpty()) {
          int next = q.poll();
          sum -= next;
          res += (sum) * next;
        }
      }
      return res;
    }
}
