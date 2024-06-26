/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
      List<Integer> list = new LinkedList<>();
      populate(root, list);
      return list.get(k - 1);
    }

    private void populate(TreeNode root, List<Integer> list) {
      if (root.left != null) {
        populate(root.left, list);
      }
      list.add(root.val);
      if (root.right != null) {
        populate(root.right, list);
      }
    }
}
