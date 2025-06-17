
/*
 * Brute Force
 * Time Complexity: O(N3), where N is the size of the array. Since we are using three nested loops, each running approximately N times.
Space Complexity: O(1), as we are not using any extra space.
 */

import java.util.HashMap;
import java.util.Map;

public int longestSubarray(int[] nums, int k) {
    int n = nums.length;
    int maxLength = 0;

    // starting index
    for (int startIndex = 0; startIndex < n; startIndex++) {
        // ending index
        for (int endIndex = startIndex; endIndex < n; endIndex++) {
            /*
             * add all the elements of
             * subarray = nums[startIndex...endIndex]
             */
            int currentSum = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                currentSum += nums[i];
            }

            if (currentSum == k) {
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
        }
    }
    return maxLength;
}

/*
 * Brute Force(Optimized)
 * Time Complexity: O(N2), where N is the size of the array. Since we are using
 * 2 nested loops, each running approximately N times.
 * 
 * Space Complexity: O(1)
 */

public int longestSubarray(int[] nums, int k) {
    int n = nums.length;
    int maxLength = 0;

    // Loop through each starting index
    for (int startIndex = 0; startIndex < n; startIndex++) {
        int currentSum = 0; // running sum from startIndex to endIndex

        // Expand the subarray to the right
        for (int endIndex = startIndex; endIndex < n; endIndex++) {
            currentSum += nums[endIndex]; // add current element

            // Check if the current subarray sum equals k
            if (currentSum == k) {
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
        }
    }

    return maxLength;
}

/*
 * Better(positives + negatives)
 * Time Complexity: O(N) or O(NxlogN) depending on the map data structure used,
 * where N is the size of the array. For example, using an unordered_map in C++
 * gives a time complexity of O(N) (though in the worst case, unordered_map
 * takes O(N) to find an element, making the time complexity O(N2)). If we use a
 * map data structure, the time complexity is O(NxlogN). The best case
 * complexity is O(N) as we are traversing the array with a loop.
 * 
 * Space Complexity: O(N), since we are using a map data structure.
 */

public int longestSubarray(int[] nums, int k) {
    int n = nums.length;

    Map<Integer, Integer> preSumMap = new HashMap<>();
    int sum = 0;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
        // calculate the prefix sum till index i
        sum += nums[i];

        // if the sum equals k, update maxLen
        if (sum == k) {
            maxLen = Math.max(maxLen, i + 1);
        }

        // calculate the sum of remaining part i.e., sum - k
        int rem = sum - k;

        // calculate the length and update maxLen
        if (preSumMap.containsKey(rem)) {
            int len = i - preSumMap.get(rem);
            maxLen = Math.max(maxLen, len);
        }

        // update the map if sum is not already present
        if (!preSumMap.containsKey(sum)) {
            preSumMap.put(sum, i);
        }
    }

    return maxLen;
}


/*
 * Optimal(works for positive only)
 * Time Complexity: O(N), where N is the size of the array.
There are two pointers left and right which traverse the array at once taking linear time.

Space Complexity: O(1), as only a couple of variables are used.
 * 
 */

    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers to mark the start and end of window
        int left = 0, right = 0;

        // To store the sum of elements in the window
        int sum = nums[0];

        // Traverse all the elements
        while (right < n) {

            // If the sum exceeds K, shrink the window
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Store the maximum length
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) sum += nums[right];
        }

        return maxLen;
    }
}


