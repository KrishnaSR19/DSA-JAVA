class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Create a dummy node before head to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Move 'prev' to the node just before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: 'curr' will start from the 'left' node
        ListNode curr = prev.next;

        // Step 4: Reverse the sublist from left to right
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Step 5: Return the new head
        return dummy.next;
    }
}
