
/*
 * Brute Force
 * Time Complexity: O(N3), where N is the size of the array. Since we are using three nested loops, each running approximately N times.
Space Complexity: O(1), as we are not using any extra space.
 */
public int longestSubarray(int[] nums, int k) {
    int n = nums.length;
    int maxLength = 0;

    // starting index
    for (int startIndex = 0; startIndex < n; startIndex++) {
        // ending index
        for (int endIndex = startIndex; endIndex < n; endIndex++) {
            /*
             * add all the elements of
             * subarray = nums[startIndex...endIndex]
             */
            int currentSum = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                currentSum += nums[i];
            }

            if (currentSum == k) {
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
        }
    }
    return maxLength;
}

/*
 * Brute Force(Optimized)
 * Time Complexity: O(N2), where N is the size of the array. Since we are using
 * 2 nested loops, each running approximately N times.
 * 
 * Space Complexity: O(1), as we are not using any extra space.
 */

public int longestSubarray(int[] nums, int k) {
    int n = nums.length;
    int maxLength = 0;

    // Loop through each starting index
    for (int startIndex = 0; startIndex < n; startIndex++) {
        int currentSum = 0; // running sum from startIndex to endIndex

        // Expand the subarray to the right
        for (int endIndex = startIndex; endIndex < n; endIndex++) {
            currentSum += nums[endIndex]; // add current element

            // Check if the current subarray sum equals k
            if (currentSum == k) {
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
        }
    }

    return maxLength;
}
