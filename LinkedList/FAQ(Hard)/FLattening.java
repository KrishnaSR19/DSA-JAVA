/*
 * Given a special linked list containing n head nodes where every node in the linked list contains two pointers:
‘Next’ points to the next node in the list
‘Child’ pointer to a linked list where the current node is the head
Each of these child linked lists is in sorted order and connected by a 'child' pointer.
Flatten this linked list such that all nodes appear in a single sorted layer connected by the 'child' pointer and return the head of the modified list.
 */

/*Brute Force
 * Time Complexity:
We traverse all nodes → O(N×M).
Sorting the collected elements → O(N×M log(N×M)).
Reconstructing the linked list → O(N×M).
Total = O(N×M log(N×M)), since sorting dominates.
Space Complexity:
Extra array to store all elements → O(N×M).
Rebuilding the list also uses → O(N×M).
Total = O(N×M).
 */

class Solution {
    // Function to convert a vector to a linked list
    private ListNode convertArrToLinkedList(List<Integer> arr) {
        /*
         * Create a dummy node to serve as
         * the head of the linked list
         */
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        /*
         * Iterate through the vector and
         * create nodes with vector elements
         */
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the vector element
            temp.child = new ListNode(arr.get(i));

            // Update the temporary pointer
            temp = temp.child;
        }

        /*
         * Return the linked list starting
         * from the next of the dummy node
         */
        return dummyNode.child;
    }

    // Function to flatten a linked list with child pointers
    public ListNode flattenLinkedList(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        // Traverse through the linked list
        while (head != null) {
            /*
             * Traverse through the child
             * nodes of each head node
             */
            ListNode t2 = head;

            while (t2 != null) {
                // Store each node's data in the array
                arr.add(t2.val);

                // Move to the next child node
                t2 = t2.child;
            }
            // Move to the next head node
            head = head.next;
        }

        // Sort the array containing node values
        Collections.sort(arr);

        // Convert the sorted array back to a linked list
        return convertArrToLinkedList(arr);
    }
}

/*
 * Optimal
 * Time Complexity: O(Nx(2M)) ~ O(2NxM) where N is the length of the linked list
 * along the next pointer and M is the length of the linked list along the child
 * pointers.
 * 
 * The merge operation in each recursive call takes time complexity proportional
 * to the length of the linked lists being merged as they have to iterate over
 * the entire lists. Since the vertical depth of the linked lists is assumed to
 * be M, the time complexity for a single merge operation is proportional to
 * O(2M).
 * This operation is performed N number of times (to each and every node along
 * the next pointer list) hence the resultant time complexity becomes O(Nx2M).
 * Space Complexity: O(1) as this code uses no external space or additional data
 * structures to store values. But a recursive stack uses O(N) space to build
 * the recursive calls for each node along the next pointer list.
 */

class Solution {
    private ListNode merge(ListNode list1, ListNode list2) {
        /*
         * Create a dummy node as a
         * placeholder for the result
         */
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        // Connect the remaining elements if any
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    // Function to flatten a linked list with child pointers
    public ListNode flattenLinkedList(ListNode head) {
        // If head is null or there is no next node
        if (head == null || head.next == null) {
            return head; // Return head
        }

        // Recursively flatten the rest of the linked list
        ListNode mergedHead = flattenLinkedList(head.next);

        // Merge the lists
        head = merge(head, mergedHead);
        return head;
    }
}
