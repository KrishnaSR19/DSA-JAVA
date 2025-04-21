package Arrays.Fundamentals;

//Q.Given a binary array nums, return the maximum number of consecutive 1s in the array.
/*
 *Time Complexity: O(N), as there is single traversal of the array .Here N is the number of elements in the array.
Space Complexity: O(1), as no additional space is used .
 */
public class MaxCounsecutive {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
                max = Math.max(max, count);
            } else {
                count = 0;
            }

        }

        return max;

    }

}
