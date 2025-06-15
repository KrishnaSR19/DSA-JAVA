/*
 * Better
 * Time Complexity: O(NlogN) + O(N), here N is the size of the given array. Here, O(NlogN) is for sorting the array. To find the longest sequence, we use a loop that results in O(N).
 
 Space Complexity: O(1), as we are not using any extra space to solve this problem.
 */

public int longestConsecutive(int[] nums) {

    // Return 0 if array is empty
    if (n == 0)
        return 0;

    Arrays.sort(nums); // Sort the array

    // Track last smaller element
    int lastSmaller = Integer.MIN_VALUE;
    // Count current sequence length
    int cnt = 0;
    // Track longest sequence length
    int longest = 1;

    for (int i = 0; i < n; i++) {
        // If consecutive number exists
        if (nums[i] - 1 == lastSmaller) {
            // Increment sequence count
            cnt += 1;
            // Update last smaller element
            lastSmaller = nums[i];
        }
        // If consecutive number doesn't exist
        else if (nums[i] != lastSmaller) {
            // Reset count for new sequence
            cnt = 1;
            // Update last smaller element
            lastSmaller = nums[i];
        }
        // Update longest if needed
        longest = Math.max(longest, cnt);
    }
    return longest;
}
