/*
 * Given the head of a special linked list of n nodes where each node contains an additional pointer called 'random' which can point to any node in the list or null.
Construct a deep copy of the linked list where,
n new nodes are created with corresponding values as original linked list.
The random pointers point to the corresponding new nodes as per their arrangement in the original list.
Return the head of the newly constructed linked list.
Note: For custom input, a n x 2 matrix is taken with each row having 2 values:[ val, random_index] where,
val: an integer representing ListNode.val
random_index: index of the node (0 - n-1) that the random pointer points to, otherwise -1.
 */

/*
 * Brute Force Approach: Using HashMap
 Time Complexity: O(2N) because the linked list is traversed twice, once for creating copies of each node and for the second time to set the next and random pointers for each copied node. The time to access the nodes in the map is O(1) due to hashing. Here N is the length of the Linked List.
Space Complexity: O(N)+O(N) where N is the number of nodes in the linked list as all nodes are stored in the map to maintain mappings and the copied linked list takes O(N) space as well.
 */

class Solution {
    public ListNode copyRandomList(ListNode head) {
        // If the head is null, return null
        if (head == null)
            return null;

        /*
         * Create a HashMap to map
         * original nodes to their corresponding copied nodes
         */
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode temp = head;

        // Create copies of each node
        while (temp != null) {
            // Create new node with same value as original
            ListNode newNode = new ListNode(temp.val);
            // Map to original node
            map.put(temp, newNode);
            // Move to next node
            temp = temp.next;
        }

        // Reset temp
        temp = head;

        /*
         * Connect the next and
         * random pointers of the
         * copied nodes using the map
         */
        while (temp != null) {
            // Get copied node from the map
            ListNode copyNode = map.get(temp);
            /*
             * Set next pointer of copied node
             * to the copied node of the next
             * original node
             */
            copyNode.next = map.get(temp.next);
            /*
             * Set the random pointer of the
             * copied node to the copied node of
             * the random original node
             */
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        // Return the head
        return map.get(head);
    }
}

/*
 * Time Complexity: O(3N) where N is the number of nodes in the linked list:
 * First traversal to create copies of the nodes and insert them between the
 * original nodes.
 * Second traversal to set the random pointers of the copied nodes to their
 * corresponding copied nodes.
 * Third traversal to separate the copied nodes from the original nodes.
 * Space Complexity: O(N) where N is the number of nodes in the linked list as
 * the only extra space allocated is to create the copied list without creating
 * any other additional data structures.
 */
class Solution {
    // Insert a copy of each node in between the original nodes
    void insertCopyInBetween(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode nextElement = temp.next;
            // Create a new node with the same data
            ListNode copy = new ListNode(temp.val);

            copy.next = nextElement;

            temp.next = copy;

            temp = nextElement;
        }
    }

    // Function to connect random pointers of the copied nodes
    void connectRandomPointers(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            // Access the copied node
            ListNode copyNode = temp.next;

            /*
             * If the original node has a random pointer
             * point the copied node's random to the
             * corresponding copied random node
             * set the copied node's random to null
             * if the original random is null
             */
            if (temp.random != null) {

                copyNode.random = temp.random.next;
            } else {

                copyNode.random = null;
            }

            // Move to next original node
            temp = temp.next.next;
        }
    }

    // Function to retrieve the deep copy of the linked list
    ListNode getDeepCopyList(ListNode head) {
        ListNode temp = head;
        // Create a dummy node
        ListNode dummyNode = new ListNode(-1);
        // Initialize a result pointer
        ListNode res = dummyNode;

        while (temp != null) {
            /*
             * Creating a new List by
             * pointing to copied nodes
             */
            res.next = temp.next;
            res = res.next;

            /*
             * Disconnect and revert back
             * to the initial state of the
             * original linked list
             */
            temp.next = temp.next.next;
            temp = temp.next;
        }

        /*
         * Return the deep copy
         * of the list starting
         * from the dummy node
         */
        return dummyNode.next;
    }

    // Function to clone the linked list
    ListNode copyRandomList(ListNode head) {
        // If the original list is empty, return null
        if (head == null)
            return null;

        // Insert nodes in between
        insertCopyInBetween(head);
        // Connect random pointers
        connectRandomPointers(head);
        // Retrieve deep copy of linked list
        return getDeepCopyList(head);
    }
}
