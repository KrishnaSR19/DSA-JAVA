/*
 * (Hard)
 * Minimize Max Distance to Gas Station
 * Given a sorted array arr of size n, containing integer positions of n gas
 * stations on the X-axis, and an integer k, place k new gas stations on the
 * X-axis.
 * The new gas stations can be placed anywhere on the non-negative side of the
 * X-axis, including non-integer positions.
 * Let dist be the maximum distance between adjacent gas stations after adding
 * the k new gas stations.
 * Find the minimum value of dist.
 */

/*
 * Brute Force
Time Complexity:O(k*N) + O(N), N is size of the given array, k is number of gas stations to be placed. O(k*N) to insert k gas stations between the existing stations with maximum distance. Another O(N) for finding the answer i.e. the maximum distance.
Space Complexity: O(N-1), As an array is used to keep track of placed gas stations.
 */

class Solution {
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;

        /*
         * Array to store how many gas
         * stations are placed in each section
         */
        int[] howMany = new int[n - 1];

        // Pick and place k gas stations
        for (int gasStations = 1; gasStations <= k; gasStations++) {

            double maxSection = -1;
            int maxInd = -1;

            /*
             * Find the maximum section
             * and insert the gas station
             */
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);

                /*
                 * Update the maximum section
                 * length and its index
                 */
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            /*
             * Insert the current gas
             * station into the section
             */
            howMany[maxInd]++;
        }

        // Find the maximum distance i.e. the answer:
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
}
