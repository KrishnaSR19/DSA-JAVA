/*
 * Q.Given the head of a singly linked list and an integer X, delete the node with value X and return the head of the modified list.
 */


class Solution {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        // Check if list is empty
        if (head == null)
            return head;

        // If first node has target value, delete
        if (head.val == X) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        /* Traverse the list to find 
        the node with the target value */
        while (temp != null) {
            if (temp.val == X) {
                // Adjust the pointers
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}

/*
 * Optimized
 */
class Solution {
  public ListNode deleteByValue(ListNode head, int value) {
    // Case 1: The head node contains the value
    if (head != null && head.val == value) {
      return head.next;
    }

    ListNode current = head;
    // Traverse to find the node whose next has the target value
    while (current != null && current.next != null) {
      if (current.next.val == value) {
        current.next = current.next.next; // Delete the node
        break; // Stop after deleting the first match
      }
      current = current.next;
    }

    return head;
  }
}
