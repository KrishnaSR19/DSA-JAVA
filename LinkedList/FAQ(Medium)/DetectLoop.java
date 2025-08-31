/*
 * 
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