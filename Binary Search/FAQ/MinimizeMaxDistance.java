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

/*
 * Better Approach
 * Time Complexity:O(NlogN + klogN), N is size of the given array, k = no. of
 * gas stations to be placed. As, the insert operation of priority queue takes
 * logN time complexity. O(NlogN) for inserting all the indices with distance
 * values and O(klogN) for placing the gas stations.
 * 
 * Space Complexity:O(N-1)+O(N-1). The first O(N-1) is for the array to keep
 * track of placed gas stations and the second one is for the priority queue.
 */
class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        // Max heap of double[]: [distance, sectionIndex]
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n - 1; i++) {
            double dist = arr[i + 1] - arr[i];
            pq.offer(new double[] { dist, i });
        }

        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double[] top = pq.poll();

            int secInd = (int) top[1];
            howMany[secInd]++;

            double initialDist = arr[secInd + 1] - arr[secInd];
            double newSecLen = initialDist / (howMany[secInd] + 1);

            pq.offer(new double[] { newSecLen, secInd });
        }

        return pq.peek()[0];
    }
}

/*
 * Optimal
 * Time Complexity:O(N*log(Len)) + O(N), N is size of the given array, Len is
 * length of the answer space. Binary search is being applied on the answer
 * space. For every possible answer, the function numberOfGasStationsRequired()
 * is called, which has a time complexity of O(N). Additionally, O(N) time
 * complexity is incurred initially for finding the maximum distance.
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    /*
     * Function to calculate the number of gas
     * stations required for given distance
     */
    private int numberOfGasStationsRequired(double dist, int[] arr) {
        // Size of the array
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {

            /*
             * Calculate number of gas stations
             * needed between two points
             */
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);

            // Adjust if exact distance fits perfectly
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }

            cnt += numberInBetween;
        }
        return cnt;
    }

    /*
     * Function to minimize the maximum
     * distance between gas stations
     */
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        /*
         * Find the maximum distance between
         * consecutive gas stations
         */
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        /*
         * Apply Binary search to find the
         * minimum possible maximum distance
         */
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfGasStationsRequired(mid, arr);

            /*
             * Adjust the search range based on
             * the number of gas stations required
             */
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        // Return smallest maximum distance found
        return high;
    }
}