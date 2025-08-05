/*
 * Q.Delete the kth node of a doubly linked list and return the head of the modified list.
 * * Note: The nodes in the doubly linked list have a 'prev' pointer to the previous node and a 'next' pointer to the next node.
 * 
 */


 class Solution {
    // Function to remove the Kth element
    public ListNode deleteKthElement(ListNode head, int k) {
        // If the list is empty, return null
        if (head == null) 
            return null;
    
        int count = 0;
        ListNode kNode = head;

        // Traverse the list
        while (kNode != null) {
            count++;
            if (count == k) break;
            kNode = kNode.next;
        }

        // If k is larger than the list size
        if (kNode == null) return head; 
        
        // Update the pointers
        ListNode prev = kNode.prev;
        ListNode front = kNode.next;

        // If node to be deleted is the only node in the list
        if (prev == null && front == null) {
            return null;
        }
        
        // If node to be deleted is head of the list
        else if (prev == null) {
            head = front;
            front.prev = null;
        }
        
        // If node to be deleted is tail of the list
        else if (front == null) {
            prev.next = null;
        }
        
        // If node to be deleted is in the middle of the list
        else {
            prev.next = front;
            front.prev = prev;
        }

        // Return modified list head
        return head;
    }
}