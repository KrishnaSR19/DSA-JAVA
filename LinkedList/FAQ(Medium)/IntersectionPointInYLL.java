/*
 * Given the heads of two linked lists A and B, containing positive integers. Find the node at which the two linked lists intersect. If they do intersect, return the node at which the intersection begins, otherwise return null.
The Linked List will not contain any cycles. The linked lists must retain their original structure, given as per the input, after the function returns.
 */
/*
 * Brute Force(Using hashing)
 */
class Solution {
    // Function to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Create a hash set to store the nodes
        // Of the first list
        HashSet<ListNode> nodes_set = new HashSet<>();

        // Traverse the first linked list
        // And add all its nodes to the set
        while (headA != null) {
            nodes_set.add(headA);
            headA = headA.next;
        }
        // Traverse the second linked list
        // And check for intersection
        while (headB != null) {
            // If a node from the second list is found in the set,
            // It means there is an intersection
            if (nodes_set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        // No intersection found, return null
        return null;
    }
}
