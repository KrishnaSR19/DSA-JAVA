/*
 * Shortest Job First (SJF) Scheduling Algorithm
 * Given an array of job times, the task is to find the average waiting time
 * using the Shortest Job First (SJF) scheduling algorithm.
 * In SJF, the job with the smallest execution time is selected next.
 * This algorithm minimizes the average waiting time for a set of jobs.
 * Example:
 * Input: [3, 1, 4, 3, 2]
 * Output: 3
 * Explanation:
 * Sorted job times: [1, 2, 3, 3, 4]
 * Waiting times: [0, 1, 3, 6, 9]
 * Average waiting time = (0 + 1 + 3 + 6 + 9) / 5 = 3.8
 * Time Complexity: O(N log N) due to sorting the job times.
 * Space Complexity: O(1) if sorting is done in place, otherwise O(N).
 */


class Solution {
    public long solve(int[] bt) {
        // Sort jobs in ascending order
        Arrays.sort(bt);

        // Initialize total waiting time
        long waitTime = 0;
        // Initialize total time taken
        long totalTime = 0;
        // Get number of jobs
        int n = bt.length;

        // Iterate to calculate waiting time
        for (int i = 0; i < n; ++i) {
            waitTime += totalTime;
            totalTime += bt[i];
        }

        // Return average waiting time
        return waitTime / n;
    }
}
