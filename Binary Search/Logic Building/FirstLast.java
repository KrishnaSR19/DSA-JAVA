/*
 * Q.Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].
 */

/*
 * Brute Force
 * Time Complexity: O(N), where N is the size of the given array. This is because we are performing a linear search through the array to find the first and last occurrences of the target element.

Space Complexity: O(1), as we are not using any extra space that grows with the input size. We are only using a few additional variables to store indices and results.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }

        return new int[] { first, last };

    }
}

/*
 * Better(using bounds)
 * Time Complexity: 2*O(log N), where N is the size of the given array. Both the
 * lowerBound and upperBound functions perform a binary search, which operates
 * in logarithmic time. Thus, the overall time complexity is O(log N).
 * 
 * Space Complexity: O(1), as we are using a constant amount of extra space
 * regardless of the input size. The space used by the variables low, high, mid,
 * and ans does not depend on the size of the input array.
 */
class Solution {
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstOcc = lowerBound(nums, target);
        if (firstOcc == nums.length || nums[firstOcc] != target)
            return new int[] { -1, -1 };
        int lastOcc = upperBound(nums, target) - 1;
        return new int[] { firstOcc, lastOcc };
    }
}



/*
 * Optimal(Binary Search)
 * Time Complexity: O(log N), where N is the size of the given array. Both the firstOccurrence and lastOccurrence functions perform a binary search, which operates in logarithmic time. Thus, the overall time complexity is O(log N).

Space Complexity: O(1), as we are using a constant amount of extra space regardless of the input size. The space used by the variables low, high, mid, first, and last does not depend on the size of the input array.
 */

 class Solution{
    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;  
            } else if(nums[mid] < target) {
                low = mid + 1;  
            } else {
                high = mid - 1;  
            }
        }
        return first;
    }

    private int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if(nums[mid] < target) {
                low = mid + 1;  
            } else {
                high = mid - 1; 
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target); 
        if(first == -1) return new int[]{-1, -1};  
        int last = lastOccurrence(nums, target);  
        return new int[]{first, last};  
    }
}