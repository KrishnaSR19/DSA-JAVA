/*
 * Q.Given the head of a singly linked list and an integer X, delete the node with value X and return the head of the modified list.
 */


class Solution {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        // Check if list is empty
        if (head == null)
            return head;

        // If first node has target value, delete
        if (head.val == X) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        /* Traverse the list to find 
        the node with the target value */
        while (temp != null) {
            if (temp.val == X) {
                // Adjust the pointers
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}