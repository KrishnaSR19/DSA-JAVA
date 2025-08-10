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

// Function to print the linked list
public static void printLL(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
    }
    System.out.println();
}
