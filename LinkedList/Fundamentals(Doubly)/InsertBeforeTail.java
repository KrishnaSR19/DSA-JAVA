/*
 * Q. Given the head of a doubly linked list and an integer X, insert a node with value X before the tail of the linked list and return the head of the modified list.
 * This implementation assumes that the linked list is not empty and that the tail node is not null.
 * The new node will be inserted before the current tail, and the tail will be updated accordingly.
 * The new node will become the new tail of the list.
 * The time complexity of this operation is O(n) in the worst case, where n is the number of nodes in the list.
 * The space complexity is O(1) since we are not using any additional data structures that grow with the input size.
 */



 class Solution {
    // Function to insert a node before tail of a doubly linked list
    public ListNode insertBeforeTail(ListNode head, int X) {
        // Edge case
        if (head.next == null) {
            // Create new node with data as X
            ListNode newHead = new ListNode(X, head, null);
            head.prev = newHead;
            return newHead;
        }

        // Create pointer tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Keep track of node before tail using prev
        ListNode prev = tail.prev;

        // Create new node with value X
        ListNode newNode = new ListNode(X, tail, prev);

        // Join the new node
        prev.next = newNode;
        tail.prev = newNode;

        // Return updated linked list
        return head;
    }
}