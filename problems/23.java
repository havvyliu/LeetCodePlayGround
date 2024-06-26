/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(0, lists.length-1, lists);
    }
    
    public ListNode mergeSort(int l, int r, ListNode[] lists) {
      if (l > r) return null;
      int mid = (l + r) / 2;
      if (l == r) return lists[l];
      ListNode left = mergeSort(l, mid, lists);
      ListNode right = mergeSort(mid + 1, r, lists);
      return mergeTwoList(left, right);
    }

    public ListNode mergeTwoList(ListNode left, ListNode right) {
      ListNode front = new ListNode();
      ListNode tmp = front;
      while (left != null && right != null) {
        if (left.val <= right.val) {
          tmp.next = new ListNode(left.val);
          left = left.next;
        } else {
          tmp.next = new ListNode(right.val);
          right = right.next;
        }
        tmp = tmp.next;
      }
      while (left != null) {
        tmp.next = new ListNode(left.val);
        left = left.next;
        tmp = tmp.next;
      }
      while (right != null) {
        tmp.next = new ListNode(right.val);
        right = right.next;
        tmp = tmp.next;
      }
      return front.next;
    }
}

