/*
 * Magnetic Force Problem
 * * Problem Statement: Given an array of positions of n magnets and an integer m representing the number of magnets to place, find the maximum minimum distance between any two magnets.
 *  * Approach: Use binary search to find the maximum minimum distance.
 * * Time Complexity: O(n log(maxDistance)), where n is the number of magnets and maxDistance is the maximum possible distance between magnets.
 * * Space Complexity: O(1), as we are using a constant amount of space for variables.
 * * Example:
 * Input: positions = [1, 2, 4, 8, 9], m = 3
 * Output: 3
 * * Explanation: The maximum minimum distance between any two magnets is 3, which can be achieved by placing magnets at positions 1, 4, and 8.
 * * Note: The positions array is sorted in ascending order.
 * * Constraints:
 * * 1 <= n <= 10^5
 * * 1 <= positions[i] <= 10^9
 * * 1 <= m <= n
 * * Example:
 * Input: positions = [1, 2, 4, 8, 9], m = 3
 * Output: 3
 * * Explanation: The maximum minimum distance between any two magnets is 3, which can be achieved by placing magnets at positions 1, 4, and 8.
 * 
 */

/*
 * Brute Force
 * * Time Complexity: O(n * limit), where n is the number of positions and limit is the maximum distance between the first and last position.
 * * Space Complexity: O(1), as we are using a constant amount of space for variables.
 */
class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int limit = position[n - 1] - position[0];

        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(position, i, m)) {
                return (i - 1);
            }
        }
        return limit;

    }

    public boolean canWePlace(int[] position, int force, int balls) {
        int n = position.length;
        int cntBalls = 1;
        int last = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - last >= force) {
                cntBalls++;
                last = position[i];
            }
            if (cntBalls >= balls)
                return true;

        }
        return false;
    }
}

/*
 * Optimal Approach using Binary Search
 * * Time Complexity: O(n log(maxDistance)), where n is the number of positions
 * and maxDistance is the maximum possible distance between magnets.
 * * Space Complexity: O(1), as we are using a constant amount of space for
 * variables.
 */

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(position, mid, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canPlaceCows(int[] position, int dist, int cows) {
        int count = 1;
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= dist) {
                count++;
                lastPos = position[i];
            }
            if (count >= cows)
                return true;
        }

        return false;
    }
}