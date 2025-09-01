/*
 * Find the starting point in LL
Given the head of a singly linked list, the task is to find the starting point of a loop in the linked list if it exists. Return the starting node if a loop exists; otherwise, return null.
A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer. Internally, pos denotes the index (0-based) of the node from where the loop starts.
Note that pos is not passed as a parameter.
 */



/*
 * Time Complexity: O(N) The algorithm goes through the entire linked list once, with 'N' representing the total number of nodes. As a result, the time complexity is linear, or O(N).
Space Complexity: O(N) The algorithm utilizes a hash map to store the nodes it encounters. This hash map can store up to 'N' nodes, where 'N' is the total number of nodes in the list. Therefore, the space complexity is O(N) because of the additional space used by the hash map.
 */
class Solution {
    public ListNode findStartingPoint(ListNode head) {
        // Use temp to traverse the linked list
        ListNode temp = head;

        // HashMap to store all visited nodes
        HashMap<ListNode, Integer> map = new HashMap<>();

        // Traverse the list using temp
        while (temp != null) {
            // Check if temp has been encountered again
            if (map.containsKey(temp)) {
                // A loop is detected hence return temp
                return temp;
            }
            // Store temp as visited
            map.put(temp, 1);
            // Move to the next node
            temp = temp.next;
        }

        // If no loop is detected, return null
        return null;
    }
}
