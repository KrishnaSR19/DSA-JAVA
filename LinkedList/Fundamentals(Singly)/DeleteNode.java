/* (Medium)
 * Q.Delete a node in a singly linked list given only access to that node.
 * * Note: The node to be deleted is not the tail node.
 * * This solution does not return the head of the list, as it is not needed.
 */

 class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}