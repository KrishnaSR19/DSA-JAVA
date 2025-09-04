/*
 * Q. Given the head of a linked list, rotate the list to the right by k places.
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

/*Brute Force 
 * Time Complexity: O(NxK) because for K times, we are iterating through the entire list to get the last element and move it to the first position. Here, N represents the number of nodes in the linked list, and K is the number of steps by which the list has to be rotated.
  Space Complexity: O(1) because no extra data structure is required for computation.
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        // Perform rotation k times
        for (int i = 0; i < k; i++) {
            ListNode temp = head;
            // Find the second last node
            while (temp.next.next != null)
                temp = temp.next;
            // Get the last node
            ListNode end = temp.next;
            // Break the link between
            // second last and last node
            temp.next = null;
            // Make the last node
            // as new head
            end.next = head;
            head = end;
        }
        return head;
    }
}
