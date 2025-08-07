/*
 * LeetCode Problem: Convert an array to a doubly linked list
 * This implementation creates a doubly linked list from an array of integers.  
 * The time complexity is O(n), where n is the number of elements in the array.
 * The space complexity is O(n) for the new nodes created in the linked list.
 */


class Solution {
    public ListNode arrayToLinkedList(int [] nums) {
      ListNode head =new ListNode(nums[0]);
      ListNode prev = head;
      for(int i = 1 ; i < nums.length ; i++){
        ListNode temp = new ListNode(nums[i],null,prev);
        prev.next = temp;
        prev = temp;
      }
      return head;
    }
}