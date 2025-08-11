/*
 * 
 */

/* Brute Force
 * Time Complexity: O(2N) because the code traverses the linked list twice: once while counting the frequency of 0's, 1's, and 2's, and once again while reassigning the values to the nodes. Here, N represents the length of the linked list or the number of nodes present in the linked list.
Space Complexity: O(1) because no extra space is used.
 */

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        int count0 = 0, count1 = 0, count2 = 0;
        while (temp != null) {
            if (temp.val == 0)
                count0++;
            else if (temp.val == 1)
                count1++;
            else
                count2++;

            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (count0 != 0) {
                temp.val = 0;
                count0--;
            } else if (count1 != 0) {
                temp.val = 1;
                count1--;
            } else {
                temp.val = 2;
                count2--;
            }
        }
        return head;
    }
}

/*
 * Optimal
 * Time Complexity: O(N) because the code traverses the linked list once. Here,
 * N represents the length of the linked list or the number of nodes present in
 * the linked list.
 * Space Complexity: O(1) because no extra space is used and we just change the
 * links of the nodes.
 */

class Solution {
    public ListNode sortList(ListNode head) {
        /*
         * If the list is empty or has only one
         * node, return as it is already sorted
         */
        if (head == null || head.next == null)
            return head;

        // Dummy nodes to point to heads of
        // three lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Pointers to current last nodes of
        // three lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        /*
         * Traverse the original list
         * and distribute the nodes
         * into three lists
         */
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.val == 2) {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        // Connect the three lists together
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        // New head of the sorted list
        ListNode newHead = zeroHead.next;

        // Delete dummy nodes
        return newHead;
    }
}
