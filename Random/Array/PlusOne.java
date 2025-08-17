/*
 * Q. Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You need to return a new array representing the increased integer.
 */


 class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // just add 1
                return digits; // no carry, return result
            }
            digits[i] = 0; // if 9, make it 0 and carry over
        }
        
        // If all digits were 9, we reach here
        int[] result = new int[n + 1];
        result[0] = 1; // like 999 + 1 = 1000
        return result;
    }
}
