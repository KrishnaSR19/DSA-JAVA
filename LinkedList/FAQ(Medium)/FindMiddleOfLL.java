/*
 * Q.Given the head of a singly Linked List, return the middle node of the Linked List.
If the Linked List has an even number of nodes, return the second middle one.
 */

class Solution {
    // Function to get the middle node of linked list
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode temp = head;
        int count = 0;

        // Traverse the linked list
        while (temp != null) {
            count += 1; // Increment the count by one
            temp = temp.next;
        }

        int midPosition = (count) / 2 + 1;

        ListNode middleNode = head;
        for (int i = 1; i < midPosition; i++) {
            middleNode = middleNode.next;
        }

        return middleNode;
    }
}