/*
 * Q.Given the head of a singly linked list and an integer n. Remove the nth node from the back of the linked List and return the head of the modified list. The value of n will always be less than or equal to the number of nodes in the linked list.
 */

/*
 * Time Complexity: O(L) + O(L-N) We are calculating the length of the linked list and then iterating up to the (L-N)th node of the linked list, where L is the total length of the list and N is the position of the node to delete.
Space Complexity: O(1) as we have not used any extra space.
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (cnt == n) {
            ListNode newHead = head.next;
            return newHead;
        }
        int res = cnt - n;
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }
        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        return head;
    }
}
