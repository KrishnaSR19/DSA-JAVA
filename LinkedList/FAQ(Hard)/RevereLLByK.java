/*
 *Q.Given the head of a singly linked list containing integers, reverse the nodes of the list in groups of k and return the head of the modified list. If the number of nodes is not a multiple of k, then the remaining nodes at the end should be kept as is and not reversed.
Do not change the values of the nodes, only change the links between nodes.
 */

public ListNode reverseKGroup(ListNode head, int k) {
    /*
     * Initialize a temporary
     * node to traverse the list
     */
    ListNode temp = head;

    /*
     * Initialize a pointer to track
     * the last node of the previous group
     */
    ListNode prevLast = null;

    // Traverse through the linked list
    while (temp != null) {
        // Get the Kth node of the current group
        ListNode kThNode = getKthNode(temp, k);

        /*
         * If the Kth node is NULL
         * (not a complete group)
         */
        if (kThNode == null) {
            /*
             * If there was a previous group,
             * link the last node to the current node
             */
            if (prevLast != null) {
                prevLast.next = temp;
            }

            // Exit the loop
            break;
        }

        /*
         * Store the next node
         * after the Kth node
         */
        ListNode nextNode = kThNode.next;

        /*
         * Disconnect the Kth node
         * to prepare for reversal
         */
        kThNode.next = null;

        // Reverse the nodes from temp to the Kth node
        reverseLinkedList(temp);

        /*
         * Adjust the head if the reversal
         * starts from the head
         */
        if (temp == head) {
            head = kThNode;
        } else {
            /*
             * Link the last node of the previous
             * group to the reversed group
             */
            prevLast.next = kThNode;
        }

        /*
         * Update the pointer to the
         * last node of the previous group
         */
        prevLast = temp;

        // Move to the next group
        temp = nextNode;
    }

    // Return the head of the modified linked list
    return head;
}
