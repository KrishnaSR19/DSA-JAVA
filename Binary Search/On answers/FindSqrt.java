/*
 *Q. Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).
 */
/*

 * Brute-I
 * Time Complexity:O(N1/2), where N is the given number. Since we are using linear search, and the loop iterates up to sqrt(N) before breaking out.
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    public long floorSqrt(long n) {
        long ans = 0;
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
}

/*
 * Brute-II
 * Time Complexity:O(N1/2), where N is the given number. Since we are using
 * linear search, and the loop iterates up to sqrt(N) 
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    public long floorSqrt(long n) {
        for (long i = 1; i < (n / 2); i++) {
            if (n / i == i)
                return i;

        }
        return -1;
    }
}


/*
 * Optimal
 * Time Complexity:O(logN), where N is the given number. We are basically using the Binary Search algorithm.
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    public long floorSqrt(long n) {
        long low = 1, high = n;
        
        // Binary search on the answer space
        while (low <= high) {
            long mid = (long)(low + high) / 2;
            long val = mid * mid;
            
            // Check if val is less than or equal to n
            if (val <= (long)(n)) {
                // Move to the right part
                low = (int)(mid + 1);
            } else {
                // Move to the left part
                high = (int)(mid - 1);
            }
        }
        
        // Return the floor of square root
        return high;
    }
}


 