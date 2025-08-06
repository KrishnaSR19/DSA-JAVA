/*
 * Q.Given the head of a doubly linked list and an integer X, insert a node with value X before the head of the linked list and return the head of the modified list.
 */

class Solution {
    public ListNode insertBeforeHead(ListNode head, int X) {
        // Create new node which will be the new head
        ListNode newHead = new ListNode(X, head, null);

        // Point the current head back to new one
        head.prev = newHead;

        return newHead; // Return new head
    }
}