/*
 Given a node's reference within a doubly linked list, remove that node from the linked list while preserving the list's integrity.
You will only be given the node's reference, not the head of the list. It is guaranteed that the given node will not be the head of the list. For the custom testcase, give the index(0-indexed) of the node to be removed.
 */

class Solution {
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode front = node.next;
        // Edge case if the given node is the tail node
        if (front == null) {
            prev.next = null;
            node.prev = null;
            return;
        }
        // Disconnect node
        prev.next = front;
        front.prev = prev;
        // Set node's pointers to null
        node.next = null;
        node.prev = null;
    }
}

/*
 * for all test cases
 */

class Solution {
    public void deleteGivenNode(ListNode node) {

        ListNode prev = node.prev;
        ListNode front = node.next;
        if (prev == null && front == null)
            return;
        else if (prev == null) {
            front.prev = null;
            node.next = null;
        } else if (front == null) {
            prev.next = null;
            node.prev = null;
        } else {
            prev.next = front;
            front.prev = prev;
            node.next = null;
            node.prev = null;
        }
    }
}
