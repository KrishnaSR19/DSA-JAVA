/*
 * Q.Given the head of a singly Linked List, return the middle node of the Linked List.
If the Linked List has an even number of nodes, return the second middle one.
 */

/*
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
Firstly the size of the linked list is determined which takes O(N) time. Then traversing to the middle nodes takes another O(N/2) time. Thus the overall time complexity is O(N) + O(N/2) or O(3N/2) or O(N).
Space Complexity: O(1), as only a couple of variables are used.
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

/*
 * Optimal Solution
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * Space Complexity: O(1)
 */

class Solution {
    // Function to get the middle node of linked list
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Until the fast pointer reaches NULL or the last node
        while (fast != null && fast.next != null) {
            // Move slow pointer by one step
            slow = slow.next;

            // Move fast pointer by two steps
            fast = fast.next.next;
        }

        return slow;
    }
}
