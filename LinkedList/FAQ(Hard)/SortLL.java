

class Solution {
    public ListNode sortList(ListNode head) {
        // ArrayList to store node values
        List<Integer> arr = new ArrayList<>();

        // Temporary pointer to traverse the linked list
        ListNode temp = head;

        /*Traverse linked list and
        store node values in the ArrayList*/
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // Sort ArrayList containing node values
        Collections.sort(arr);

        /*Reassign sorted values
        to linked list nodes*/
        temp = head;
        for (int val : arr) {
            // Update the node's data
            temp.val = val;
            // Move to the next node
            temp = temp.next;
        }

        // Return the head
        return head;
    }
}
