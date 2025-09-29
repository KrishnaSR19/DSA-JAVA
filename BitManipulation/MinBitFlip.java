/*
 * Q.Given two integers start and goal. Flip the minimum number of bits of start integer to convert it into goal integer.
A bits flip in the number val is to choose any bit in binary representation of val and flipping it from either 0 to 1 or 1 to 0.
 */

/*
 * Time Complexity: O(1)
The XOR operation between two integers is performed in constant time, O(1).
The for loop iterates over a fixed number of bits (32 bits for a standard integer), which is as good as O(1).
Space Complexity: O(1) – Using a couple of variables i.e., constant space.
 */

class Solution {
    public int minBitsFlip(int start, int goal) {
        /*
         * Variable to store bits that
         * are different in both numbers
         */
        int num = start ^ goal;
        /*
         * Variable to count
         * number of set bits
         */
        int count = 0;
        for (int i = 0; i < 32; i++) {
            /*
             * Update count if the
             * rightmost bit is set
             */
            count += (num & 1);
            /*
             * Shift the number every
             * time by 1 place
             */
            num = num >> 1;                 //also can be done using left shift 
        }
        return count;
    }
}

//bit required to be flipped can also be done using inbuilt function
// class Solution {
//     public int minBitsFlip(int start, int goal) {
//         return Integer.bitCount(start ^ goal);
//     }
// }
