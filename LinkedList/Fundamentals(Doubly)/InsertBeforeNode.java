/*
 *Q. Given a node in a doubly linked list and an integer X, insert a node with value X before the given node and return nothing.
 *This implementation assumes that the node is not null and is part of a valid doubly linked list.
 *The new node will be inserted before the given node, and the list will be updated accordingly
    *The time complexity of this operation is O(1) since we are directly accessing the node and its previous node.
    *The space complexity is O(1) since we are not using any additional data structures that grow with the input size.
 */

 
class Solution {
    public void insertBeforeGivenNode(ListNode node, int X) {
        ListNode prev = node.prev;
        ListNode newNode = new ListNode(X,node,prev);
        prev.next=newNode;
        node.prev=newNode;
    }
}