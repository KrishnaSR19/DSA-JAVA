/*
 * QGiven an array of N intervals in the form of (start[i], end[i]), where start[i] is the starting point of the interval and end[i] is the ending point of the interval, return the minimum number of intervals that need to be removed to make the remaining intervals non-overlapping.
Note:
Intervals which only touch at a point are also considered as non-overlapping. For example, [1, 3] and [3, 4] are non-overlapping.
 */
class Solution {
    // Comparator function to compare intervals based on their ending times
    public static int comp(int[] val1, int[] val2) {
        // Compare the ending times of the intervals
        return Integer.compare(val1[1], val2[1]);
    }
    
    // Function to count the maximum number of non-overlapping intervals
    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        // Sort the intervals based on their ending times
        Arrays.sort(intervals, Solution::comp);
    
        // Get total number of intervals
        int n = intervals.length;
    
        // Initialize counter
        int cnt = 1;
    
        // Keep track of the ending time
        int lastEndTime = intervals[0][1];
    
        // Iterate through all intervals
        for (int i = 1; i < n; i++) {
            /* Check if the starting time of the current 
            interval is greater than or equal to 
            the ending time of the last 
            selected interval */
            if (intervals[i][0] >= lastEndTime) {
                // Increment counter
                cnt++;
                // Update the ending time
                lastEndTime = intervals[i][1];
            }
        }
        return n-cnt;
    }
}
