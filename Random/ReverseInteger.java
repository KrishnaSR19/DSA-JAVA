/*
 * Reverse Integer
 * Problem Link: https://leetcode.com/problems/reverse-integer/
 * Description: Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
 * Input: x = 123
 *  Output: 321
 * Example 2:       
 * Input: x = -123
 * Output: -321
 *
 */

 /*
  * Time Complexity: O(log10(x)), where x is the input integer. This is because we are processing each digit of the number.
  * Space Complexity: O(1), as we are using a constant amount of space for
  */



class Solution {
    public int reverse(int x) {
        int rev = 0; // Variable to store the reversed number

        while (x != 0) {
            int digit = x % 10; // Extract the last digit
            x /= 10;            // Remove the last digit from x

            // Check for overflow before multiplying and adding
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7))
                return 0; // Return 0 if it would overflow positive 32-bit int
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0; // Return 0 if it would overflow negative 32-bit int

            rev = rev * 10 + digit; // Append the digit to the reversed number
        }

        return rev; // Return the final reversed number
    }
}
