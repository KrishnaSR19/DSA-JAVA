/*
 * Q.Delete the tail node of a doubly linked list and return the head of the modified list.
 * * Note: The nodes in the doubly linked list have a 'prev' pointer to the previous node and a 'next' pointer to the next node.
 */


 class Solution {
    public ListNode deleteTail(ListNode head) {
        if(head==null || head.next==null) return null;

        ListNode temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;

        return head;

    }
}

/*
 * Hybrid Solution: This solution handles the case where the tail node is deleted from a doubly linked list.
 * It ensures that the previous pointer of the new tail is set correctly and returns the head of the modified list.
 */

 class Solution {
    // Function to delete the tail of a doubly linked list
    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;  
        }
        
        // Navigate to the tail of the linked list
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        // Update the pointers
        ListNode newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        
        // Return head of modified list
        return head;
    }
}