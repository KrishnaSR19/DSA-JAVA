/*
 * Q.Given the head of a singly linked list and an integer k, delete the kth node of the linked list and return the head of the modified list.
 * 
 */

 class Solution {
  public ListNode deleteKthNode(ListNode head, int k) {
    // Edge case: delete head
    if (k == 1) {
      return head.next;
    }

    ListNode current = head;
    int count = 1;

    // Move to (k-1)th node
    while (current != null && count < k - 1) {
      current = current.next;
      count++;
    }

    // If kth node exists, remove it
    if (current != null && current.next != null) {
      current.next = current.next.next;
    }

    return head;
  }
}
