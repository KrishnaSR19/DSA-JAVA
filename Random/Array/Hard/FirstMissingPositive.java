
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Add all nums into the HashSet
        for (int num : nums) {
            set.add(num);
        }
        // Check from 1 to infinite for the first missing number
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // The function should never reach here
    }
}


/*
 * Optimal
 * Cyclic Approach
 */


 class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Swap numbers to their correct positions
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Determine the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1; // If all numbers 1 to n are present, return n+1
    }
}