/*
 *Q. Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 */

/*
 * Brute Force
 * Time Complexity: O(N3), where N is the size of the array. We are using three nested loops here. Though all loops are not running exactly N times, the time complexity will be approximately O(N3).

Space Complexity: O(1), as we are not using any extra space.
 */
public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    // Number of subarrays
    int cnt = 0;

    // starting index i
    for (int i = 0; i < n; i++) {
        // ending index j
        for (int j = i; j < n; j++) {

            // calculate the sum of subarray [i...j]
            int sum = 0;
            for (int K = i; K <= j; K++)
                sum += nums[K];

            // Increase the count if sum == k:
            if (sum == k)
                cnt++;
        }
    }
    return cnt;
}

/*
 * Brute Force Optimized to O(N2)
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }

        }

        return count;
    }
}
