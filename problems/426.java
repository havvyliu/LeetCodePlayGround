/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
      if (root == null) return null;
      Node leftHead = treeToDoublyList(root.left);
      Node rightHead = treeToDoublyList(root.right);
      root.left = root;
      root.right = root;
      return connect(leftHead, connect(root, rightHead));
    }


    public Node connect(Node n1, Node n2) {
      if (n1 == null) return n2;
      if (n2 == null) return n1;
      Node tail1 = n1.left;
      Node tail2 = n2.left;
      tail1.right = n2;
      n1.left = tail2;
      tail2.right = n1;
      n2.left = tail1;
      return n1;
    }
}
