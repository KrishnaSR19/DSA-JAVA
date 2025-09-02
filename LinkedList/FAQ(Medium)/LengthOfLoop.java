/*
 * Q.Given the head of a singly linked list, find the length of the loop in the linked list if it exists. Return the length of the loop if it exists; otherwise, return 0.
A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer. Internally, pos is used to denote the index (0-based) of the node from where the loop starts.
Note that pos is not passed as a parameter.
 */


 /*
  * Brute Force
  Time Complexity: O(N) because the code traverses the entire linked list at least once, where 'N' is the number of nodes in the list.
Space Complexity: O(N) because the code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional space, where 'N' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.
  */
class Solution {
    // Function to find length
    public int findLengthOfLoop(ListNode head) {
        // HashMap to store visited nodes and their timer values
        HashMap<ListNode, Integer> visitedNodes = new HashMap<>();
        // Initialize pointer to traverse the linked list
        ListNode temp = head;
        // Initialize timer
        // to track visited nodes
        int timer = 0;
        // Traverse the linked list
        // till temp reaches null
        while (temp != null) {
            // If revisiting a node return difference of timer values
            if (visitedNodes.containsKey(temp)) {
                // Calculate the length of the loop
                int loopLength = timer - visitedNodes.get(temp);

                // Return length of loop
                return loopLength;
            }
            /*
             * Store the current node
             * and its timer value in
             * the HashMap
             */
            visitedNodes.put(temp, timer);
            // Move to the next node
            temp = temp.next;
            // Increment the timer
            timer++;
        }
        /**
         * If traversal is completed
         * and we reach the end
         * of the list (null)
         * means there is no loop
         */
        return 0;
    }
}


/*
 * Optimal
 * Time Complexity: O(N) because the code traverses the entire linked list once, where 'N' is the number of nodes in the list.
Space Complexity: O(1) because the code uses only a constant amount of additional space, regardless of the linked list's length. This is achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in constant space complexity, O(1).
 */
class Solution {
    // Function to find the length of the loop
    int findLength(ListNode slow, ListNode fast) {
        // Count to keep track of nodes encountered in loop
        int cnt = 1;
        
        // Move fast by one step
        fast = fast.next;
        
        // Traverse fast till it reaches back to slow
        while (slow != fast) {
            /* At each node 
            increase count by 1
            move fast forward 
            by one step */
            cnt++;
            fast = fast.next;
        }
        
        /* Loop terminates 
        when fast reaches slow again 
        and the count is returned*/
        return cnt;
    }

    // Function to find the length of the loop
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // If the slow and fast pointers meet
            // there is a loop
            if (slow == fast) {
                // return the number of nodes 
                return findLength(slow, fast);
            }
        }

        /* If the fast pointer 
        reaches the end, 
        there is no loop */
        return 0;
    }
}

