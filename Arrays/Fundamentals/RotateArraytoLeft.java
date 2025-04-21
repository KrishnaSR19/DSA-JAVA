package Arrays.Fundamentals;

// Q.Given an integer array nums, rotate the array to the left by one.

/*
 * Time Complexity: O(N), where N is the number of elements in the array. Each element is visited once during the iteration.
   Space Complexity: O(1). The space used does not depend on the size of the input array and remains constant.
 */



public class RotateArraytoLeft {
    
    int temp = nums[0];      
    for (int i = 1; i < nums.length; i++) {
        nums[i - 1] = nums[i];
    }
    nums[nums.length - 1] = temp;
}
