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
