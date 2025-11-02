/*
 * Climbing Stairs
 * Problem Statement: You are climbing a staircase with n steps. You can take either 1 or 2 steps at a time.
 * Write a function to determine how many distinct ways you can climb to the top of the staircase.
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top:
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Constraints:
 * 1 <= n <= 45
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


lass Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) return n;

        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2

        // Bottom-up calculation
        for (int i = 3; i <= n; i++) {
            int current = first + second; // ways(n) = ways(n-1) + ways(n-2)
            first = second;   // move one step forward
            second = current;
        }

        return second; // final answer
    }
}
