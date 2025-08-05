/*
 * Q.Given the head of a doubly linked list and an integer k, delete the kth node of the linked list and return the head of the modified list.
 * * Note: The nodes in the doubly linked list have a 'prev' pointer to the previous node and a 'next' pointer to the next node.
 * 
 */


 class Solution {
    public ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }
}