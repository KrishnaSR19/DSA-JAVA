/*
 * Q.Given the head of a singly linked list. Group all the nodes with odd
 * indices followed by all the nodes with even indices and return the reordered
 * list.
 * Consider the 1st node to have index 1 and so on. The relative order of the
 * elements inside the odd and even group must remain the same as the given
 * input.
 */

import java.util.*;

// Definition of singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Check if list is empty or has only one node
        if (head == null || head.next == null)
            return head;
        // To store values
        List<Integer> array = new ArrayList<>();
        ListNode temp = head;
        /*
         * Traverse the list, skipping one node,
         * and store values in the vector
         */
        while (temp != null && temp.next != null) {
            array.add(temp.val);
            temp = temp.next.next;
        }
        /*
         * If there's an even number
         * of nodes, add the value
         * of the last node
         */
        if (temp != null)
            array.add(temp.val);

        // Reset temp
        temp = head.next;
        /*
         * Traverse the list again, skipping one node,
         * and store values
         * in the vector
         */
        while (temp != null && temp.next != null) {
            array.add(temp.val);
            temp = temp.next.next;
        }
        /*
         * If there's an odd number
         * of nodes, add the
         * value of the last node
         */
        if (temp != null)
            array.add(temp.val);

        // Reset temp
        temp = head;
        int i = 0;
        // Update node values
        while (temp != null) {
            temp.val = array.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}

/*
 * Optimal
 * Time Complexity: O(N/2)x2 ~ O(N) because we are iterating over the
 * odd-indexed as well as the even-indexed elements. Here N is the size of the
 * given linked list.
 * Space Complexity: O(1) because we have not used any extra space.
*/

class Solution {
    // Function to rearrange nodes
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        /*Initialize pointers for odd 
        and even nodes and keep 
        track of the first even node*/
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;
        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        /* Connect the last odd 
       node to the first even node*/
        odd.next = firstEven;
        return head;
    }
}

/*
 * optimized
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save start of even list

        while (even != null && even.next != null) {
            odd.next = even.next; // link odd to next odd
            odd = odd.next; // move odd pointer

            even.next = odd.next; // link even to next even
            even = even.next; // move even pointer
        }

        odd.next = evenHead; // join odd list with even list
        return head;
    }
}

