class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow

            if (nums[mid] == target) {
                return mid; // target found
            } else if (nums[mid] < target) {
                low = mid + 1; // search in right half
            } else {
                high = mid - 1; // search in left half
            }
        }

        // target not found → return the insert position
        return low;
    }
}
