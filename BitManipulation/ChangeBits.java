/*
 * Change Bits to 1 in a Number
 * Given a number N, the task is to find two numbers:
    1. The new number whose all bit are set to 1 
    2. The difference between the new number and N.
 */

class Solution {
    static int[] changeBits(int N) {
        // count number of bits in N
        int bits = 0;
        int temp = N;
        while (temp > 0) {
            bits++;
            temp >>= 1; // right shift
        }

        // create newNum with all 1's up to that bit length
        int newNum = (1 << bits) - 1;

        int diff = newNum - N;

        return new int[]{diff, newNum};
    }
}
