/*
 * Q.Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. Check whether the linked list values form a palindrome or not. Return true if it forms a palindrome, otherwise, return false.
A palindrome is a sequence that reads the same forward and backwards.
 */

/*
 * Brute Force
 * Time Complexity: O(N + N/2) because the loop traverses the entire linked list once to count the total number of nodes then the loop iterates halfway through the linked list to reach the middle node. Hence, the time complexity is O(N + N/2) ~ O(N).
Space Complexity: O(1) because the code uses a constant amount of extra space regardless of the size of the linked list. It doesn't use any additional data structures in proportion to the input size.
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

/*
 * Optimal(Reversing with help of Recursion)
 * Time Complexity: O(N/2) because the code traverses the linked list using the
 * Tortoise and Hare approach. The code increments both 'slow' and 'fast'
 * pointers at different rates, effectively covering about half the list before
 * reaching the midpoint, hence the time complexity of the algorithm is O(N/2) ~
 * O(N).
 * 
 * Space Complexity: O(1) because the code uses a constant amount of extra space
 * regardless of the size of the input (linked list). It doesn't use any
 * additional data structures in proportion to the input size.
 */

class Solution {

    /*
     * Function to reverse a linked list
     * using the recursive approach
     */
    private ListNode reverseLinkedList(ListNode head) {
        /*
         * Check if the list is empty
         * or has only one node
         */
        if (head == null || head.next == null) {
            /*
             * No change is needed;
             * return the current head
             */
            return head;
        }

        /*
         * Reverse the remaining
         * part of the list and get the new head
         */
        ListNode newHead = reverseLinkedList(head.next);

        /*
         * Store the next node in 'front'
         * to reverse the link
         */
        ListNode front = head.next;

        /*
         * Update the 'next' pointer of 'front' to
         * point to the current head, effectively
         * reversing the link direction
         */
        front.next = head;

        /*
         * Set the 'next' pointer of the
         * current head to 'null' to
         * break the original link
         */
        head.next = null;

        /*
         * Return the new head obtained
         * from the recursion
         */
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        /*
         * Check if the linked list is empty
         * or has only one node
         */
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }

        /*
         * Initialize two pointers, slow and fast,
         * to find the middle of the linked list
         */
        ListNode slow = head;
        ListNode fast = head;

        /*
         * Traverse the linked list to find the
         * middle using slow and fast pointers
         */
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step
            slow = slow.next;

            // Move fast pointer two steps
            fast = fast.next.next;
        }

        /*
         * Reverse the second half of the
         * linked list starting from the middle
         */
        ListNode newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        ListNode first = head;

        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            /*
             * Compare data values of
             * nodes from both halves.
             * If values do not match,
             * the list is not a palindrome
             */
            if (first.val != second.val) {
                /*
                 * Reverse the second half
                 * back to its original state
                 */
                reverseLinkedList(newHead);

                // Not a palindrome
                return false;
            }

            // Move the first pointer
            first = first.next;

            // Move the second pointer
            second = second.next;
        }

        /*
         * Reverse the second half
         * back to its original state
         */
        reverseLinkedList(newHead);

        // Linked List is a palindrome
        return true;
    }
}

/*
 * Optimal(Reversing with better time complexity)
 * Time Complexity:
Finding middle → O(n/2)
Reversing → O(n/2)
Comparing → O(n/2)
 Overall → O(n)
Space Complexity:
 O(1) (in-place reversal, no extra structures).
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }

        ListNode current = head;
        while (pre != null) {
            if (pre.val != current.val)
                return false;

            pre = pre.next;
            current = current.next;
        }

        return true;
    }
}