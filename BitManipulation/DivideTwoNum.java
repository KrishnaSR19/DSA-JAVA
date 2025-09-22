/*
 *Given the two integers, dividend and divisor. Divide without using the mod, division, or multiplication operators and return the quotient.
The fractional portion of the integer division should be lost as it truncates toward zero.
As an illustration, 8.345 and -2.7335 would be reduced to 8 and -2 respectively.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231. 
 */


/*
 * Time Complexity: O(dividend)
In the worst case when the divisor is 1, the number of iterations taken will be O(dividend).
Space Complexity: O(1) Using a couple of variables i.e., constant space
 */
class Solution {
    public int divide(int dividend, int divisor) {
        // Base case: both numbers equal
        if (dividend == divisor)
            return 1;

        // Handle overflow (Integer.MIN_VALUE / -1)
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Dividing by 1 returns the number itself
        if (divisor == 1)
            return dividend;

        // Determine the sign of the result
        boolean isPositive = !((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0));

        // Convert to long for safety and take absolute values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        // Variables to store result and cumulative sum
        long ans = 0, sum = 0;

        // Brute-force loop: keep subtracting divisor from dividend
        while (sum + d <= n) {
            ans++;
            sum += d;
        }

        // Check for overflow
        if (ans > Integer.MAX_VALUE)
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        // Apply sign and return
        return isPositive ? (int) ans : (int) -ans;
    }
}
