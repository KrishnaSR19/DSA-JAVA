/*
 *Q. Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k
 */

/*
 * Brute Force
 Time Complexity: O(N3), where N is the size of the array. This is because we are using three nested loops, each running approximately N times.

Space Complexity: O(1) since we are not using any additional space.
 */

import java.util.HashMap;
import java.util.Map;

public int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int cnt = 0;

    // Step 1: Generate subarrays
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int xorr = 0;
            /*
             * Step 2: Calculate XOR of
             * all elements in the subarray
             */
            for (int K = i; K <= j; K++) {
                xorr = xorr ^ nums[K];
            }
            // Step 3: Check XOR and count
            if (xorr == k)
                cnt++;
        }
    }
    return cnt;
}

/*
 * Better
 * Time Complexity: O(N2), where N is the size of the array. Since we are using
 * two nested loops, each running for N times, the time complexity will be
 * approximately O(N2).
 * Space Complexity: O(1) as we are not using any additional space.
 */

public int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int cnt = 0;

    // Step 1: Generate subarrays
    for (int i = 0; i < n; i++) {
        int xorr = 0;
        for (int j = i; j < n; j++) {
            /*
             * Step 2: Calculate XOR of
             * all elements in the subarray
             */
            xorr = xorr ^ nums[j];

            // Step 3: Check XOR and count
            if (xorr == k)
                cnt++;
        }
    }
    return cnt;
}

/*
 * Optimal
 * Time Complexity: O(N) or O(NxlogN), where N is the size of the array. If we
 * use an unordered_map in C++, the time complexity is O(N). However, with a map
 * data structure, the time complexity is O(NxlogN). In the worst case for an
 * unordered_map, the searching time can increase to O(N), making the overall
 * time complexity O(N2).
 * 
 * Space Complexity: O(N), as we are using a map data structure.
 */

public int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int xr = 0;
    Map<Integer, Integer> mpp = new HashMap<>();
    // setting the value of 0.
    mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        // prefix XOR till index i:
        xr = xr ^ nums[i];

        // By formula: x = xr ^ k:
        int x = xr ^ k;

        // add the occurrence of xr ^ k to the count:
        cnt += mpp.getOrDefault(x, 0);

        // Insert the prefix xor till index i into the map:
        mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
    }
    return cnt;
}
