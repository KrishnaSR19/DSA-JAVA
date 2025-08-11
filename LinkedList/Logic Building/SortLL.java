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
      if (temp.val == 0) count0++;
      else if (temp.val == 1) count1++;
      else count2++;

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
