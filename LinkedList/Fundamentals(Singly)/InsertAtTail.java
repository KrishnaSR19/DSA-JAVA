/*
 * Q. Insert a node at the tail of a singly linked list.
 * Given a singly linked list and an integer X, insert a new node with value X at the end of the list.
 * The function should return the head of the modified list.
 */


 class Solution {
    public ListNode insertAtTail(ListNode head, int X) {

        if(head==null){
             ListNode tail = new ListNode(X);
             tail.next=null;
              head=tail;
             return head;
        }
        ListNode tail = new ListNode(X);
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next=tail;
        tail.next=null;
        return head;
    
    }
}
