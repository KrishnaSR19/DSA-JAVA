/*
 * Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * 
 */

/*
 * Brute Force Approach
 Time Complexity: O(N1 + N2) + O(N log N) + O(N) where N1 is the number of linked list nodes in the first list, N2 is the number of linked list nodes in the second list, and N is the total number of nodes (N1 + N2). Traversing both lists into the array takes O(N1 + N2), sorting the array takes O((N1 + N2) X log(N1 + N2)), and then traversing the sorted array and creating a list gives us another O(N1 + N2).

Space Complexity: O(N) + O(N) where N is the total number of nodes from both lists (N1 + N2). O(N) to store all the nodes of both the lists in an external array and another O(N) to create a new combined list.
 */

class Solution {
    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        // Add elements from list1 to the vector
        while (temp1 != null) {
            arr.add(temp1.val);
            // Move to the next node in list1
            temp1 = temp1.next;
        }

        // Add elements from list2 to the vector
        while (temp2 != null) {
            arr.add(temp2.val);
            // Move to the next node in list2
            temp2 = temp2.next;
        }

        // Sorting the vector in ascending order
        Collections.sort(arr);

        // Sorted vector to linked list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        for (int i = 0; i < arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }

        // Return the head of
        // merged sorted linked list
        return dummyNode.next;
    }
}
