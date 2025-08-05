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