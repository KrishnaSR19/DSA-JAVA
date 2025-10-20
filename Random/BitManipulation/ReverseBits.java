public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result left to make space for the next bit
            result |= (n & 1);     // Append the LSB of n to result
            n >>= 1;               // Shift n right to process the next bit
        }
        return result;
    }
}
