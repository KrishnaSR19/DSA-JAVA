/*
 * Q.Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.
 */

/*
 * Brute Force
 * Time Complexity: O(N) where N is the number of elements in nums. This is because we potentially need to examine each element in the worst case.
Space Complexity: O(1), as we only use a constant amount of additional space regardless of the input size.
 */

public int[] getFloorAndCeil(int[] nums, int x) {
    int floor = -1, ceil = -1;
    for (int num : nums) {
        if (num <= x && num > floor)
            floor = num;
        if (num >= x && (ceil == -1 || num < ceil))
            ceil = num;
    }
    return new int[] { floor, ceil };
}

/*
 * Optimal
 * Time Complexity: O(logN), where N is the size of the given array. We are
 * using the Binary Search algorithm, which divides the search space in half
 * each time, resulting in a logarithmic time complexity.
 * Space Complexity: O(1), as we are not using any extra space to solve this
 * problem.
 */

public int[] getFloorAndCeil(int[] nums, int x) {
    int low = 0, high = nums.length - 1;
    int floor = -1, ceil = -1;

    while (low <= high) {
        int mid = (low + high) / 2;
        if (nums[mid] == x) {
            floor = ceil = nums[mid];
            break;
        } else if (nums[mid] < x) {
            floor = nums[mid];
            low = mid + 1;
        } else {
            ceil = nums[mid];
            high = mid - 1;
        }
    }

    return new int[] { floor, ceil };
}
