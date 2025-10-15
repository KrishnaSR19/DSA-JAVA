
/*
 * Brute Force
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalCount=0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j <nums.length;j++)
             totalCount += hammingDistance(nums[i],nums[j]);
        }
        return totalCount;

    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y; // XOR highlights differing bits
        int count = 0;

        while (xor != 0) {
            count += xor & 1; // count the 1-bits
            xor >>= 1; // shift right
        }

        return count;
    }
}


/*
 * Optimal
 */


 class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        // check each of 32 bits
        for (int bit = 0; bit < 32; bit++) {
            int ones = 0;

            // count numbers with a '1' at this bit position
            for (int num : nums) {
                ones += (num >> bit) & 1;
            }

            int zeros = n - ones;
            total += ones * zeros; // all differing pairs at this bit
        }

        return total;
    }
}
