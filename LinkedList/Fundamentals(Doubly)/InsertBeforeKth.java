/*
 * Q. Given the head of a doubly linked list and an integer K, insert a node with value X before the Kth node of the linked list and return the head of the modified list.
 * This implementation assumes that K is a valid position in the list (1-based index).
 * The new node will be inserted before the Kth node, and the list will be updated accordingly.
 * The time complexity of this operation is O(n) in the worst case, where n is the number of nodes in the list.
 * The space complexity is O(1) since we are not using any additional data structures that grow with the input size.
 */

class Solution {
public:
    /* Function to insert a node before the
    Kth node in a doubly linked list */
    ListNode* insertBeforeKthPosition(ListNode* head, int X, int K) {
        // If node has to be inserted before the head
        if (K == 1) {
            ListNode* newHead = new ListNode(X, head, nullptr);
            head->prev = newHead;
            return newHead;
        }

        // Temporary pointer 
        ListNode* temp = head;

        // Reach kth node
        int count = 0;
        while (temp != nullptr) {
            count++;
            
            // If kth node is reached, Break out of the loop
            if (count == K) break;
            
            // Otherwise Keep moving temp forward
            temp = temp->next;
        }
        
        // Track the node 
        ListNode* prev = temp->prev;

        // Create new node with data as X
        ListNode* newNode = new ListNode(X, temp, prev);

        // Join new node 
        prev->next = newNode;
        temp->prev = newNode;

        // Return head 
        return head;
    }
}
;
