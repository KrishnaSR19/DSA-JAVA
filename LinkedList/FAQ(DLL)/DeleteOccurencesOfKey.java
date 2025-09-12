/*
 * Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.
 */

/*
 * Time Complexity: O(N) because the linked list is traversed only once. Here, N represents the number of nodes in the linked list.
Space Complexity: O(1) because no extra space used.
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
