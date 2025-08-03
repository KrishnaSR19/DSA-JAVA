/*
 * Q.Given the head of a singly Linked List. Traverse the entire Linked List and return its elements in an array in the order of their appearance.
 * 
 */



class Solution {
     //Function for Linked List Traversal
    public List<Integer> LLTraversal(ListNode head) {
        //Storing a copy of the linked list
        ListNode temp = head;
        //To store the values sequentially
        List<Integer> ans = new ArrayList<>();
        
        //Keep traversing
        //Until null is encountered
        while (temp != null) {
            //Storing the values
            ans.add(temp.val);
            //Storing the address of the next node
            temp = temp.next;
        }
        //Return answer
        return ans;
    }
}
