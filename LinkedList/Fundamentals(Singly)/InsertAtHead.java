/*
 * Q. Given the head of a singly linked list and an integer X, insert a new node with value X at the head of the list.
 * 
 */


class Solution {
    // Function to insert at head
    public ListNode insertAtHead(ListNode head, int X) {
        // Creating a new node 
        ListNode newnode = new ListNode(X);
        
        /* Making next of newly created node to 
        point to the head of the LinkedList */
        newnode.next = head;
        
        // Making newly created node as head
        head = newnode;
        
        // Return the head of modified list
        return head;
    }
}