/*
 *Q.Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
 */
/*
 * Time Complexity: O(n), where n is the length of the input array nums.
 * This is because we traverse the array once with three pointers (low, mid, high) to sort the colors. 
 * Space Complexity: O(1), as we are sorting the array in-place without using any
 */


class Solution {
    public void sortColors(int[] nums) {
        // 3 pointers: low, mid, high
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {

                /*
                 * Swap nums[low] and nums[mid], then
                 * move both low and mid pointers forward
                 */
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                // Move mid pointer forward
                mid++;
            } else {
                /*
                 * Swap nums[mid] and nums[high],
                 * then move high pointer backward
                 */
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
