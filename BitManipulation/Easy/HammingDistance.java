/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.
    * Example 1: Input: x = 1, y = 4
      Output: 2
      Explanation: The binary representation of 1 is 0001, and the binary representation of 4 is 0100. 
      The positions where the corresponding bits are different are marked in bold.
   
       Time Complexity: O(log(max(x, y))) where x and y are the input integers. This is because the number of bits in the binary representation of a number is proportional to the logarithm of the number itself. The while loop iterates through each bit of the XOR result, which has at most log(max(x, y)) bits.
         Space Complexity: O(1) since we are using a constant amount of space regardless of the input size.
         


 */


 class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;       // XOR highlights differing bits
        int count = 0;

        while (xor != 0) {
            count += xor & 1;  // count the 1-bits
            xor >>= 1;         // shift right
        }

        return count;
    }
}
