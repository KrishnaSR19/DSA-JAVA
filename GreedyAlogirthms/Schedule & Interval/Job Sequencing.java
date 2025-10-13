
/*
 * Job Sequencing Problem
 * Given an array of jobs where each job has a deadline and a profit associated with it,
 * the task is to find the maximum profit and the number of jobs done
 * such that no two jobs overlap and each job is completed within its deadline.
 * Example:
 * Input: Jobs = [[1, 4, 20], [2, 1, 10], [3, 1, 40], [4, 1, 30]]
 * Output: [2, 60]
 * Explanation:
 * Job 1 and Job 3 can be completed within their deadlines for a total profit of 60.
 * Time Complexity: O(N log N) due to sorting the jobs based on profit. 
 * Space Complexity: O(N) for the hash table to track job assignments.
 * Note: Each job is represented as an array of three integers [jobId, deadline, profit].
 *  
 */
class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        // Sort jobs based on profit in descending order
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Total number of jobs
        int n = Jobs.length;

        // Get the maximum deadline to complete the jobs
        int maxDeadline = -1;
        for (int[] it : Jobs) {
            maxDeadline = Math.max(maxDeadline, it[1]);
        }

        // Initialize a hash table to store selected jobs
        int[] hash = new int[maxDeadline + 1];
        Arrays.fill(hash, -1);

        // Initialize count
        int cnt = 0;

        // Initialize the total profit earned
        int totalProfit = 0;

        // Iterate over each job
        for (int i = 0; i < n; i++) {

            /* Iterate over each deadline slot 
            starting from the job's deadline */
            for (int j = Jobs[i][1] - 1; j >= 0; j--) {

                // If the current deadline slot is available 
                if (hash[j] == -1) {
                    cnt++; // Count of selected jobs
                    hash[j] = Jobs[i][0]; // Mark the job as selected
                    totalProfit += Jobs[i][2]; // Update the total profit

                    // Move to the next job
                    break;
                }
            }
        }

        // Return the array
        return new int[]{cnt, totalProfit};
    }
}