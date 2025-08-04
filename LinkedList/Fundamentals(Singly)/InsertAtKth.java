/*
 * Q. Insert a node at the Kth position of a singly linked list.
 * Given a singly linked list and an integer X, insert a new node with value X at the Kth position.
 * The function should return the head of the modified list.
 */


class Solution {
public ListNode insertAtKthPosition(ListNode head, int X, int K) {
    ListNode el = new ListNode(X);
    // If inserting at the head (position 1)
    if (K == 1) {
        el.next = head;
        return el;
    }
    ListNode current = head;
    int count = 1;

    // Traverse to the (K-1)th node or until end of list
    while (current != null && count < K - 1) {
        current = current.next;
        count++;
    }

    // If current is null, K is out of bounds (do nothing or handle error)
    if (current == null) {
        // Optionally, you can throw an exception or just return head
        return head;
    }

    el.next = current.next;
    current.next = el;

    return head;
}

}