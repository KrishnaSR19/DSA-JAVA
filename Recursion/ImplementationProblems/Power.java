/*
 * Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.
 */

/*
 * Time Complexity: O(n), where n is the exponent. The loop runs n times to compute the power.
Space Complexity: O(1), as the algorithm uses a constant amount of extra space regardless of the input size.
 */

class Solution {
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0)
            return 1;

        long temp = n; // to avoid integer overflow

        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;

        for (long i = 0; i < temp; i++) {
            // Multiply ans by x for n times
            ans *= x;
        }
        return ans;
    }
}

/*
 *  Using recursion:
 * Time Complexity : The time complexity is O(log N) due to the halving of n in
 * the even case and linear reduction in the odd case.
 * Space Complexity :The space complexity is O(log n) because of the recursive
 * call stack depth.
 */

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0)
            return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

/*
 * Optimal using iterative approach:
 * Time Complexity: O(log N), where N is the absolute value of the exponent. The algorithm reduces the problem size by half in each iteration.
 * Space Complexity: O(1), as it uses a constant amount of space for variables.
 */

class Solution {
    public double myPow(double x, int n) {
        long N = n; // Convert to long to safely handle Integer.MIN_VALUE

        if (N < 0) {
            x = 1 / x;     // Take reciprocal
            N = -N;        // Make exponent positive
        }

        double result = 1.0;

        while (N > 0) {
            if ((N % 2) == 1) {
                result *= x; // If the current bit is 1, multiply result by x
            }
            x *= x;          // Square the base
            N /= 2;          // Right-shift the exponent (divide by 2)
        }

        return result;
    }
}

