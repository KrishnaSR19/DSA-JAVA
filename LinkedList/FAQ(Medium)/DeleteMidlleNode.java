/*
 * Given the head of a non-empty singly linked list containing integers, delete the middle node of the linked list. Return the head of the modified linked list.
The middle node of a linked list of size n is the (⌊n / 2⌋ + 1)th node from the start using 1-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 */

class Solution {
    // Function to delete middle node of linked list
    public ListNode deleteMiddle(ListNode head) {
        /*
         * Edge case: if the list is empty
         * or has only one node, return null
         */
        if (head == null || head.next == null) {
            return null;
        }

        // Temporary node to traverse
        ListNode temp = head;

        // Variable to store number of nodes
        int n = 0;

        /*
         * Loop to count the number of nodes
         * in the linked list
         */
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Index of the middle node
        int middleIndex = n / 2;

        // Reset temporary node
        // to beginning of linked list
        temp = head;

        /*
         * Loop to find the node
         * just before the middle node
         */
        for (int i = 1; i < middleIndex; i++) {
            temp = temp.next;
        }

        // If the middle node is found
        if (temp.next != null) {
            // Create pointer to the middle node
            ListNode middle = temp.next;

            // Adjust pointers to skip middle node
            temp.next = temp.next.next;

            /*
             * Free the memory allocated
             * to the middle node
             */
            middle = null;
        }

        // Return head
        return head;
    }
}

/*
 * Optimal Solution
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * Space Complexity: O(1), as we are using only a constant amount of extra
 * space.
 * 
 */

import java.util.*;

// Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        /*
         * If the list is empty or has only one node,
         * return null as there is no middle node to delete
         */
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;
        return head;
    }

}
