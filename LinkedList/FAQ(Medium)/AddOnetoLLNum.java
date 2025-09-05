/*
 * Given the head of a singly linked list representing a positive integer
 * number. Each node of the linked list represents a digit of the number, with
 * the 1st node containing the leftmost digit of the number and so on. The task
 * is to add one to the value represented by the linked list and return the head
 * of a linked list containing the final value.
 * The number will contain no leading zeroes except when the value represented
 * is zero itself.
 */

/*
 * Iterative Solution
 * Time Complexity: O(N) because we traverse the linked list three times, each with a time complexity of O(N), resulting in O(3N), which simplifies to O(N) since constant factors are ignored in Big-O notation. Here, N is the number of nodes in the linked list.
Space Complexity: O(1) because we use a constant amount of extra space for pointers and variables.
 */

class Solution {
    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        // Initialize pointers
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // Store next node
            next = current.next;
            // Reverse the link
            current.next = prev;
            // Move prev to current
            prev = current;
            // Move current to next
            current = next;
        }

        return prev;
    }

    // Function to add one to Linked List
    public ListNode addOne(ListNode head) {
        // Reverse the linked list
        head = reverseList(head);

        // Create a dummy node
        ListNode current = head;
        // Initialize carry with 1
        int carry = 1;

        while (current != null) {
            /*
             * Sum the current node's value
             * and the carry
             */
            int sum = current.val + carry;
            // Update carry
            carry = sum / 10;
            // Update the node's value
            current.val = sum % 10;

            /*
             * If no carry left
             * break the loop
             */
            if (carry == 0) {
                break;
            }

            /*
             * If we've reached the end of the list
             * and there's still a carry,
             * add a new node with the carry value
             */
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                break;
            }

            // Move to the next node
            current = current.next;
        }

        // Reverse the list
        head = reverseList(head);

        // New head
        return head;
    }
}

/*
 * Recursive Solution
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * This is because each node in the linked list is visited exactly once by the
 * recursive addHelper function. The process involves traversing the entire list
 * to reach the end, and then propagating the carry back through each node,
 * resulting in a linear time complexity of O(N).
 * 
 * Space Complexity: O(N), due to the recursion stack. Since the addHelper
 * function calls itself recursively for each node in the list, the maximum
 * depth of the recursion stack is N, where N is the number of nodes in the
 * linked list. This means the space required for the recursion stack grows
 * linearly with the size of the list, leading to a space complexity of O(N).
 */
class Solution {
    // Helper function to add one to the linked list
    private int addHelper(ListNode temp) {
        /*
         * If the list is empty
         * return a carry of 1
         */
        if (temp == null)
            return 1;

        /*
         * Recursively call addHelper
         * For the next node
         */
        int carry = addHelper(temp.next);

        /*
         * Add the carry
         * to the current node's value
         */
        temp.val += carry;

        /*
         * If the current node's value
         * is less than 10
         * no further carry is needed
         */
        if (temp.val < 10)
            return 0;

        /*
         * If the current node's value is 10 or more
         * set it to 0 and return a carry of 1
         */
        temp.val = 0;
        return 1;
    }

    public ListNode addOne(ListNode head) {
        /*
         * Call the helper function
         * to start the addition process
         */
        int carry = addHelper(head);

        /*
         * If there is a carry left
         * after processing all nodes
         * add a new node at the head
         */
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            /* Link the new node to the current head */
            newNode.next = head;
            /* Update the head to the new node */
            head = newNode;
        }
        // Return the head
        return head;
    }
}
