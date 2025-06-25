/*
 * Q.Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.
 */

/*
 * Brute Force
 * Time Complexity: O(N*logN)
The for loop runs takes O(M) time and calculating Pow(x, N) takes O(logN) time. However, since the for loop breaks as soon as the result of Pow(x, N) becomes greater than the M, thus, the for loops actually runs only for N iterations making overall complexity as O(N*logN).
Space Complexity: O(1), as there are only a couple of variables used.
 */
public int NthRoot(int N, int M) {
    // Linear search on the answer space
    for (int i = 1; i <= M; i++) {
        long val = Pow(i, N);

        /*
         * Check if the computed
         * value is equal to M
         */
        if (val == M) {
            // Return the root value
            return i;
        } else if (val > M) {
            break;
        }
    }
    // Return -1 if no root found
    return -1;
}

/*
 * Optimal
 * Time Complexity: O(logM * logN)
 * The binary search on the search space (of size M) takes O(logM) and the
 * helper function takes O(logN) taking overall O(logM * logN).
 * 
 * Space Complexity: O(1), as there are only a couple of variables used.
 */

class Solution {
    // Helper function to check mid^N compared to M
    private int helperFunc(int mid, int n, int m) {
        long ans = 1, base = mid;

        while (n > 0) {
            if (n % 2 == 1) {
                ans *= base;
                if (ans > m)
                    return 2; // Early exit
                n--;
            } else {
                n /= 2;
                base *= base;
                if (base > m)
                    return 2;
            }
        }
        if (ans == m)
            return 1;
        return 0;
    }

    // Function to find the Nth root of M using Binary Search
    public int NthRoot(int N, int M) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = helperFunc(mid, N, M);

            if (midN == 1)
                return mid; // Found exact root
            else if (midN == 0)
                low = mid + 1; // Move right
            else
                high = mid - 1; // Move left
        }
        return -1; // No integer root found
    }
}
