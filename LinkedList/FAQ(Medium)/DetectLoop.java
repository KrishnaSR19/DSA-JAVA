/*
 *Q.Given the head of a singly linked list. Return true if a loop exists in the linked list or return false.
A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index(0-based) of the node from where the loop starts. Note that pos is not passed as a parameter.
 */


/*
 * Brute Force(HashSet)
 * Time Complexity: O(N * 2 * log(N)) The algorithm traverses the linked list once, performing hashmap insertions and searches in the while loop for each node. The insertion and search operations in the unordered_map have a worst-case time complexity of O(log(N)). As the loop iterates through N nodes, the total time complexity is determined by the product of the traversal (O(N)) and the average-case complexity of the hashmap operations (insert and search), resulting in O(N * 2 * log(N)).

Space Complexity: O(N) The code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional space, where 'N' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize a pointer 'temp'
        // At the head of the linked list
        ListNode temp = head;

        // Create a map to keep track of
        // Encountered nodes
        HashMap<ListNode, Integer> nodeMap = new HashMap<>();

        // Traverse the linked list
        while (temp != null) {
            // If the node is already in the
            // Map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node
            // In the map
            nodeMap.put(temp, 1);

            // Move to the next node
            temp = temp.next;
        }

        // If the list is successfully traversed
        // Without a loop, return false
        return false;
    }
}

/*
 * Optimal(Two Pointers)
 * Time Complexity: O(N), where N represents the number of nodes in the linked
 * list. In the worst-case scenario, the fast pointer, which advances more
 * quickly, will either reach the end of the list (if there's no loop) or catch
 * up to the slow pointer (if there's a loop) in a time proportional to the
 * length of the list.
 * 
 * The reason this complexity is O(N) and not slower is due to the fact that
 * each step of the algorithm decreases the gap between the fast and slow
 * pointers (when they are within the loop) by one node. Thus, the maximum
 * number of steps required for them to meet is directly related to the number
 * of nodes in the list.
 * 
 * Space Complexity: O(1) The algorithm utilizes a constant amount of additional
 * space, regardless of the size of the linked list. This efficiency is achieved
 * by using only two pointers (slow and fast) to detect the loop, without
 * needing any significant extra memory, resulting in a constant space
 * complexity of O(1).
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, slow and fast,
        // to the head of the linked list
        ListNode slow = head;
        ListNode fast = head;
        // Step 2: Traverse the linked list with
        // the slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
            // Check if slow and fast pointers meet
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        // If fast reaches the end of the list,
        // there is no loop
        return false;
    }
}
