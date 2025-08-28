/*
 * 
 */

/*
 * Brute Force
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        /*
         * Create an empty stack
         * to store values
         */
        Stack<Integer> stack = new Stack<>();

        /*
         * Initialize temporary pointer
         * to the head of the linked list
         */
        ListNode temp = head;

        /*
         * Traverse the linked list
         * and push values onto the stack
         */
        while (temp != null) {
            /*
             * Push the data from
             * the current node onto the stack
             */
            stack.push(temp.val);

            // Move to the next node
            temp = temp.next;
        }

        /*
         * Reset temporary pointer
         * back to the head of
         * the linked list
         */
        temp = head;

        /*
         * Compare values by popping
         * from the stack and checking
         * against linked list nodes
         */
        while (temp != null) {
            if (temp.val != stack.pop()) {
                /*
                 * If values don't match,
                 * it's not a palindrome
                 */
                return false;
            }

            /*
             * Move to the next node
             * in the linked list
             */
            temp = temp.next;
        }

        /*
         * If all values match,
         * it's a palindrome
         */
        return true;
    }
}
