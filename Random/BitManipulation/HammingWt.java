/*
 * Q.count number of set bits in a given number
 */

/*
 * Time Complexity: O(1)
 * The for loop iterates over a fixed number of bits (32 bits for a standard integer), which is as good as O(1).
 * Space Complexity: O(1) – Using a couple of variables i.e., constant space.
 */
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n&1) !=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}

/*
 * Brian Kernighan’s Algorithm
 * Time Complexity: O(k) where k is the number of set bits in the integer.
 * Space Complexity: O(1) – Using a couple of variables i.e., constant space.
 */

 class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // removes the rightmost set bit
            count++;
        }
        return count;
    }
}
