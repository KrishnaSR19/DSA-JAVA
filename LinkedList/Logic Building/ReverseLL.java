/*
 * Given the head of a singly linked list. Reverse the given linked list and return the head of the modified list.
 */

/*
 * Iterative
 *Time Complexity: O(N) because the algorithm traverses the entire linked list once, where 'N' is the number of nodes in the list. Since each node is visited exactly once during the traversal, the time complexity is linear, O(N).

Space Complexity: O(1) because the algorithm uses only a constant amount of additional space. This is achieved by utilizing three pointers (prev, temp, and front) to reverse the list without any significant extra memory usage, resulting in constant space complexity, O(1).
 */
class Solution {
    /*
     * Function to reverse a linked list
     * Using the 3-pointer approach
     */
    public ListNode reverseList(ListNode head) {
        /*
         * Initialize 'temp' at
         * head of linked list
         */
        ListNode temp = head;

        /*
         * Initialize pointer 'prev' to NULL,
         * representing the previous node
         */
        ListNode prev = null;

        /*
         * Traverse the list, continue till
         * 'temp' reaches the end (NULL)
         */
        while (temp != null) {
            /*
             * Store the next node in
             * 'front' to preserve the reference
             */
            ListNode front = temp.next;

            /*
             * Reverse the direction of the
             * current node's 'next' pointer
             * to point to 'prev'
             */
            temp.next = prev;

            /*
             * Move 'prev' to the current
             * node for the next iteration
             */
            prev = temp;

            /*
             * Move 'temp' to the 'front' node
             * advancing the traversal
             */
            temp = front;
        }

        /*
         * Return the new head of
         * the reversed linked list
         */
        return prev;
    }
}
