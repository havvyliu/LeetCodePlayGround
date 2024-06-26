class Solution {
    public int minimumDifference(int[] arr, int k) {
      int n = arr.length;
      SegmentTree st = new SegmentTree(arr);
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          ans = Math.min(ans, (int) Math.abs(k - st.query(i, j)));
        }
      }
      return ans;
    }
}


class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr)
    {
      n = arr.length;
      tree = new int[4 * n];
      build(arr, 0, 0, n - 1);
    }

    public void build(int[] arr, int node, int start, int end)
    {
      if (start == end) {
        tree[node] = arr[start];
      }
      else {
        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
      }
    }

    public int query(int l, int r) {
      return query(0, 0, n - 1, l, r);
    }

    public int query(int node, int start, int end, int l, int r) {
      if (r < start || end < l) {
        return Integer.MAX_VALUE;
      }
      if (l <= start && end <= r) {
        return tree[node];
      }
      int mid = (start + end) / 2;
      int p1 = query(2 * node + 1, start, mid, l, r);
      int p2 = query(2 * node + 2, mid + 1, end, l, r);
      return p1 & p2;
    }
}
