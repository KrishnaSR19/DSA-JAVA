/*
 * Given an integer array nums, return a list of all the leaders in the array.
A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.
 */

/*
 * Brute Force
 * 
 */
package Arrays.FAQs;
public class Leaders {
import java.util.*;

    // Function to find leaders in an array.
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Iterate through each element in nums
        for (int i = 0; i < nums.length; i++) {
            boolean leader = true;
            /*
             * Check whether nums[i] is greater
             * than all elements to its right
             */
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    /*
                     * If any element to the right is greater
                     * or equal, nums[i] is not a leader
                     */
                    leader = false;
                    break;
                }
            }
            // If nums[i] is a leader, add it to the ans list
            if (leader) {
                ans.add(nums[i]);
            }
        }
        // Return the leaders
        return ans;
    }
}
