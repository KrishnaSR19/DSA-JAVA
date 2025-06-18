/*
 *Q. Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k
 */

/*
 * Brute Force
 Time Complexity: O(N3), where N is the size of the array. This is because we are using three nested loops, each running approximately N times.

Space Complexity: O(1) since we are not using any additional space.
 */

// Function to count the number of subarrays with XOR k
public int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int cnt = 0;

    // Step 1: Generate subarrays
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int xorr = 0;
            /*
             * Step 2: Calculate XOR of
             * all elements in the subarray
             */
            for (int K = i; K <= j; K++) {
                xorr = xorr ^ nums[K];
            }
            // Step 3: Check XOR and count
            if (xorr == k)
                cnt++;
        }
    }
    return cnt;
}
