/*
 * Q. Delete the head of a singly linked list.
 * Given a singly linked list, delete the head node and return the new head of the list
 * If the list is empty, return null.
 * The function should return the head of the modified list.
 */
public class DeleteHead {
    public static ListNode deleteHead(ListNode head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }
}
