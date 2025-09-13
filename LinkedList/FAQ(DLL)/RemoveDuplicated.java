/*
 * Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.
Return the head of the modified linked list.
 */

class Solution {
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        // Traverse the list
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            // Remove all duplicate nodes
            while (nextNode != null && nextNode.val == temp.val) {
                // Store the duplicate node
                ListNode duplicate = nextNode;
                // Move to the next node
                nextNode = nextNode.next;
                // Delete the duplicate node
                duplicate = null;
            }

            /*
             * Link the current node
             * to the next non-duplicate node
             */
            temp.next = nextNode;
            /*
             * Update previous pointer
             * of next non-duplicate node
             */
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            // Move to the next node
            temp = temp.next;
        }

        return head;
    }
}
