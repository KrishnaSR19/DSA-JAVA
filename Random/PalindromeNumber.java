/*
 * LeetCode Problem: Palindrome Number
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */


/*
 * Time Complexity: O(log10(x)), where x is the input integer. This is because we are processing each digit of the number.
 * Space Complexity: O(1), as we are using a constant amount of space for the reversed number.
 */

class Solution {
    public boolean isPalindrome(int x) {
         if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        return x == reversed || x == reversed / 10;
    }
}
